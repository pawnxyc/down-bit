package com.wdbyte.downbit.Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Noredi {
    public Stack<Node> stack = new Stack<>();
    public Stack<Node> stackafter = new Stack<>();
    public Stack<Node> stackmiddle = new Stack<>();
//    非递归的方式先序遍历二叉树  根 左 右
    void pre(Node node){
        stack.push(node);
        while(!stack.empty()){
            Node tmp = stack.pop();
            System.out.println(tmp.value);
            if (tmp.left!=null){
                stack.push(tmp.right);
            }
            if (tmp.right!=null){
                stack.push(tmp.left);
            }
        }
    }
//    后续遍历 出栈顺序 ：根 右 左
    void after(Node node){
        stack.push(node);
        while(!stack.empty()){
            Node tmp = stack.pop();
            stackafter.push(tmp);
            if (tmp.left!=null){
                stack.push(tmp.left);
            }
            if (tmp.right!=null){
                stack.push(tmp.right);
            }
        }
        while(!stackafter.empty())
        System.out.println(stackafter.pop().value);
    }

//    中序遍历 左 跟 右
    void middle(Node head){
        if (head != null){
            System.out.println("start middle index");
            while(!stackmiddle.empty()||head!=null){
                if (head!=null){
                    //            以跟 左 的顺序进栈
                    stackmiddle.push(head);
                    head = head.left;//head 把指针传递给左节点
                }
                else{
//                    规则二 如果head为空，则弹出，并且打印，来到右节点
                    head = stackmiddle.pop();
                    System.out.print(head.value);
                    head = head.right;
                }
            }
        }
    }

//    二叉树的镜像 对于每颗树 都交换左右节点
    void imagetree(Node head){
        if (head.left!=null){
            Node tmp = head.left;
            head.left = head.right;
            head.right = tmp;
            imagetree(head.left);
            imagetree(head.right);
        }
    }

    void widthforeachMax(Node head){
//        宽度遍历二叉树，并且找到最大宽度
        if(head!=null){
            int curLevel =1;//当前循环执行到的层数
            int max = 0;
            int curLevelNum = 0;//当前层的总node数
            HashMap<Node,Integer> LevelMap = new HashMap<>();//
            Queue<Node> queue = new LinkedList<>();
            queue.add(head);
            LevelMap.put(head,1);
            while(!queue.isEmpty()){
                Node cur = queue.poll();
//                System.out.println(head.value);
                int nodeLevel = LevelMap.get(cur);//获取当前节点的层级。
                if (cur.left!=null){
                    LevelMap.put(cur.left,nodeLevel+1);
                    queue.add(cur.left);
                }
                if (cur.right!=null){
                    LevelMap.put(cur.right,nodeLevel+1);
                    queue.add(cur.right);
                }

//                两件事，如果当前节点的level 等于当前循环的level，则curlevelnum++。else 开始下一层的循环统计
                if (nodeLevel == curLevel){
                    curLevelNum++;
                }
                else{
                    curLevel++;
                    max = Math.max(max,curLevelNum);
                    System.out.println(curLevelNum);
                    curLevelNum = 1;
                }
            }
            max = Math.max(max,curLevelNum);
            System.out.println(max);
        }

    }
    void widthnomapTree(Node node){
//        只用一个队列 完成二叉树的宽度遍历 并且找到最大宽度 用到当前最右 和 下一层最右这两个游标。
//      核心思想：在处理当前层时 把下一层的的边界构造好 ，其实就是最右边界。
        if (node!=null){
            int max = 0;
            int curLevelNum = 0;//当前层的总node数
            Node curEnd = node;
            Node nextEnd = node;
            Queue<Node> queue = new LinkedList<>();
            queue.add(node);
            while(!queue.isEmpty()){
                final Node cur = queue.poll();
                System.out.println(cur.value);
                curLevelNum++;
                if (cur.left!=null){
                    queue.add(cur.left);
                    nextEnd = cur.left;
                }
                if (cur.right!=null){
                    queue.add(cur.right);
                    nextEnd = cur.right;
                }
                if (cur == curEnd){
                    System.out.println("当前层的最右元素"+curEnd.value);
                    max = Math.max(curLevelNum,max);
                    curLevelNum = 0;
                    curEnd = nextEnd;
                }

            }
            System.out.println(max);

        }
    }

}
