package com.github.hyang214.stone.lang.ast;

import com.github.hyang214.stone.lang.token.Token;
import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;

/**
 * title: 语法树叶节点
 *
 * @author Hao YANG
 * @since 2020.10.05
 */
public abstract class ASTLeafNode extends ASTreeNode {

    private static final List<ASTreeNode> EMPTY = Lists.newArrayList();

    protected Token token;

    public ASTLeafNode(Token token) {
        this.token = token;
    }

    @Override
    public ASTreeNode child(int i) {
        throw new IndexOutOfBoundsException("ast leaf does not have child");
    }

    @Override
    public int numChildren() {
        return 0;
    }

    @Override
    public Iterator<ASTreeNode> children() {
        return EMPTY.iterator();
    }

    @Override
    public String location() {
        return "at line " + token.getLineNumber();
    }


}
