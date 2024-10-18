public class TreeMain {

    public static void main(String[] args) {
        // Scanner scanner =  new Scanner(System.in);
        // BinaryTree tree = new BinaryTree();
        // tree.populate(scanner);
        // tree.display();
        // tree.prettyDisplay();

        // BST tree = new BST();
        // // int[] nums = {5,2,7,1,4,6,9,8,3,10};
        // int[] nums = {1,2,3,4,5,6,7,8,9};
        // tree.populateSorted(nums);
        // tree.display();

        AVL tree = new AVL();
        
        for (int i = 0; i < 1000; i++) {
            tree.insert(i);
        }

        System.out.println(tree.height());
    }
}
