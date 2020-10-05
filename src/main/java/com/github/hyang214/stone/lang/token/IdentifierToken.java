package com.github.hyang214.stone.lang.token;

import lombok.ToString;

/**
 * title: 标识符token
 *
 * @author Hao YANG
 * @since 2020.10.05
 */
@ToString
public class IdentifierToken extends Token {

    /**
     * 标识符的值
     */
    private String value;

    public IdentifierToken(int lineNumber, String value) {
        super(lineNumber);
        this.value = value;
    }

    @Override
    public boolean isIdentifier() {
        return true;
    }

    @Override
    public String getText() {
        return value;
    }
}
