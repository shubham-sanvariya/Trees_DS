import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        BinaryTree tree = new BinaryTree();
//        tree.populate(scanner);
//        tree.prettyDisplay();
//        tree.preOrder();
//        tree.inOrder();
//        tree.postOrder();

//        BST tree = new BST();
//        int[] nums = { 5, 2, 7, 1, 4, 6, 9, 8, 3, 10};
//        int[] nums2 = { 10, 20, 15, 13, 12};
//        tree.populate(nums2);
//        tree.display();

//        Tree2AVL tree = new Tree2AVL();
//
//        for (int i = 0; i < 1000; i++) {
//            tree.insert(i);
//        }
//
//        System.out.println(tree.height());
//        tree.display();

//        int[] arr = {3,8,6,7,-2,-8,4,9};
//        SegmentTree segmentTree = new SegmentTree(arr);
////        segmentTree.display();
//        System.out.println(segmentTree.query(1,6));

        FindSuccessor findSuccessor = new FindSuccessor();
        int[] nums = {3,9,20,15,7};
        findSuccessor.findSuccessor(findSuccessor.populate(nums),7);
    }
}
