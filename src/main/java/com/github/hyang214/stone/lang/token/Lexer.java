package com.github.hyang214.stone.lang.token;

import com.github.hyang214.stone.lang.exception.ParseException;
import com.google.common.collect.Lists;

import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * title:
 *
 * @author Hao YANG
 * @since 2020.10.05
 */
public class Lexer {

    /**
     * token的正则
     */
    private Pattern pattern = Pattern.compile(TokenConstant.TOKEN_PATTERN);

    /**
     * 存储token的队列
     */
    private List<Token> queue;

    /**
     * 文件读取
     */
    private LineNumberReader r;

    /**
     * 是否有下一行
     */
    private Boolean hasMore;

    public Lexer(Reader reader) throws ParseException {
        this.queue = Lists.newArrayList();
        this.r = new LineNumberReader(reader);
        this.hasMore = true;
    }

    /**
     * 读取一个token
     * + 如果还能读取一个token，那么将该token弹出
     * + 否则，返回文件结束
     * @return
     */
    public Token read() throws ParseException {
        if (fillQueue(0)) {
            return queue.remove(0);
        } else {
            return Token.EOF;
        }
    }

    /**
     * 预读i位的token
     * + 如果第i位的token存在，那么返回（token不移除，和read不一致）
     * + 否则，返回文件结束
     * @param i
     * @return
     */
    public Token peek(int i) throws ParseException {
        if (fillQueue(i)) {
            return queue.get(i);
        } else {
            return Token.EOF;
        }
    }

    /**
     * 填充队列
     * 如果i < 当前已经读取的token数目，不做处理
     * 否则，再读取一行填充token，直到文件结束，或者token数目足够
     * @param i
     * @return 是否还有token
     */
    private boolean fillQueue(int i) throws ParseException {
        while (i >= queue.size()) {
            if (hasMore) {
                readLine();
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 单行解析
     * + 读取一行，如果不存在，将文件结束标准位设置为true
     * + 否则进行解析
     * + 使用正则去逐个match，每个match位提取token，然后继续处理下一个
     * + 最后加入 行结束符
     */
    private void readLine() throws ParseException {
        String line;
        try {
            line = r.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            throw new ParseException(e);
        }

        if (line == null) {
            hasMore = false;
            return;
        }
        int lineNumber = r.getLineNumber();
        Matcher matcher = pattern.matcher(line);
        /** 允许设置匹配的边界 **/
        matcher.useTransparentBounds(true)
                .useAnchoringBounds(true);
        int pos = 0;
        int endPos = line.length();
        while (pos < endPos) {
            /** 在区间中匹配一个 **/
            matcher.region(pos, endPos);
            if (matcher.lookingAt()) {
                addToken(lineNumber, matcher);
                pos = matcher.end();
            } else {
                /** 未匹配到 **/
                throw new ParseException("bad token line ");
            }
        }
        queue.add(new IdentifierToken(lineNumber, TokenConstant.EOL));
    }

    /**
     * 将matcher中的token解析出来，加入队列
     * @param lineNumber 行号
     * @param matcher 正则匹配结果
     */
    private void addToken(int lineNumber, Matcher matcher) {
        /** 匹配非空格 **/
        String m = matcher.group(1);
        if (m != null) {
            /** 匹配非注释 **/
            if (matcher.group(2) == null) {
                Token token;
                if (matcher.group(3) != null) {
                    token = new NumberToken(lineNumber, Integer.parseInt(m));
                } else if (matcher.group(4) != null) {
                    token = new StringToken(lineNumber, parseString(m));
                } else {
                    token = new IdentifierToken(lineNumber, m);
                }
                queue.add(token);
            }
        }
    }

    /**
     * 处理字符串内容
     * + 主要转移字符相关
     * @param s
     * @return
     */
    private String parseString(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length() - 1;
        for (int i = 1; i < len; i++) {
            char c = s.charAt(i);
            if (c == '\\' && i + 1 < len) {
                char c2 = s.charAt(i + 1);
                if (c2 == '"' || c2 == '\\') {
                    c = s.charAt(++i);
                } else if (c2 == 'n') {
                    ++i;
                    c = '\n';
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }

}
