import java.util.*;

public class BinaryTreeLevelOrderTraversal2 {
    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal2 binaryTreeLevelOrderTraversal2 = new BinaryTreeLevelOrderTraversal2();
        int[] nums = { 5, 2, 7, 1, 4, 6, 9, 8, 3, 10};
        binaryTreeLevelOrderTraversal2.levelOrderBottom(binaryTreeLevelOrderTraversal2.populate(nums));
//        LinkedList<Integer> linkedList = new LinkedList<>();
//        for (int i = 0; i < nums.length; i++) {
//            linkedList.addFirst(nums[i]);
//        }
//        System.out.println(linkedList);
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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
            res.add(0,currentLevel);
        }
        System.out.println(res);
        return res;
    }
}
