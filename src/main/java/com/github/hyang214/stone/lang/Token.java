package com.github.hyang214.stone.lang;

/**
 * title: Token抽象类
 *
 * @author Hao YANG
 * @since 2020.10.04
 */
public abstract class Token {

    /**
     * 文件末尾，end of file
     */
    public static final Token EOF = new Token(-1) {};

    /**
     * 行号
     */
    private int lineNumber;

    public Token(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    /**
     * 获取行号
     * @return
     */
    public int getLineNumber() {
        return lineNumber;
    }

    /**
     * 判断是否为标识符
     * @return
     */
    public boolean isIdentifier() {
        return false;
    }

    /**
     * 判断是否为数字
     * @return
     */
    public boolean isNumber() {
        return false;
    }

    /**
     * 判断是否为String
     * @return
     */
    public boolean isString() {
        return false;
    }

    /**
     * 如果是非数字token，直接抛出异常
     * @return
     */
    public int getNumber() {
        throw new StoneException("not number token");
    }

    /**
     * 获取文本
     * @return
     */
    public String getText() {
        return "";
    }

}
