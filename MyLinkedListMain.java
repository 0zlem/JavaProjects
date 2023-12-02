public class MyLinkedListMain {
    public static void main(String[] args) {

        MyLinkedList list= new MyLinkedList();

        list.addToLast(5);
        list.addToLast(7);
        list.addToLast(8);

        list.addToRecess(10,7);
        list.print();
    }
}
