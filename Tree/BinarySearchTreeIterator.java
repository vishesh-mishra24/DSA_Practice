class BSTIterator {
    Stack<TreeNode> st = new Stack<>();

    public BSTIterator(TreeNode root) {
        pushAll(root);
    }
    
    // Return next smallest number
    public int next() {
        TreeNode node = st.pop();
        // After visiting a node, move to its right subtree
        pushAll(node.right);
        return node.val;
    }
    
    // Check if iterator has more nodes
    public boolean hasNext() {
        return !st.isEmpty();
    }

    // Push all left nodes down the subtree
    private void pushAll(TreeNode node) {
        while (node != null) {
            st.push(node);
            node = node.left;
        }
    }
}
