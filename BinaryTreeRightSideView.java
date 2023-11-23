import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        BinaryTreeRightSideView binaryTreeRightSideView = new BinaryTreeRightSideView();
        int[] nums = {3,1,2,4,5};
        int[] nums2 = {1,2};
        int[] nums3 = { 5, 2, 7, 1, 4, 6, 9, 8, 3, 10};
        binaryTreeRightSideView.rightSideView(binaryTreeRightSideView.populate(nums3));
    }

    private TreeNode root;

    public void insert(int value){
        root = insert(value, root);
    }

    private TreeNode insert(int value, TreeNode node) {
        if (node == null){
            node = new TreeNode(value);
            return node;
        }

        if (value < node.val){
            node.left = insert(value, node.left);
        }
        if (value > node.val){
            node.right = insert(value, node.right);
        }

//        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return node;
    }

    public TreeNode populate(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            this.insert(nums[i]);
        }
        return root;
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int levelsize = queue.size();
            for (int i = 0; i < levelsize; i++) {
                TreeNode currentNode = queue.poll();
                if (i == levelsize - 1){
                    res.add(currentNode.val);
                }
                if (currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }
        }
        System.out.println(res);
        return res;
    }
}
