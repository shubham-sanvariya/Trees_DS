import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Function;

public class PopulatingNextRightPointersInEachNode {
    public static void main(String[] args) {
        PopulatingNextRightPointersInEachNode populatingNextRightPointersInEachNode = new PopulatingNextRightPointersInEachNode();
        int[] nums = { 5, 2, 7, 1, 4, 6, 9, 8, 3, 10};
        populatingNextRightPointersInEachNode.connect(populatingNextRightPointersInEachNode.populate(nums));
    }

    public Node connect(Node root) {
        if (root == null) return root;

        Node leftmost = root;
        while (leftmost.left != null){
            Node current = leftmost;
            while (current != null){
                current.left.next = current.right;
                if (current.next != null){
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }

    private Node root;

    public void insert(int value){
        root = insert(value, root);
    }

    private Node insert(int value, Node node) {
        if (node == null){
            node = new Node(value);
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

    public Node populate(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            this.insert(nums[i]);
        }
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
