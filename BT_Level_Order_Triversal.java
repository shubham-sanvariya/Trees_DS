import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode() {

    }
}
public class BT_Level_Order_Triversal {
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
    public static void main(String[] args) {
        BT_Level_Order_Triversal node = new BT_Level_Order_Triversal();
        int[] nums = { 5, 2, 7, 1, 4, 6, 9, 8, 3, 10};
//        node.populate(nums);
        node.levelOrder(node.populate(nums));
    }

    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int levelsize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelsize);
            for (int i = 0; i < levelsize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);
                if (currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }
            res.add(currentLevel);
        }
        System.out.println(res);
        return res;
    }
}


