
public class LL {

    private Node head;
    private Node tail;

    private int size;

    public LL(){
        this.size = 0;
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }
        size += 1;
    }

    public void insertLast(int val){
        if (tail == null) {
            insertFirst(val);
            return;  
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size += 1;
    }

    public void insert(int val, int index){
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index == size) {
            insertLast(val);
            return;
        }

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        Node node = new Node(val, temp.next);
        temp.next = node;
        size++;
    }

    // insert using recursion
    public void insertRec(int val, int index){
        head = insertRec(val, index, head);
    }

    private Node insertRec(int val, int index, Node node){
        if (index == 0) {
            Node temp = new Node(val, node);
            size++;
            return temp;
        }
        node.next = insertRec(val, index-1, node.next);
        return node;
    }

    public Node find(int value){
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public Node get(int index){
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public int deleteFirst(){
        int val = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return val;
    }

    public int deleteLast() {
        if (size <= 1) {
            return deleteFirst();
        }
        Node secondLast = get(size - 2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        size--;
        return val;
    }

    public int delete(int index){
        if (index == 0) {
            return deleteFirst();
        }
        if (index == size - 1) {
            return deleteLast();
        }
        Node prev = get(index -1);
        int val = prev.next.value;
        prev.next = prev.next.next;
        size--;
        return val;
    }


    public void display(){
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " --> ");
            temp = temp.next;
        }
        System.out.println("END"); 
    }

    // questions:

    // Removing Duplicates (Leetcode 83)
    public void duplicates(){
        Node node = head;

        while (node.next != null) {
            if (node.value == node.next.value) {
                node.next = node.next.next;
                size--;
            } else {
                node = node.next;
            }
        }
        tail = node;
        tail.next = null;
    }

    // merge
    public static LL merge(LL first, LL second){
        Node f = first.head;
        Node s = second.head;

        LL ans = new LL();

        while (f != null && s != null) {
            if (f.value < s.value) {
                ans.insertLast(f.value);
                f = f.next;
            } else {
                ans.insertLast(s.value);
                s = s.next;
            }
        }

        while (f != null) {
            ans.insertLast(f.value);
            f = f.next;
        }

        while (s != null) {
            ans.insertLast(s.value);
            s = s.next;
        }
        return  ans;
    }

    public void bubbleSort(){
        bubbleSort(size - 1, 0);
    }

    private void bubbleSort(int row,int col){
        if (row == 0) {
            return;
        }

        if (col < row) {
            Node first = get(col);
            Node second = get(col + 1);

            if (first.value > second.value) {
                // swap
                if (first == head) {
                    head = second;
                    first.next = second.next;
                    second.next = first;
                } else if (second == tail) {
                    Node prev = get(col - 1);
                    prev.next = second;
                    tail = first;
                    first.next = null;
                    second.next = tail;
                } else {
                    Node prev = get(col - 1);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }
            bubbleSort(row, col + 1);
        } else {
            bubbleSort(row - 1, 0);
        }
    }

    // REVERSE A LINKED LIST : using recursion
    private void reverse(Node node){
        if (node == tail) {
            head = tail;
            return;
        }
        reverse(node.next);

        tail.next = node;
        tail = node;
        tail.next = null;
    }

    // In place reversal of LL

    private void reverse(){
        if (size < 2) {
            return;
        }

        Node prev = null;
        Node present = head;
        Node next = present.next;
        
        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;    
            }
        }
        head = prev;
    }

    ListNode reverseBetween(ListNode head, int left, int right){
        if (left == right) {
            return head;
        }

        // skip the first left-1 nodes
        ListNode current = head;
        ListNode prev = null;
        for (int i = 0; current != null && i < left - 1; i++) {
            prev = current;
            current = current.next;
        }

        ListNode last = prev;
        ListNode newEnd = current;

        // reverse between left and right

        ListNode next = current.next;
        for (int i = 0; current != null && i < right -left + 1;  i++) {
            current.next = prev;
            prev = current;
            current = next;
            if (next != null) {
                next = next.next;    
            }
        }

        if (last != null) {
            last.next = prev;
        } else {
            head = prev;
        }
        newEnd.next = current;
        return head;
    }

    // Pallindrome LL
    boolean isPalindrome(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode headSecond = reverseList(mid);
        ListNode reverseHead = headSecond;

        // compare both the halves

        while (head != null && headSecond != null) {
            if (head.val != headSecond.val) {
                break;
            }
            head = head.next;
            headSecond = headSecond.next;
        }
        reverseList(reverseHead);
        return head == null || headSecond == null;
    }

    ListNode middleNode(ListNode head) {
        ListNode s = head;
        ListNode f = head;

        while (f != null && f.next != null ) {
            s = s.next;
            f = f.next.next;
        }

        return s;
    }


    ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode present = head;
        ListNode next = (head != null) ? head.next : null;
        
        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;    
            }
        }
        return prev;
    }

    // 143 : ReorderList
    void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode mid = middleNode(head);
        ListNode headSecond = reverseList(mid);
        ListNode headFirst = head;

        while (headFirst != null && headSecond != null) {
            ListNode temp = headFirst.next;
            headFirst.next = headSecond;
            headFirst = temp;

            temp = headSecond.next;
            headSecond.next = headFirst;
            headSecond = temp;
        }

        // next of tail to null
        if (headFirst != null) {
            headFirst.next = null;
        }
    }

    // 25 : Reverse in K groups
