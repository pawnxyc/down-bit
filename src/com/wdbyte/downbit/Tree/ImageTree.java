package com.wdbyte.downbit.Tree;

import java.util.ArrayList;

class Node{
    Node left;
    Node right;
    String value;
    Node(String v){
        this.value = v;
    }
    void changetoarr(Node root){
        if (root!=null) {
//            System.out.println(root.value);//第一次到达就打印 先序
            changetoarr(root.left);
//            第二次到达root
            System.out.print(root.value);

            changetoarr(root.right);
//            右子树走完，第三次到达root
        }
    }
}
public class ImageTree {
    public static void main(String[] args) {
//        1234567
        Node root = new Node("1");
        root.left = new Node("2");
        root.right = new Node("3");
        root.left.left = new Node("4");
        root.left.right = new Node("5");
        root.right.left = new Node("6");
        root.right.right = new Node("7");
//        root.changetoarr(root);
//
//        System.out.println("middle");
        Noredi n = new Noredi();
//        n.after(root);
//        n.imagetree(root);
//        n.middle(root);
//        n.widthforeachMax(root);
        n.widthnomapTree(root);
    }


}
