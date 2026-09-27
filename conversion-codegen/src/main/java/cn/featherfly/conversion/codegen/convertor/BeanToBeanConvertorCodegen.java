
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-04-22 17:48:22
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.conversion.codegen.convertor;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import cn.featherfly.common.bean.BeanDescriptor;
import cn.featherfly.common.bean.BeanProperty;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.Str;
import cn.featherfly.conversion.codegen.BeanCodegen;
import cn.featherfly.conversion.codegen.CodegenUtils;
import cn.featherfly.conversion.codegen.ConvertibleProperty;
import cn.featherfly.conversion.codegen.ConvertiblePropertyImpl;
import cn.featherfly.conversion.codegen.ConvertorCodegen;
import cn.featherfly.conversion.codegen.TypeMetadata;
import cn.featherfly.conversion.codegen.TypeMetadataImpl;

/**
 * bean to bean convertor codegen.
 *
 * @author zhongj
 * @since 0.1.0
 */
public class BeanToBeanConvertorCodegen extends AbstractConvertorCodegen implements ConvertorCodegen {

    private final boolean instantiateObject;

    private final int indentStart;

    private final BeanCodegen beanCodegen;

    /**
     * Instantiates a new bean to bean convertor codegen.
     *
     * @param beanCodegen the bean codegen
     * @param sourceType the source type
     * @param targetType the target type
     * @param indentStart the indent start
     */
    public BeanToBeanConvertorCodegen(BeanCodegen beanCodegen, Class<?> sourceType, Class<?> targetType,
        int indentStart) {
        this(beanCodegen, sourceType, targetType, indentStart, false);
    }

    /**
     * Instantiates a new bean to bean convertor codegen.
     *
     * @param beanCodegen the bean codegen
     * @param sourceType the source type
     * @param targetType the target type
     * @param indentStart the indent start
     * @param inverse the inverse
     */
    public BeanToBeanConvertorCodegen(BeanCodegen beanCodegen, Class<?> sourceType, Class<?> targetType,
        int indentStart, boolean inverse) {
        this(beanCodegen, CodegenUtils.getClassName(sourceType), CodegenUtils.getClassName(targetType), indentStart,
            inverse, false);
    }

    /**
     * Instantiates a new bean to bean convertor codegen.
     *
     * @param beanCodegen the bean codegen
     * @param sourceType the source type
     * @param targetType the target type
     * @param indentStart the indent start
     * @param inverse the inverse
     * @param instantiateObject the instantiate object
     */
    public BeanToBeanConvertorCodegen(BeanCodegen beanCodegen, Class<?> sourceType, Class<?> targetType,
        int indentStart, boolean inverse, boolean instantiateObject) {
        this(beanCodegen, CodegenUtils.getClassName(sourceType), CodegenUtils.getClassName(targetType), indentStart,
            inverse, instantiateObject);
    }

    /**
     * Instantiates a new bean to bean convertor codegen.
     *
     * @param beanCodegen the bean codegen
     * @param sourceType the source type
     * @param targetType the target type
     * @param indentStart the indent start
     */
    public BeanToBeanConvertorCodegen(BeanCodegen beanCodegen, String sourceType, String targetType, int indentStart) {
        this(beanCodegen, sourceType, targetType, indentStart, false);
    }

    /**
     * Instantiates a new bean to bean convertor codegen.
     *
     * @param beanCodegen the bean codegen
     * @param sourceType the source type
     * @param targetType the target type
     * @param indentStart the indent start
     * @param inverse the inverse
     */
    public BeanToBeanConvertorCodegen(BeanCodegen beanCodegen, String sourceType, String targetType, int indentStart,
        boolean inverse) {
        this(beanCodegen, sourceType, targetType, indentStart, inverse, false);
    }

