package com.github.hyang214.stone.lang.ast;

import com.github.hyang214.stone.lang.exception.ParseException;

import java.util.List;

/**
 * title: 二元运算节点
 *
 * @author Hao YANG
 * @since 2020.10.05
 */
public class BinaryExpressionNode extends ASTListNode {

    public BinaryExpressionNode(List<ASTreeNode> children) throws ParseException {
        super(children);
        if (children.size() != 3) {
            throw new ParseException("binary expression ");
        }
    }

}
