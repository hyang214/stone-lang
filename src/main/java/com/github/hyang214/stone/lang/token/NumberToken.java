package com.github.hyang214.stone.lang.token;

import lombok.ToString;

/**
 * title: 数值token
 *
 * @author Hao YANG
 * @since 2020.10.05
 */
@ToString
public class NumberToken extends Token {

    /**
     * 数字的值
     */
    private int value;

    public NumberToken(int lineNumber, int value) {
        super(lineNumber);
        this.value = value;
    }

    @Override
    public boolean isNumber() {
        return true;
    }

    @Override
    public int getNumber() {
        return value;
    }

    @Override
    public String getText() {
        return Integer.toString(value);
    }

}
