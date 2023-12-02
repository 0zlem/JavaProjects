public class MyLinkedList {
    Node head;

    public void addToLast(Object data) {
        Node eklenecek = new Node(data);
        if (head == null) {
            head = eklenecek;
        } else {
            Node current = new Node(data);
            current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = eklenecek;
        }
    }

    public void addToFront(Object data) {
        Node eklenecek = new Node(data);
        eklenecek.next = head;
        head = eklenecek;
    }

    public void addToRecess(Object data,Object later) {

        Node newNode = new Node(data);
        Node temp = head;

        if (head != null) {
            while (temp.next != null) {

                if (temp.data != later) {
                    temp = temp.next;
                } else {
                    newNode.next = temp.next;
                    temp.next = newNode;
                    return;
                }

            }
        }

    }


    public Object search(Object data) {
        Node current = new Node(data);
        current = head;
        if (head == null) {
            System.out.println("liste boş");
        } else {
            while (current.next != null) {
                if (current.data == data) {
                    System.out.println("eleman bulundu!" + data);
                    return data;
                } else {
                    current = current.next;

                }

            }
            System.out.println("eleman yok");
        }
        return null;
    }

    public void deleteFromLast() {

        Node current;
        current = head;

        if (head == null) {
            System.out.println("Liste boş");
        } else {
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
        }

    }

    public void deleteFromFront() {
        if (head == null) {
            System.out.println("Liste boş!");
        } else {
            head = head.next;
        }
    }

    public void deleteFromRecess(Object value) {
        if (head == null) {
            System.out.println("Liste boş!");
        }
        if (head.data == value) {
            head = head.next;
        }
        Node current = head;
        Node prev = null;
        while (current != null && current.data != value) {
            prev = current;
            current = current.next;
        }
        if (current != null) {
            prev.next = current.next;
        } else {
            System.out.println("Value not found in the list!");
        }
    }

    public void print() {
        Node current;
        current = head;
        while (current != null) {

            System.out.println(current.data);
            current = current.next;

        }

    }

}
