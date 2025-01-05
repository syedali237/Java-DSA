import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

public class SerializeDeserialize {



    public List<String> serialize(Node node){
        List<String> list = new ArrayList<>();
        helper(node, list);
        return list;
    }

    void helper(Node node, List<String> list){
        if (node == null) {
            list.add("null");
            return;
        }
        list.add(String.valueOf(node.val));
        helper(node.left, list);
        helper(node.right, list);
    }

    Node deserialize(List<String> list){
        Collections.reverse(list);
        Node node = helper2(list);
        return node;
    }

    Node helper2(List<String> list){
        String val = list.remove(list.size() - 1);

        if (val.charAt(0) == 'n') {
            return null;
        }

        Node node = new Node(Integer.parseInt(val));

        node.left = helper2(list);
        node.right = helper2(list);

        return node;

    }
}

// 297

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        return sb.toString();
    }

    void helper(TreeNode node, StringBuilder sb){
        if (node == null) {
            sb.append("null,");
            return;
        }
        sb.append(String.valueOf(node.val)).append(',');
        helper(node.left, sb);
        helper(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strings = data.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(strings));
        return deserializeHelper(list);
    }

    TreeNode deserializeHelper(List<String> list){

        if (list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(list.remove(0)));
        node.left = deserializeHelper(list);
        node.right = deserializeHelper(list);

        return node;

    }
}
