import java.util.LinkedList;
import java.util.Queue;

public class FindSuccessor {
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

    public TreeNode findSuccessor(TreeNode node, int key){
        if (node == null) return node;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()){
            int size = queue.size();
            TreeNode curr = queue.poll();
            if (curr.left != null){
                queue.offer(curr.left);
            }
            if (curr.right != null){
                queue.offer(curr.right);
            }
            if (curr.val == key){
                break;
            }
        }
        System.out.println(queue.peek().val);
        return queue.peek();
    }
}
