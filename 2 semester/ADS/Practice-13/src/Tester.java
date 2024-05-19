public class Tester {
    public static void main(String[] args){
        LinkedList<Integer> list = new LinkedList<>();

        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.insertAtEnd(5);

        System.out.println(list);
        System.out.println(list.length());
        list.reverse();
        System.out.println(list);
        list.deleteAtPosition(3);
        System.out.println(list);
        list.deleteByKey(2);
        list.deleteAtPosition(0);
        System.out.println(list);
        System.out.println(list.getNthFromEnd(0));
    }
}
