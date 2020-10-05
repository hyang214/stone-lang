package com.github.hyang214.stone.lang.exception;

import com.github.hyang214.stone.lang.token.Token;

import java.io.IOException;

/**
 * title: 解析异常
 *
 * @author Hao YANG
 * @since 2020.10.05
 */
public class ParseException extends Exception {

    public ParseException(IOException e) {
        super(e);
    }

    public ParseException(String msg) {
        super(msg);
    }

    public ParseException(Token t) {
        this("", t);
    }

    public ParseException(String msg, Token t) {
        super("syntax error around " + location(t) + ". " + msg);
    }

    private static String location(Token t) {
        if (t == Token.EOF) {
            return "the last line";
        } else {
            return "\"" + t.getText() + "\" at line " + t.getLineNumber();
        }
    }

}
