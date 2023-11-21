import java.util.*;

// normal order -> remove from front
//              -> add it back
// reverse order -> remove from back
////              -> add from front
public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        BinaryTreeZigzagLevelOrderTraversal node = new BinaryTreeZigzagLevelOrderTraversal();
        int[] nums = { 5, 2, 7, 1, 4, 6, 9, 8, 3, 10};
        node.zigzagLevelOrder(node.populate(nums));
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        boolean reverse = false;
        while (!deque.isEmpty()){
            int size = deque.size();
            List<Integer> list = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                if (!reverse){
                    TreeNode curr = deque.pollFirst();
                    list.add(curr.val);
                    if (curr.left != null){
                        deque.addLast(curr.left);
                    }
                    if (curr.right != null){
                        deque.addLast(curr.right);
                    }
                }
                else {
                    TreeNode curr = deque.pollLast();
                    list.add(curr.val);
                    if (curr.right != null){
                        deque.addFirst(curr.right);
                    }
                    if (curr.left != null){
                        deque.addFirst(curr.left);
                    }
                }
            }
            reverse = !reverse;
            res.add(list);
        }
        System.out.println(res);
        return res;
    }
}
