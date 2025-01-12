import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Questions {

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

    // 101
    boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if (left == null && right == null) {
                continue;
            }

            if (left == null || right == null) {
                return false;
            }

            if (left.val != right.val) {
                return false;
            }

            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }

        return true;
    }

    // 993
    boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = findNode(root, x);
        TreeNode yy = findNode(root, y);

        return (
            (level(root, xx, 0) == level(root, yy, 0)) && (!isSibling(root, xx, yy))
        );
    }

    TreeNode findNode(TreeNode node, int x){
        if (node == null) {
            return null;
        }
        if (node.val == x) {
            return node;
        }

        TreeNode n = findNode(node.left, x);
        if (n != null) {
            return n;
        }
        return findNode(node.right, x);
    }

    boolean isSibling (TreeNode node, TreeNode x, TreeNode y){
        if (node == null) {
            return false;
        }

        return (
            (node.left == x && node.right == y) || (node.left == y && node.right == x) 
            || isSibling(node.left, x, y) || isSibling(node.right, x, y)
        );
    }

    int level(TreeNode node, TreeNode x, int lev){
        if (node == null) {
            return 0;
        }

        if (node == x) {
            return lev;
        }

        int l = level(node.left, x, lev+1);
        if (l != 0) {
            return l;
        }
        return level(node.right, x, lev+1);
    }


    // 199 
    List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.poll();

                if (i == levelSize - 1) {
                    result.add(currNode.val);
                }
                
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
    
        }

        return result;
    }



    // Question 116: perfect binary tree
    Node connect(Node root) {
         if (root == null) {
            return null;
         }

        Node leftmostNode = root;

        while (leftmostNode.left != null) {
            Node current = leftmostNode;

            // for each level
            while (current != null) {
                current.left.next = current.right;
                if (current.next != null) {
                    current.right.next = current.next.left;
                }
                current = current.next;
            }

            leftmostNode = leftmostNode.left;
        }

        return root;
    }

    // 117 : 
    Node connect2(Node root) {
        if(root == null){
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int levelSize = queue.size();
            Node prev = null;
            
            for (int i = 0; i < levelSize; i++){
                Node current = queue.poll();
                if (prev != null) {
                    prev.next = current;
                }

                prev = current;
            
                if (current.left != null){
                    queue.offer(current.left);
                }

                if (current.right != null){
                    queue.offer(current.right);
                }
            }

            if (prev != null) {
                prev.next = null;
            }
        }
        
        return root;
    }

    // Question 103:
    List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);

        boolean reverse = false;

        while (!deque.isEmpty()) {
            int levelSize = deque.size();
            List<Integer> currLevel = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {

                if (!reverse) {
                    TreeNode currNode = deque.pollFirst();
                    currLevel.add(currNode.val);
                    if (currNode.left != null) {
                        deque.addLast(currNode.left);
                    }
                    if (currNode.right != null) {
                        deque.addLast(currNode.right);
                    }
                } else {
                    TreeNode currNode = deque.pollLast();
                    currLevel.add(currNode.val);
                    // first add right else it will be reversed
                    if (currNode.right != null) {
                        deque.addFirst(currNode.right);
                    }
                    if (currNode.left != null) {
                        deque.addFirst(currNode.left);
                    }
                }
            }
            reverse = !reverse;
            result.add(currLevel);
        }

        return result;
    }


    // BFS : Question 102
    List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currLevel = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.poll();
                currLevel.add(currNode.val);
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
            result.add(currLevel);
        }

        return result;
    }

    // 111:
    int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
    
            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.poll();

                if (currNode.left == null && currNode.right == null) {
                    return depth;
                }
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
            depth++;
        }
        return 0;
    }

    // Question 637 : Google
    List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double average = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.poll();
                average += currNode.val;
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
            average = average / levelSize;
            result.add(average);
        }

        return result;
    }

    TreeNode findSuccessor(TreeNode root, int key){
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            if (currNode.left != null) {
                queue.offer(currNode.left);
            }
            if (currNode.right != null) {
                queue.offer(currNode.right);
            }
            if (currNode.val == key) {
                break;
            }
        }

        return queue.peek();
    }

    // Question 1161 : 
    int maxLevelSum(TreeNode root) {
        List<Integer> levelSums = sumOfLevels(root);
        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 0;
        for (int i = 0; i < levelSums.size(); i++) {
            if (levelSums.get(i) > maxSum) {
                maxSum = levelSums.get(i);
                maxLevel = i + 1;
            }
        }
        return maxLevel;
    }
    List<Integer> sumOfLevels(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int sum = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.poll();
                sum += currNode.val;
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
            result.add(sum);
        }
        return result;
    }


}