package com.github.hyang214.stone.lang;

/**
 * title: 常量
 *
 * @author Hao YANG
 * @since 2020.10.04
 */
public class Constant {

    /**
     * 换行符
     */
    public static final String EOL = "\\n";

    /**
     * 空格正则
     */
    public static final String BLANK_PATTERN = "\\s*";

    /**
     * 注释正则
     */
    public static final String COMMENT_PATTERN = "//.*";

    /**
     * 标识符正则
     */
    public static final String IDENTIFIER_PATTERN = "[A-Z_a-z][A-Z_a-z0-9]*|==|<=|>=|&&\\|\\|\\p{Punct}";

    /**
     * 数字正则
     */
    public static final String NUMBER_PATTERN = "[0-9]+";

    /**
     * 字符串正则
     */
    public static final String STRING_PATTERN = "\"(\\\"|\\\\\\\\|\\\\n|[^\"])*\"";

    /**
     * token正则格式
     */
    public static final String TOKEN_PATTERN_FORMAT = "%s(%s|%s|%s|%s)?";

    /**
     * token正则
     */
    public static final String TOKEN_PATTERN = String.format(TOKEN_PATTERN_FORMAT,
            BLANK_PATTERN, COMMENT_PATTERN, IDENTIFIER_PATTERN, NUMBER_PATTERN, STRING_PATTERN);

}
