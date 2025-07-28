public class CountDistinctSub {
    public static void main(String[] args) {
        String s = "abab";
        CountDistinctSub obj = new CountDistinctSub();
        int ans = obj.CountDistinctSub(s);
        System.out.println(ans);
    }

    class Node{
        Node links[] = new Node[26];

        public Node(){}

        boolean containsKey(char ch){
            return links[ch - 'a'] !=  null;
        }

        Node get(char ch){
            return links[ch - 'a'];
        }

        void put(char ch, Node node){
            links[ch - 'a'] = node;
        }

    }


    int CountDistinctSub(String s){
        int  n = s.length();
        int cnt = 0;
        Node root = new Node();

        for (int i = 0; i < n; i++) {
            Node node = root;
            for(int j = i ; j < n; j++){
                if (!node.containsKey(s.charAt(j))) {
                    node.put(s.charAt(j), new Node());
                    cnt++;
                }
                node = node.get(s.charAt(j));
            }
        }

        return cnt + 1;
    }
}
