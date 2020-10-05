package com.github.hyang214.stone.lang.ast;

import java.util.Iterator;

/**
 * title: 抽象语法节点抽象类
 *
 * @author Hao YANG
 * @since 2020.10.05
 */
public abstract class ASTreeNode {

    /**
     * 获取第i个子节点
     * @param i
     * @return
     */
    public abstract ASTreeNode child(int i);

    /**
     * 获取子节点的数目
     * @return
     */
    public abstract int numChildren();

    /**
     * 获取子节点的
     * @return
     */
    public abstract Iterator<ASTreeNode> children();

    /**
     * 返回代码位置，即行号
     * @return
     */
    public abstract String location();

    /**
     * 返回迭代器
     */
    public Iterator<ASTreeNode> iterator() {
        return children();
    }

}
