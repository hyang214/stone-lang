package com.github.hyang214.lang;

import com.github.hyang214.stone.lang.Constant;
import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Pattern;

/**
 * title:
 *
 * @author Hao YANG
 * @since 2020.10.04
 */
public class ConstantTokenTest {

    @Test
    public void blank() {
        Pattern pattern = Pattern.compile(Constant.BLANK_PATTERN);
        Assert.assertTrue(pattern.matcher(" ").matches());
        Assert.assertTrue(pattern.matcher("        ").matches());
        Assert.assertTrue(!pattern.matcher("//").matches());
        Assert.assertTrue(!pattern.matcher("a").matches());
        Assert.assertTrue(!pattern.matcher("0").matches());
        Assert.assertTrue(!pattern.matcher("\"abcd\"").matches());
    }


    @Test
    public void comment() {
        Pattern pattern = Pattern.compile(Constant.COMMENT_PATTERN);
        Assert.assertTrue(pattern.matcher("//").matches());
        Assert.assertTrue(pattern.matcher("//abcd").matches());
        Assert.assertTrue(!pattern.matcher(" ").matches());
        Assert.assertTrue(!pattern.matcher("a").matches());
        Assert.assertTrue(!pattern.matcher("0").matches());
        Assert.assertTrue(!pattern.matcher("\"abcd\"").matches());
    }

    @Test
    public void identifier() {
        Pattern pattern = Pattern.compile(Constant.IDENTIFIER_PATTERN);
        Assert.assertTrue(pattern.matcher("_a").matches());
        Assert.assertTrue(pattern.matcher("a").matches());
        Assert.assertTrue(pattern.matcher("A").matches());
        Assert.assertTrue(pattern.matcher("_a").matches());
        Assert.assertTrue(pattern.matcher("_3").matches());
        Assert.assertTrue(pattern.matcher("abc").matches());
        Assert.assertTrue(pattern.matcher("ABc").matches());
        Assert.assertTrue(pattern.matcher("A12").matches());
        Assert.assertTrue(!pattern.matcher("123").matches());
        Assert.assertTrue(!pattern.matcher(" ").matches());
        Assert.assertTrue(!pattern.matcher("//abcd").matches());
        Assert.assertTrue(!pattern.matcher("10").matches());
        Assert.assertTrue(!pattern.matcher("\"abcd\"").matches());
    }

    @Test
    public void number() {
        Pattern pattern = Pattern.compile(Constant.NUMBER_PATTERN);
        Assert.assertTrue(pattern.matcher("0").matches());
        Assert.assertTrue(pattern.matcher("10").matches());
        Assert.assertTrue(pattern.matcher("2").matches());
        Assert.assertTrue(pattern.matcher("2094").matches());
        Assert.assertTrue(!pattern.matcher("-1").matches());
        Assert.assertTrue(!pattern.matcher(" ").matches());
        Assert.assertTrue(!pattern.matcher("//").matches());
        Assert.assertTrue(!pattern.matcher("bas").matches());
        Assert.assertTrue(!pattern.matcher("\"abcd\"").matches());
    }

    @Test
    public void string() {
        Pattern pattern = Pattern.compile(Constant.STRING_PATTERN);
        Assert.assertTrue(pattern.matcher("\"abcd\"").matches());
        Assert.assertTrue(pattern.matcher("\"ab cd\"").matches());
        Assert.assertTrue(pattern.matcher("\"\"ab cd\"").matches());
        Assert.assertTrue(!pattern.matcher("0").matches());
        Assert.assertTrue(!pattern.matcher(" ").matches());
        Assert.assertTrue(!pattern.matcher("//").matches());
        Assert.assertTrue(!pattern.matcher("a").matches());
        Assert.assertTrue(!pattern.matcher("0").matches());
    }

}
