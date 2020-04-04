package Chapter2;

public class Partition2_4 {

    public static void partition(LinkedList list,int x){
        LinkedList belowX = new LinkedList();
        LinkedList equalX = new LinkedList();
        LinkedList aboveX = new LinkedList();
        Node runner = list.head;

        while(runner != null){
            if(runner.data < x){
                belowX.addNode(runner.data);
            }
            if(runner.data > x){
                aboveX.addNode(runner.data);
            }
            if(runner.data == x){
                equalX.addNode(runner.data);
            }
            runner = runner.next;
        }

        if(equalX.head == null){
            belowX.tail.next = aboveX.head;
            list.head = belowX.head;
        }else{
            belowX.tail.next = equalX.head;
            equalX.tail.next = aboveX.head;
            list.head = belowX.head;
        }
    }

    public static void main(String args[]){
        LinkedList list  = new LinkedList();
        list.addNode(10);
        list.addNode(9);
        list.addNode(8);
        list.addNode(7);
        list.addNode(6);
        //list.addNode(5);
        list.addNode(4);
        list.addNode(3);
        list.addNode(2);
        list.addNode(1);
        partition(list,5);
        list.displayList();
    }
}
