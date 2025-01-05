
import java.util.Arrays;

public class QuestionsDFS {

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

    // 543: Diameter  (post order travrsal is used)
    int diameter = 0;
    int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter-1;
    }

    int height(TreeNode node){
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        int dia = leftHeight + rightHeight + 1;
        diameter = Math.max(diameter, dia);

        return Math.max(leftHeight,rightHeight) + 1;
    }

    // 226 : Invert a tree  T.C : O(N) S.C: O()
    TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }


    // 104 
    int h = 0;
    int maxDepth(TreeNode root) {
        h = height2(root);
        return h;
    }

    int height2(TreeNode node){
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return Math.max(leftHeight,rightHeight) + 1;
    }

    // 108
    TreeNode sortedArrayToBST(int[] nums) {
        return sorted(nums, 0, nums.length);
    }

    TreeNode sorted(int[] nums, int s, int e){
        if(s >= e){
            return null;
        }
        int mid = s + (e-s)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sorted(nums, s, mid);
        root.right = sorted(nums, mid + 1, e);

        return root;
    }


    // 114 :
    void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode current = root;

        while (current != null ) {
            if (current.left != null) {
                TreeNode temp = current.left;
                while (temp.right != null) {
                    temp = temp.right;
                }

                temp.right = current.right;
                current.right = current.left;
                current.left = null;
            }

            current = current.right;
        }
    }

    // 98 
    boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    boolean helper(TreeNode node, Integer minLimit, Integer maxLimit){
        if (node == null) {
            return true;
        }

        // if (minLimit != node.val <= minLimit){
        //     return false;
        // }

        // if (node.val >= maxLimit){
        //     return false;
        // }
        if ((minLimit != null && node.val <= minLimit) || (maxLimit != null && node.val >= maxLimit)) {
            return false;
        }

        return helper(node.left, minLimit, node.val) && helper(node.right, node.val, maxLimit);
    }

    // 236 : lowestCommonAncestor
    TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        if (left == null ) {
            return right;
        } else {
            return left;
        }
    }

    // 230 : 
    int kthSmallest(TreeNode root, int k) {
        return helper(root, k).val;
    }
    int count = 0;
    TreeNode helper(TreeNode root, int k) {
        if (root == null) {
            return null;
        }

        TreeNode left = helper(root.left, k);

        if (left != null) {
            return left;
        }

        count++;

        if (count == k) {
            return root;
        }

        return helper(root.right, k);
    }


    // 105:
    TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder.length == 0) {
            return null;
        }

        int root = preorder[0];
        int index = 0;

        for (int i = 0 ; i < inorder.length; i++){
            if (inorder[i] == root) {
                index = i;
            }
        }

        TreeNode node = new TreeNode(root);

        node.left = buildTree(Arrays.copyOfRange(preorder, 1, index+1), Arrays.copyOfRange(inorder, 0, index));
        node.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length), Arrays.copyOfRange(inorder, index + 1, inorder.length));
        
        return node;
    }

}
