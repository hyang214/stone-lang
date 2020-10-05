package com.github.hyang214.lang.token;

import com.github.hyang214.stone.lang.exception.ParseException;
import com.github.hyang214.stone.lang.token.Lexer;
import com.github.hyang214.stone.lang.token.Token;
import org.junit.Test;

import java.io.Reader;
import java.io.StringReader;

/**
 * title:
 *
 * @author Hao YANG
 * @since 2020.10.05
 */
public class LexerTest {

    @Test
    public void case01() throws ParseException {
        String str = "//备注测试\n  abc = 100; //测试行\n";
        Reader reader = new StringReader(str);
        Lexer lexer = new Lexer(reader);
        for (int i = 0; i < 100; i ++) {
            Token token = lexer.peek(i);
            if (Token.EOF.equals(token)) {
                break;
            }
            System.out.println(token);
        }
    }

}
