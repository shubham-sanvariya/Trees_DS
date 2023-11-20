import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Average_of_levels_in_BT {
    public static void main(String[] args) {
        Average_of_levels_in_BT node = new Average_of_levels_in_BT();
        int[] nums = {3,9,20,15,7};
        node.averageOfLevels(node.populate(nums));
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

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            double avgLevel = 0;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                 avgLevel += curr.val;
                 if (curr.left != null){
                     queue.offer(curr.left);
                 }
                 if (curr.right != null){
                     queue.offer(curr.right);
                 }
            }
             avgLevel = avgLevel / size;
            list.add(avgLevel);
        }
        return list;
    }
}

