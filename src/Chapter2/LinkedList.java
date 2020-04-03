package Chapter2;

public class LinkedList {

    public Node head;
    public Node tail;

    public LinkedList(){
        head = null;
        tail = null;
    }

    public void addNode(int data){
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = tail.next;
    }

    public void displayList(){

        Node runner = head;

        while(runner != null){
            System.out.println(runner.data);
            runner = runner.next;
        }
    }
}
