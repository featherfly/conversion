
package cn.featherfly.conversion.parse;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import cn.featherfly.common.lang.Str;
import cn.featherfly.common.lang.reflect.Type;

/**
 * json协议解析器抽象类.
 *
 * @author 钟冀
 * @param <G> 解析的目标类型描述
 */
public abstract class YamlParser<G extends Type<?>> extends JacksonParser<G> {

    /** 协议字符串常量. */
    public static final String PROTOCOL = "yaml";

    /**
     * Instantiates a new yaml parser.
     */
    protected YamlParser() {
        super(new ObjectMapper(new YAMLFactory()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Content getContent(String content) {
        Content objContent = new Content();
        String className = null;
        String yamlContent = null;
        int index = content.indexOf("#{");
        if (index == -1) {
            index = content.indexOf("#[");
            objContent.isMulty = index != -1;
        }
        content = content.trim();
        if (index != -1) {
            className = org.apache.commons.lang3.StringUtils.substring(content, 0, index);
            yamlContent = org.apache.commons.lang3.StringUtils.substring(content, index + 3, content.length() - 1);
        } else {
            yamlContent = content;
        }

        objContent.className = Str.trim(className);
        objContent.content = trimContent(yamlContent);
        return objContent;
    }

    private String trimContent(String content) {
        StringBuilder result = new StringBuilder();
        String[] lines = content.split("\n");
        List<String> newLines = new ArrayList<>();
        for (String line : lines) {
            if (Str.isNotBlank(line)) {
                newLines.add(line);
            }
        }
        String firstLine = newLines.get(0);
        int first = firstLine.length() - Str.trimStart(firstLine).length();
        for (String line : newLines) {
            result.append(line.substring(first)).append("\n");
        }
        return result.toString().trim();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getProtocol() {
        return PROTOCOL;
    }
}