ListNode reverseKGroup(ListNode head, int k) {
    // Base case: if k <= 1 or the list is empty, no need to reverse
    if (k <= 1 || head == null) {
        return head;
    }

    ListNode current = head;  // Pointer to traverse the list
    ListNode prev = null;     // Pointer to the previous group

    while (true) { 
        // Step 1: Check if there are at least k nodes left to reverse
        ListNode temp = current;  // Temporary pointer to count k nodes
        for (int i = 0; i < k; i++) {
            if (temp == null) {
                return head;  // Return the list as is if less than k nodes left
            }
            temp = temp.next;
        }

        // Step 2: Mark the last node of the previous group and the first node of the next group
        ListNode last = prev;  // Points to the last node of the previous group
        ListNode newEnd = current;  // The first node of the current group (will be the new end after reversal)

        // Step 3: Reverse the next k nodes
        ListNode next = current.next;  // Pointer to keep track of the next node in the list
        for (int i = 0; current != null && i < k; i++) {
            current.next = prev;  // Reverse the current node's pointer to the previous node
            prev = current;       // Move the prev pointer to the current node
            current = next;       // Move the current pointer to the next node
            if (next != null) {
                next = next.next;  // Advance the next pointer
            }
        }

        // Step 4: Connect the previous part of the list with the reversed group
        if (last != null) {
            last.next = prev;  // Connect the last node of the previous group to the current reversed group
        } else {
            head = prev;  // If this is the first group, update the head of the list
        }

        // Step 5: Connect the end of the reversed group to the remaining nodes
        newEnd.next = current;

        // Step 6: If we've reached the end of the list, exit the loop
        if (current == null) {
            break;
        }

        // Step 7: Prepare for the next group by updating prev to the end of the current group
        prev = newEnd;
    }
    
    return head;  // Return the new head of the list after all reversals
}

// Revers K group alternatively

    ListNode reverseKGroupAlternatively(ListNode head, int k) {
    if (k <= 1 || head == null) {
        return head;
    }

    ListNode current = head;
    ListNode prev = null;

    while (current != null) { 
        // Check if there are at least k nodes to reverse
        ListNode temp = current;
        for (int i = 0; i < k; i++) {
            if (temp == null) {
                return head;  // If fewer than k nodes, return the current head
            }
            temp = temp.next;
        }

        ListNode last = prev;
        ListNode newEnd = current;

        // Reverse the next k nodes
        ListNode next = current.next;
        for (int i = 0; current != null && i < k; i++) {
            current.next = prev;
            prev = current;
            current = next;
            if (next != null) {
                next = next.next;    
            }
        }

        if (last != null) {
            last.next = prev;
        } else {
            head = prev;
        }

        newEnd.next = current;

        // skip the k nodes
        for (int i = 0; current != null && i < k; i++) {
            prev = current;
            current = current.next;
        }
    }
    
    return head;
}


// 61 ROTATE LIST

    ListNode rotateRight(ListNode head, int k) {

        if (k <= 0 || head == null || head.next == null){
            return head;
        }
        
        ListNode last = head;
        int length = 1;
        while (last.next != null) {
            last = last.next;
            length++;
        } 

        int rotations = k % length;
        if (rotations == 0) {
            return head;  // No rotation is needed if k is a multiple of the list length
        }
        last.next = head;
        int stepsToNewEnd = length - rotations;
        ListNode newEnd = head;
        for (int i = 1; i < stepsToNewEnd; i++) {
            newEnd = newEnd.next;
        }
        head = newEnd.next;
        newEnd.next = null;
        return head;
    }



    public static void main(String[] args) {
        LL first = new  LL();
        LL second = new  LL();

        first.insertLast(1);
        first.insertLast(5);
        first.insertLast(7);

        second.insertLast(1);
        second.insertLast(2);
        second.insertLast(9);
        second.insertLast(14);

        // LL ans = LL.merge(first, second);
        // ans.display();

        LL list = new LL();
        for (int i = 7; i > 0; i--) {
            list.insertLast(i);
        }

        list.display();
        list.bubbleSort();
        list.display();
    }


    private class Node {
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }
} 