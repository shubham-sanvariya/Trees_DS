import java.util.Arrays;

public class ConstructBinaryTreePreorderInorderTraversal {
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inoder = {9,3,15,20,7};
        ConstructBinaryTreePreorderInorderTraversal constructBinaryTreePreorderInorderTraversal = new ConstructBinaryTreePreorderInorderTraversal();
        constructBinaryTreePreorderInorderTraversal.buildTree(preorder,inoder);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;

        int r = preorder[0];
        int index = 0;

        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == r) {
                index = i;
            }
        }

        TreeNode node = new TreeNode(r);

        node.left = buildTree(Arrays.copyOfRange(preorder,1, index +1),Arrays.copyOfRange(inorder,0,index));
        node.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length),Arrays.copyOfRange(inorder,index + 1,inorder.length));

        return node;
    }
}
