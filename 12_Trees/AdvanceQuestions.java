import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import javax.swing.tree.TreeNode;

import org.w3c.dom.Node;

public class AdvanceQuestions {

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


    // 987:
    List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Map<Integer, List<int[]>> map = new HashMap<>();
        Queue<Map.Entry<TreeNode, int[]>> queue = new ArrayDeque<>();

        queue.offer(new AbstractMap.SimpleEntry<>(root, new int[]{0, 0}));

        int min = 0, max = 0;

        while (!queue.isEmpty()) {
            Map.Entry<TreeNode, int[]> entry = queue.poll();
            TreeNode node = entry.getKey();
            int col = entry.getValue()[0];
            int row = entry.getValue()[1];

            if (node != null) {
                map.putIfAbsent(col, new ArrayList<>());
                map.get(col).add(new int[]{row, node.val});

                min = Math.min(min, col);
                max = Math.max(max, col);

                queue.offer(new AbstractMap.SimpleEntry<>(node.left, new int[]{col - 1, row + 1}));
                queue.offer(new AbstractMap.SimpleEntry<>(node.right, new int[]{col + 1, row + 1}));
            }
        }

        for (int i = min; i <= max; i++) {
            List<int[]> list = map.get(i);
            // Sort by row first, then value if rows are the same
            list.sort((a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
            List<Integer> sortedColumn = new ArrayList<>();
            for (int[] pair : list) {
                sortedColumn.add(pair[1]);
            }
            ans.add(sortedColumn);
        }

        return ans;
    }

    // wrong answer
    List<List<Integer>> verticalTraversalKunal(TreeNode node) {

        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        if (node == null) {
            return ans;
        }

        int col = 0;
        Queue <Map.Entry<TreeNode, Integer>> queue = new ArrayDeque<>();
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        queue.offer(new AbstractMap.SimpleEntry<>(node, col));

        int min = 0;
        int max = 0;

        while (!queue.isEmpty()) {
            Map.Entry<TreeNode, Integer> removed = queue.poll();
            node = removed.getKey();
            col = removed.getValue();

            if (node != null) {
                if (!map.containsKey(col)) {
                    map.put(col, new ArrayList<Integer>());
                }
                map.get(col).add(node.val);

                min = Math.min(min, col);
                max = Math.max(max, col);

                queue.offer(new AbstractMap.SimpleEntry<>(node.left, col - 1));
                queue.offer(new AbstractMap.SimpleEntry<>(node.right, col + 1));
            }
        }

        for (int i = min; i <= max; i++) {
            ans.add(map.get(i));
        }

        return ans;
    }


    // 127 : Word Ladder

    // Hashset approach 1 ms
    int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();

        beginSet.add(beginWord);
        endSet.add(endWord);
        int length = 1;

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            // Always expand the smaller set to optimize BFS
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> nextSet = new HashSet<>();
            for (String word : beginSet) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char original = chars[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String newWord = new String(chars);

                        if (endSet.contains(newWord)) {
                            return length + 1;
                        }

                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            nextSet.add(newWord);
                            visited.add(newWord);
                        }
                    }
                    chars[i] = original; // Revert to the original character
                }
            }

            beginSet = nextSet;
            length++;
        }

        return 0;
    }

    // queueu approach: 19ms
    int ladderLengthOptimized(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int length = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                char[] chars = current.toCharArray();

                // changing each character of the word
                for (int j = 0; j < chars.length; j++) {
                    char original = chars[j]; 

                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == original) continue;
                        chars[j] = ch;
                        String newWord = new String(chars);

                        if (newWord.equals(endWord)) {
                            return length + 1;
                        }

                        if (wordSet.contains(newWord)) {
                            queue.offer(newWord);
                            wordSet.remove(newWord);
                        }
                    }

                    chars[j] = original; // Restore the original character
                }
            }
            length++;
        }
        return 0;
    }

    // giving TLE
    int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int length = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            length++;

            for (int i = 0; i < size; i++) {
                String current = q.poll();

                for (int j = 0; j < current.length(); j++) {
                    char[] temp = current.toCharArray();
                    for (char ch = 'a' ; ch <= 'z' ; ch++){ // checking for each index of word with all the 26 characters 
                        temp[j] = ch;
                        String newWord = new String(temp);
                        if (newWord.equals(endWord)) {
                            return length + 1;
                        }

                        if (wordList.contains(newWord) && !visited.contains(newWord)) {
                            q.offer(newWord);
                            visited.add(newWord);
                        }
                    }
                }
            }
        }

        return 0;
    }

}
