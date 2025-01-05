import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

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
};

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class PathSum {

        // 112:
        boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return false;
            }

            if (root.val == targetSum && root.left == null && root.right == null) {
                return true;
            }

            return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
        }


        //129 :
        int sumNumbers(TreeNode root) {
            return helperPathSum(root, 0);
        }

        int helperPathSum(TreeNode node, int pathSum) {
            if (node == null) {
                return 0;
            }

            pathSum = pathSum * 10 + node.val;

            if (node.left == null && node.right == null) {
                return pathSum;
            }

            return helperPathSum(node.left, pathSum) + helperPathSum(node.right, pathSum);
        }

        // 124 : 
        int maxSum = Integer.MIN_VALUE;
        int maxPathSum(TreeNode root) {
            helperMaxPathSum(root);
            return maxSum;
        }

        int helperMaxPathSum(TreeNode node){
            if (node == null) {
                return 0;
            }

            int left = helperMaxPathSum(node.left);
            int right = helperMaxPathSum(node.right);

            left = Math.max(0, left);
            right = Math.max(0, right);

            int pathSum = left + right + node.val;
            maxSum = Math.max(maxSum, pathSum);

            return Math.max(left, right) + node.val;
        }

        // Path exists in B.T from root to leaf
        boolean findPath(Node node, int[] arr){
            if (node == null) {
                return arr.length == 0;
            }

            return helper(node , arr, 0);
        }

        boolean helper(Node node,int[] arr, int index){
            if (node == null) {
                return false;
            }

            if (index >= arr.length || node.val != arr[index]) {
                return false;
            }

            if (node.left == null && node.right == null && index == arr.length - 1)  {
                return true;
            }

            return helper(node.left, arr, index + 1) || helper(node.right, arr, index + 1);   
        }

        public static void main(String[] args) {
            Node root = new Node(1);
            root.left = new Node(3);
            root.right = new Node(2);
            root.right.left = new Node(1);
            root.right.right = new Node(3);
            root.right.left.left = new Node(11);
            root.right.right.left = new Node(2);
            root.right.right.left.right = new Node(2);
            root.right.right.left.right.left = new Node(16);
    
            System.out.println(countPaths(root, 4)); 
        }

        // Sum of nodes = target, count paths 
        public static int countPaths(Node node, int sum){
            List<Integer> path = new LinkedList<>();
            return helper(node, sum, path);
        }

        static int helper(Node node, int sum, List<Integer> path){
            if (node == null) {
                return 0;
            }

            path.add(node.val);
            int count = 0;
            int currSum = 0;

            // how many paths can i make
            ListIterator<Integer> itr = path.listIterator(path.size());

            while (itr.hasPrevious()) {
                currSum += itr.previous();
                if (currSum == sum) {
                    count++;
                }
            }

            count += helper(node.left, sum, path) + helper(node.right, sum, path);

            // backtrack
            path.remove(path.size() - 1);

            return count;
        }

        // Give me all the paths in a list
        List<List<Integer>> findPaths(Node node, int sum){
            List<List<Integer>> paths = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            helper(node, sum, path, paths);
            return paths;
        }

        void helper(Node node, int sum, List<Integer> path , List<List<Integer>> paths){
            if (node == null) {
                return;
            }

            path.add(node.val);
            if (node.val == sum && node.left == null && node.right == null) {
                paths.add(new ArrayList<>(path));
            } else {
                helper(node.left, sum - node.val , path, paths);
                helper(node.right, sum - node.val , path, paths);
            }
            // backtrack
            path.remove(path.size() - 1);
        }

}
