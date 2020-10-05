package com.github.hyang214.stone.lang.token;

import lombok.ToString;

/**
 * title: 文本token
 *
 * @author Hao YANG
 * @since 2020.10.05
 */
@ToString
public class StringToken extends Token {

    /**
     * 文本值
     */
    private String value;

    public StringToken(int lineNumber, String value) {
        super(lineNumber);
        this.value = value;
    }

    @Override
    public boolean isString() {
        return true;
    }

    @Override
    public String getText() {
        return value;
    }

}