    /**
     * Instantiates a new bean to bean convertor codegen.
     *
     * @param beanCodegen the bean codegen
     * @param sourceType the source type
     * @param targetType the target type
     * @param indentStart the indent start
     * @param inverse the inverse
     * @param instantiateObject the instantiate object
     */
    public BeanToBeanConvertorCodegen(BeanCodegen beanCodegen, String sourceType, String targetType, int indentStart,
        boolean inverse, boolean instantiateObject) {
        super(sourceType, targetType);
        AssertIllegalArgument.isNotNull(beanCodegen, "iterableElementBeanCodegen");
        this.instantiateObject = instantiateObject;
        this.beanCodegen = beanCodegen;
        this.indentStart = indentStart;
        //        if (Lang.isEmpty(toSourceName)) {
        //            this.toSourceName = CodegenUtils.getNewConstructor(sourceType);
        //        } else {
        //            this.toSourceName = toSourceName;
        //        }
        //        if (Lang.isEmpty(toTargetName)) {
        //            this.toTargetName = CodegenUtils.getToTypeMethod(targetType);
        //        } else {
        //            this.toTargetName = toTargetName;
        //        }
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public String generateToTarget(String source, String target) {
    //        if (inverse) {
    //            return generate(targetType, sourceType, source, source, true);
    //        }
    //        return generate(sourceType, targetType, source, source, true);
    //        //        if (inverse) {
    //        //            return Str.format("{0}({1})", toSourceName, source);
    //        //        }
    //        //        return Str.format("{0}.{1}()", source, toTargetName);
    //    }
    /**
     * {@inheritDoc}
     */
    @Override
    public String generateToTarget(String source, String target) {
        if (inverse) {
            return generate(targetType, sourceType, target, source, true);
        }
        return generate(sourceType, targetType, source, target, true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String generateToSource(String target, String source) {
        if (inverse) {
            return generate(targetType, sourceType, target, source, false);
        }
        return generate(sourceType, targetType, source, target, false);
        //        if (inverse) {
        //            return Str.format("{0}.{1}()", target, toTargetName);
        //        }
        //        return Str.format("{0}({1})", toSourceName, target);
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

    /**
     * Generate.
     *
     * @param sourceObjectType the source object type
     * @param targetObjectType the target object type
     * @param sourceObjectName the source object name
     * @param targetObjectName the target object name
     * @param toTarget the to target
     * @return the string
     */
    public String generate(String sourceObjectType, String targetObjectType, String sourceObjectName,
        String targetObjectName, boolean toTarget) {
        StringBuilder src = new StringBuilder();
        BeanDescriptor<?> sourceDescriptor = BeanDescriptor.getBeanDescriptor(ClassUtils.forName(sourceObjectType));
        BeanDescriptor<?> targetDescriptor = BeanDescriptor.getBeanDescriptor(ClassUtils.forName(targetObjectType));
        if (toTarget) {
            String targetAccess = targetObjectName;
            if (instantiateObject) {
                String indent = CodegenUtils.getIndent(indentStart);
                targetAccess = "target" + StringUtils.substringAfterLast(targetObjectType, ".") + "Element";
                src.append(Str.format("{0}{1} = new {2}();\n", indent, targetObjectName, targetObjectType));
                src.append(Str.format("{0}{1} {2} = {3};\n", indent, targetObjectType, targetAccess, targetObjectName));
            }
            src.append(beanCodegen.generateToTarget(null, sourceObjectType, targetObjectType,
                properties(sourceDescriptor, targetDescriptor), sourceObjectName, targetAccess));
        } else {
            String sourceAccess = sourceObjectName;
            if (instantiateObject) {
                String indent = CodegenUtils.getIndent(indentStart);
                sourceAccess = "source" + StringUtils.substringAfterLast(sourceObjectType, ".") + "Element";
                src.append(Str.format("{0}{1} = new {2}();\n", indent, sourceObjectName, sourceObjectType));
                src.append(Str.format("{0}{1} {2} = {3};\n", indent, sourceObjectType, sourceAccess, sourceObjectName));
            }
            src.append(beanCodegen.generateFromTarget(null, sourceObjectType, targetObjectType,
                properties(sourceDescriptor, targetDescriptor), sourceAccess, targetObjectName));
        }
        if (src.charAt(src.length() - 1) == '\n') {
            src.deleteCharAt(src.length() - 1);
        }
        return src.toString();
    }
}
