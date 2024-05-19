public class LinkedList <T>{
    T type;
    private static class Node<U> {
        U item;
        Node<U> next;

        // constructor for empty node
        Node() {
            item = null; next = null;
        }

        // basic constructor. consists of item and next node
        Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }

        boolean end() { return item == null && next == null; }
    }

    private Node<T> top = new Node<T>(); // End sentinel

    //this method inserts a given item after a given node
    public void insert(T item, Node<T> node) {
        node.next = new Node<T>(item, node.next);
    }

    public void insertAtBeginning(T item) {
        insert(item, top);
    }

    public void insertAtEnd(T item) {
        Node<T> current = top;
        while (current.next != null) {
            current = current.next;
        }
        insert(item, current);
    }

    public int length() {
        int length = 0;
        Node<T> current = top;
        while (current.next != null) {
            length++;
            current = current.next;
        }
         return length;
    }

    public void reverse() {
        Node<T> prev = null;
        Node<T> current = top.next;
        Node<T> next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        top.next = prev;
    }

    public void deleteAtPosition(int position) {
        if (top.next == null) {
            System.out.println("The list is empty");
            return;
        }
        Node<T> current = top;
        int length = 0;
        while (current.next != null) {
            length++;
            current = current.next;
        }
        if (position > length) {
            System.out.println("The position is greater than the length of the list");
            return;
        }
        current = top;
        for (int i = 1; i < position; i++) {
            current = current.next;
        }
        current.next = current.next.next;
    }

    public void deleteByKey(T key) {
        Node<T> current = top;
        while (current.next != null) {
            if (current.next.item == key) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
        System.out.println("The key is not found in the list");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = top;
        while (current.next != null) {
            sb.append(current.next.item + " ");
            current = current.next;
        }
        return sb.toString();
    }

    public T get(int index) {
        Node<T> current = top;
        for (int i = 0; i <= index; i++) {
            current = current.next;
        }
        return current.item;
    }

    public T getFirst() {
        return top.next.item;
    }

    public T getLast() {
        Node<T> current = top;
        while (current.next != null) {
            current = current.next;
        }
        return current.item;
    }

    public T getNthFromEnd(int n) {
        Node<T> mainPtr = top;
        Node<T> refPtr = top;
        int count = 0;
        while (count < n + 1) {
            if (refPtr == null) {
                System.out.println(n + " is greater than the number of nodes in the list");
                return null;
            }
            refPtr = refPtr.next;
            count++;
        }
        while (refPtr != null) {
            mainPtr = mainPtr.next;
            refPtr = refPtr.next;
        }
        return mainPtr.item;
    }
}
