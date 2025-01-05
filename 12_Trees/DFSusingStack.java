import java.util.Stack;

public class DFSusingStack {

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

    void DFS(Node node){
        if (node == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            Node removed = stack.pop();
            System.out.println(removed.val + " ");
            if (removed.right != null) {
                stack.push(removed.right);
            }
            if (removed.left != null) {
                stack.push(removed.left);
            }
        }
    }
}
