class Solution {

    Map<Integer, Integer> inMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inMap = new HashMap<>();

        // store inorder value -> index mapping
        for(int i = 0; i < inorder.length; i++){
            inMap.put(inorder[i], i);
        }

        return helper(preorder, 0, preorder.length-1, 
                      inorder, 0, inorder.length-1);
    }

    private TreeNode helper(int[] preorder, int preStart, int preEnd,
                            int[] inorder, int inStart, int inEnd) {

        if(preStart > preEnd || inStart > inEnd) return null;

        // root = first element in preorder
        TreeNode root = new TreeNode(preorder[preStart]);

        // find index of root in inorder
        int inRootIndex = inMap.get(root.val);

        // nodes in left subtree
        int numsLeft = inRootIndex - inStart;

        // build left & right subtrees
        root.left = helper(preorder, preStart+1, preStart+numsLeft,
                           inorder, inStart, inRootIndex-1);

        root.right = helper(preorder, preStart+numsLeft+1, preEnd,
                            inorder, inRootIndex+1, inEnd);

        return root;
    }
}
