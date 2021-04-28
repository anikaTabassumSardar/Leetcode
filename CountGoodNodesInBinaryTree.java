class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class CountGoodNodesInBinaryTree {
    public static void main(String[] args){
        CountGoodNodesInBinaryTree countGoodNodesInBinaryTree = new CountGoodNodesInBinaryTree();
    }

    public int goodNodes(TreeNode root) {
        //base case
        if(root == null) return 0;

        int[] count = {0}; //keep track of the count, passed by ref;

        preorder(root, root.val, count);

        return count[0];
    }

    private void preorder(TreeNode root, int prevVal, int[] count){
        if(root == null) return;

        //process root
        if(root.val >= prevVal) count[0]++; //good node

        //process left and right subtree
        //we do another max check to ensure that we are passing the max present value to guarantee that the bigger value is passed down
        preorder(root.left, Math.max(prevVal, root.val), count);
        preorder(root.right, Math.max(prevVal, root.val), count);
    }

    /**
     * Complexities:
     * Time: O(N) because we visit each nodes once
     *
     * Space: O(N) due to the recursive stack
     */
}

/**
 * Problem Statement
 *
 * Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
 *
 * Return the number of good nodes in the binary tree.
 *
 * Link: https://leetcode.com/problems/count-good-nodes-in-binary-tree/
 */
