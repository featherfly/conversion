
package cn.featherfly.conversion.parse;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import cn.featherfly.common.constant.Chars;
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

        int index = content.indexOf("\r\n");
        int symbolSize = 2;
        if (index == -1) {
            symbolSize = 1;
            index = content.indexOf('\r');
        }
        if (index == -1) {
            index = content.indexOf('\n');
        }
        if (index != -1) {
            if (hasLetter(content, index)) {
                className = org.apache.commons.lang3.StringUtils.substring(content, 0, index);
                yamlContent = org.apache.commons.lang3.StringUtils.substring(content, index + symbolSize);
            } else {
                yamlContent = content;
            }
            objContent.className = Str.trim(className);
            objContent.content = trimContent(yamlContent);
            objContent.isMulty = objContent.content.charAt(0) == '-';
            return objContent;
        }
        throw new ParseException("yaml：协议后没有换行符（\r\n，\r，\n）");
    }

    private boolean hasLetter(String content, int index) {
        for (int i = 0; i < index; i++) {
            if (Character.isLetter(content.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private String trimContent(String content) {
        StringBuilder result = new StringBuilder();
        String[] lines = null;
        if (content.contains("\r\n")) {
            lines = content.split("\r\n");
        } else if (content.contains(Chars.CARRIAGE_RETURN)) {
            lines = content.split(Chars.CARRIAGE_RETURN);
        } else {
            lines = content.split(Chars.NEW_LINE);
        }
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
