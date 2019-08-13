package Chap4;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 按照Z字形打印二叉树，即先打印根结点，然后从右往左打印第二层，从左往右打印第三层...以此类推
 */
public class $32_3PrintTreeZ {
    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public void printTreeZ(TreeNode root) {
        if (root == null) return;
        LinkedList<TreeNode> stackOdd = new LinkedList<>();
        LinkedList<TreeNode> stackEven = new LinkedList<>();
        stackOdd.push(root);
        // 只要还有一个栈不为空就继续
        while (!stackOdd.isEmpty() || !stackEven.isEmpty()) {
            if (!stackOdd.isEmpty()) {
                while (!stackOdd.isEmpty()) {
                    TreeNode node = stackOdd.pop();
                    System.out.println((node.val + " "));
                    if (node.left != null) stackEven.push(node.left);
                    if (node.right != null) stackEven.push(node.right);
                }
            } else {
                while (!stackEven.isEmpty()) {
                    TreeNode node = stackEven.pop();
                    System.out.println((node.val + " "));
                    if (node.right != null) stackOdd.push(node.right);
                    if (node.left != null) stackOdd.push(node.left);
                }
            }
            System.out.println();
        }
    }

    public ArrayList<ArrayList<Integer>> print(TreeNode root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        LinkedList<TreeNode> stackOdd = new LinkedList<>();
        LinkedList<TreeNode> stackEven = new LinkedList<>();
        stackOdd.push(root);
        // 只要还有一个栈不为空就继续
        while (!stackOdd.isEmpty() || !stackEven.isEmpty()) {
            ArrayList<Integer> layerList = new ArrayList<>();
            if (!stackOdd.isEmpty()) {
                while (!stackOdd.isEmpty()) {
                    TreeNode node = stackOdd.pop();
                    layerList.add(node.val);
                    if (node.left != null) stackEven.push(node.left);
                    if (node.right != null) stackEven.push(node.right);
                }
            } else {
                while (!stackEven.isEmpty()) {
                    TreeNode node = stackEven.pop();
                    layerList.add(node.val);
                    if (node.right != null) stackOdd.push(node.right);
                    if (node.left != null) stackOdd.push(node.left);
                }
            }
            list.add(layerList);
        }
        return list;
    }

    static LinkedList<TreeNode> stack1 =new LinkedList();
    static LinkedList<TreeNode> stack2 =new LinkedList();

    public void printByHy (TreeNode root){
        stack1.addLast(root.left);
        stack1.addLast(root.right);
        from1To2();
    }

    public void from1To2 () {
        if (!stack1.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.addLast(stack1.getLast().left);
                stack2.addLast(stack1.getLast().right);
                System.out.println(stack1.removeLast());
            }
            from2To1();
        }
    }

    public void from2To1 () {
        if (!stack2.isEmpty()) {
            while (!stack2.isEmpty()) {
                stack2.addLast(stack2.getLast().right);
                stack2.addLast(stack2.getLast().left);
                System.out.println(stack2.removeLast());
            }
            from1To2();
        }
    }

}
