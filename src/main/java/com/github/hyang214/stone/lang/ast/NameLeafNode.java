package com.github.hyang214.stone.lang.ast;

import com.github.hyang214.stone.lang.token.Token;

/**
 * title: 文本型叶节点
 *
 * @author Hao YANG
 * @since 2020.10.05
 */
public class NameLeafNode extends ASTLeafNode {

    public NameLeafNode(Token token) {
        super(token);
    }

    public String name() {
        return token.getText();
    }

}
