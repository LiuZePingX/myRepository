package com.liuzp.data.structure.demo.utils.tree;

/**
 * describe:
 *
 * @author huiyu
 * @date 2019/10/29
 */
public class TNode{
    int data;
    TNode left;
    TNode right;

    public TNode(){

    }

    public TNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

}
