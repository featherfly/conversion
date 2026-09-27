
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-09-25 00:48:25
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.conversion.codegen;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import cn.featherfly.common.bean.BeanDescriptor;
import cn.featherfly.common.bean.BeanProperty;
import cn.featherfly.common.lang.ClassLoaderUtils;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.Str;
import cn.featherfly.common.structure.ChainMapImpl;
import cn.featherfly.conversion.codegen.MethodMetadata.MethodType;

/**
 * BeanConvertorGenerator.
 *
 * @author zhongj
 */
public class BeanConvertorGenerator {

    private final BeanCodegen beanCodegen;

    private final Class<?> source;

    private final Class<?> target;

    private final List<MethodMetadata> methods = new ArrayList<>();

    private boolean staticClass = true;

    private String sourceName = "source";

    private String targetName = "target";

    private static final String DEFAULT_CLASS_TEMPLATE = "package {packageName};\n\n/**\n * {sourceType} to {targetType} convertor\n */\npublic {static}class {className} {\n{content}\n}";
    private String classTemplate;

    /**
     * Instantiates a new bean convertor generator.
     *
     * @param iterableElementBeanCodegen the bean codegen
     * @param source the source
     * @param target the target
     */
    public BeanConvertorGenerator(BeanCodegen beanCodegen, Class<?> source, Class<?> target) {
        super();
        this.beanCodegen = beanCodegen;
        this.source = source;
        this.target = target;

        methods.add(new MethodMetadataImpl("copy", staticClass ? MethodType.STATIC_METHOD : MethodType.METHOD, true));

        try {
            classTemplate = new String(Files.readAllBytes(new File(ClassLoaderUtils
                .getResource(
                    ClassUtils.packageToDir(BeanConvertorGenerator.class.getPackage().getName()) + "/BeanConvertor")
                .getPath()).toPath()));
        } catch (Exception e) {
            classTemplate = DEFAULT_CLASS_TEMPLATE;
        }
    }

    private List<ConvertibleProperty> properties(BeanDescriptor<?> sourceBeanDescriptor,
        BeanDescriptor<?> targetBeanDescriptor) {
        List<ConvertibleProperty> properties = new ArrayList<>();
        for (BeanProperty<?, ?> sbp : sourceBeanDescriptor.getBeanProperties()) {
            if (!targetBeanDescriptor.hasBeanProperty(sbp.getName())) {
                continue;
            }
            BeanProperty<?, ?> tbp = targetBeanDescriptor.getBeanProperty(sbp.getName());
            TypeMetadata sourceTypeMetadata;
            TypeMetadata targetTypeMetadata;
            if (ClassUtils.isCellection(sbp.getType())) {
                sourceTypeMetadata = new TypeMetadataImpl(sbp.getType(), sbp.getGenericType());
            } else {
                sourceTypeMetadata = new TypeMetadataImpl(sbp.getType());
            }
            if (ClassUtils.isCellection(tbp.getType())) {
                targetTypeMetadata = new TypeMetadataImpl(tbp.getType(), tbp.getGenericType());
            } else {
                targetTypeMetadata = new TypeMetadataImpl(tbp.getType());
            }
            properties.add(new ConvertiblePropertyImpl(sbp.getName(), sourceTypeMetadata, targetTypeMetadata));
        }
        return properties;
    }

    public String generate(String className) {
        StringBuilder src = new StringBuilder();
        for (MethodMetadata method : methods) {
            src.append(beanCodegen.generateToTarget(method, source.getName(), target.getName(),
                properties(BeanDescriptor.getBeanDescriptor(source), BeanDescriptor.getBeanDescriptor(target)),
                sourceName, targetName)) //
                .append("\n") //
                // reverse source type - target type
                .append(beanCodegen.generateToTarget(method, target.getName(), source.getName(),
                    properties(BeanDescriptor.getBeanDescriptor(target), BeanDescriptor.getBeanDescriptor(source)),
                    sourceName, targetName)) //
                .append("\n");

            if (!method.isGivenArgument()) {
                continue;
            }
            src.append(beanCodegen.generateToTarget(new MethodMetadataImpl(method.name(), method.methodType(), false),
                source.getName(), target.getName(),
                indent -> indent
                    + Str.format("return {0}({1}, new {2}());", method.name(), sourceName, target.getName()),
                sourceName, targetName)).append("\n") //
                // reverse source type - target type
                .append(beanCodegen.generateToTarget(new MethodMetadataImpl(method.name(), method.methodType(), false),
                    target.getName(), source.getName(),
                    indent -> indent
                        + Str.format("return {0}({1}, new {2}());", method.name(), sourceName, source.getName()),
                    sourceName, targetName));
        }
        String name = StringUtils.substringAfterLast(className, ".");
        return Str.format(classTemplate,
            new ChainMapImpl<String, String>().set("packageName", StringUtils.substringBeforeLast(className, ".")) //
                .set("className", name) //
                .set("static", staticClass ? "final " : "") //
                .set("constructor", String.format("    %s %s() {}", staticClass ? "private" : "public", name))
                .set("sourceType", source.getName()) //
                .set("targetType", target.getName()) //
                .set("content", src.toString()));
    }
}
