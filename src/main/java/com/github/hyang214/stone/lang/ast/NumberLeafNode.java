package com.github.hyang214.stone.lang.ast;

import com.github.hyang214.stone.lang.token.Token;

/**
 * title: 数字型叶节点
 *
 * @author Hao YANG
 * @since 2020.10.05
 */
public class NumberLeafNode extends ASTLeafNode {

    public NumberLeafNode(Token token) {
        super(token);
    }

    public int value() {
        return token.getNumber();
    }

}
