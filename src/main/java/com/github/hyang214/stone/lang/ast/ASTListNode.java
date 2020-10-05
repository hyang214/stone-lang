package com.github.hyang214.stone.lang.ast;

import java.util.Iterator;
import java.util.List;

/**
 * title: ast中间节点
 *
 * @author Hao YANG
 * @since 2020.10.05
 */
public abstract class ASTListNode extends ASTreeNode {

    /**
     * 存储子节点
     */
    private List<ASTreeNode> children;

    public ASTListNode(List<ASTreeNode> children) {
        this.children = children;
    }

    /**
     * 获取第i个节点
     * @param i
     * @return
     */
    @Override
    public ASTreeNode child(int i) {
        return children.get(i);
    }

    /**
     * 子节点数目
     * @return
     */
    @Override
    public int numChildren() {
        return children.size();
    }

    /**
     * 子节点迭代器
     * @return
     */
    @Override
    public Iterator<ASTreeNode> children() {
        return children.iterator();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append('(');
        String sep = "";
        for (ASTreeNode t: children) {
            builder.append(sep);
            sep = " ";
            builder.append(t.toString());
        }
        return builder.append(')').toString();
    }

    /**
     * 获取第一个子节点的位置，作为整体的位置
     * @return
     */
    @Override
    public String location() {
        for (ASTreeNode t: children) {
            String s = t.location();
            if (s != null)
                return s;
        }
        return null;
    }
}
