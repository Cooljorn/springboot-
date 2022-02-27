package com.example.demo.test.zuoAlgorithm.classM02;

public class class2_10 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public boolean checkBST(TreeNode root) {
        if(null == root){
            return true;
        }
        TreeNode lNode = root.left;
        TreeNode rNode = root.right;

        if(null != lNode ){
            if(root.val<lNode.val) {
                return false;
            }
            TreeNode lrNode = lNode.right;
            if(null != lrNode && root.val< lrNode.val){
                return false;
            }
        }
        if(null != rNode){
            if(root.val> rNode.val) {
                return false;
            }
            TreeNode rlNode = rNode.left;
            if(null != rlNode && root.val> rlNode.val){
                return false;
            }
        }
        return checkBST(lNode) && checkBST(rNode);
    }

}
