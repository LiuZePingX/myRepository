package com.liuzp.data.structure.demo.utils.tree;


/**
 * describe:
 *
 * @author huiyu
 * @date 2019/10/29
 */
public class Tree {


   TNode root;

    public Tree(){
        root = new TNode();
    }

    public TNode insert(TNode node, int elem){
        TNode p = new TNode(elem);

        if (node == null){
            node = p;
        }else {
            if (elem < node.data){
                node.left = insert(node.left,elem);
            }
            if (elem > node.data){
                node.right = insert(node.right,elem);
            }
        }

        this.root = node;
        return this.root;
    }

    public void preOrder(TNode root){
        if (root == null){
            return;
        }

        preOrder(root.left);
        System.out.print(root.data + " -> ");
        preOrder(root.right);
    }
}
