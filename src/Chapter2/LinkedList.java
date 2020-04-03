package Chapter2;

public class LinkedList {

    public Node head;
    public Node tail;

    public LinkedList(){
        head = null;
        tail = null;
    }

    public Node addNode(int data){
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            return newNode;
        }

        tail.next = newNode;
        tail = tail.next;
        return  newNode;
    }

    public void displayList(){

        Node runner = head;

        while(runner != null){
            System.out.println(runner.data);
            runner = runner.next;
        }
    }
}
