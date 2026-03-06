import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class LineTraversals {

    class Tuple{
        TreeNode node;
        int vertical;
        int level;

        Tuple(TreeNode _node, int _vertical, int _level){
            node = _node;
            vertical = _vertical;
            level = _level; 
        }
    }
    // https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>> > map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0,0));

        while (!q.isEmpty()){
            Tuple curr = q.poll();
            TreeNode node = curr.node;
            int v = curr.vertical;
            int l = curr.level;

            if (!map.containsKey(v)){ // putting verticals
                map.put(v, new TreeMap<>());
            }

            if(!map.get(v).containsKey(l)){ // putting levels
                map.get(v).put(l, new PriorityQueue<>());                
            }

            map.get(v).get(l).offer(node.val);

            if (node.left != null) q.add(new Tuple(node.left, v - 1, l + 1));
            if (node.right != null) q.add(new Tuple(node.right, v + 1, l + 1));
        }

        List<List<Integer>> list = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> y : map.values()){
            list.add(new ArrayList<>());
            for (PriorityQueue<Integer> pq : y.values()){
                while (!pq.isEmpty()){
                    list.get(list.size() - 1).add(pq.poll());
                }
            }
        }

        return list;
    }


    /*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

    static class Pair{
        Node node;
        int vertical;
        
        Pair(Node node, int vertical){
            this.node = node;
            this.vertical = vertical;
        }
    }
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Node> map = new TreeMap<>();
        q.offer(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair curr = q.poll();
            Node node = curr.node;
            int vertical = curr.vertical;
            
            if (!map.containsKey(vertical)){
                map.put(vertical , node);
            }
            
            if (node.left != null) q.add(new Pair(node.left, vertical - 1));
            if (node.right != null) q.add(new Pair(node.right, vertical + 1));
        }
        
        for (Node n : map.values()){
            list.add(n.val);
        }
        
        return list;
    }

    ArrayList<Integer> bottomView(Node root) {
        // Code here
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Node> map = new TreeMap<>();
        q.offer(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair curr = q.poll();
            Node node = curr.node;
            int vertical = curr.vertical;
            map.put(vertical, node);
            
            if (node.left != null) q.add(new Pair(node.left, vertical - 1));
            if (node.right != null) q.add(new Pair(node.right, vertical + 1));
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for (Node n : map.values()){
            list.add(n.val);
        }
        return list;
    }

    ArrayList<Integer> leftView(Node root) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;
        
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for (int i = 0; i < size; i++){
                Node curr = q.poll();
                if (i == 0) list.add(curr.val);
                
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
        }
        
        return list;
    }

    List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        List<Integer> list = new ArrayList<>();

        while (!q.isEmpty()){
            int levelSize = q.size();

            for (int i = 0; i < levelSize; i++){
                TreeNode curr = q.poll();

                if (i == levelSize - 1){
                    list.add(curr.val);
                }

                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
        }

        return list;
    }

    List<Integer> rightSideView2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, 0, res);
        return res;
    }

    void helper(TreeNode node, int level, List<Integer> res){
        if (node == null) return;

        if (level == res.size()) res.add(node.val);

        helper(node.right, level + 1, res);
        helper(node.left, level + 1, res);
    }


    // Boundary Traversal
    ArrayList<Integer> boundaryTraversal(Node root) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        if (root.left != null || root.right != null) {
            list.add(root.val);
        }
        
        leftBoundary(root, list);
        leafNodes(root, list);
        rightBoundary(root, list);
        return list;
    }
    
    void leftBoundary(Node node, ArrayList<Integer> list){
        Node curr = node.left;
        while (curr != null){
            if (curr.left != null || curr.right != null) list.add(curr.val);
            
            if (curr.left != null){
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }
    
    void leafNodes(Node node, ArrayList<Integer> list){
        if (node.left == null && node.right == null) {
            list.add(node.val);
            return;
        }
        
        if (node.left != null) leafNodes(node.left, list);
        if (node.right != null) leafNodes(node.right, list);
    }
    
    void rightBoundary(Node node, ArrayList<Integer> list){
        Stack<Integer> st = new Stack<>();
        Node curr = node.right;
        while (curr != null){
            if (curr.left != null || curr.right != null) st.push(curr.val);
            
            if (curr.right != null){
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        
        while(!st.isEmpty()){
            list.add(st.pop());
        }
    }

}
