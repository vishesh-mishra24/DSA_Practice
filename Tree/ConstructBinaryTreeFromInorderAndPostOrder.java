/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    int postIndex;
    Map<Integer,Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
       postIndex=postorder.length-1;
       for(int i=0;i<inorder.length;i++){
        map.put(inorder[i],i);
       } 
       return build(postorder,0,inorder.length-1);
    }
    private TreeNode build(int [] post,int inStart,int inEnd){
        if(inStart>inEnd) return null;
        int rootVal=post[postIndex--];
        TreeNode root=new TreeNode(rootVal);
        int inorderIndex=map.get(rootVal);
        root.right=build(post,inorderIndex + 1,inEnd);
        root.left=build(post,inStart,inorderIndex-1);
        return root;
    }
}
