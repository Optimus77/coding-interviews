package Chap4;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class $36BSTTransToDLinkedList {
    private class TreeNode {
        int val = 0;
        TreeNode m_pLeft = null;
        TreeNode m_pRight = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    TreeNode cur = null; //用于存放当前节点
    TreeNode realHead = null; //用于存放链双向链表的首节点（即最左孩子）
    //中序递归遍历修改链表指针即可实现
    public TreeNode convert(TreeNode node){
        if(node == null){
            return null;
        }
        convert(node.m_pLeft); //左

        if(cur == null){ //根
            cur = node;
            realHead = node;
        }else{
            cur.m_pRight = node;
            node.m_pLeft = cur;
            cur = node;
        }

        convert(node.m_pRight); //右
        return realHead;
    }



}
