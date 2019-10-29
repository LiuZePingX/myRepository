package com.liuzp.data.structure.demo.utils.tree;

/**
 * describe:
 *
 * @author huiyu
 * @date 2019/10/29
 */
public class TreeTest{

    public static  void main(String[] args){
       Tree tree = new Tree();

        tree.insert(tree.root, 4);
        tree.insert( tree.root, 1);
        tree.insert( tree.root, 5);
        tree.insert(tree.root,  3);
        tree.insert(tree.root, 7);

        tree.preOrder(tree.root);

    }


}
