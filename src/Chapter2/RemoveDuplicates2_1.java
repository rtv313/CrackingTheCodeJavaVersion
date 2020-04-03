package Chapter2;

public class RemoveDuplicates2_1 {

    public static void removeDuplicates(LinkedList list){

        Node runner = list.head;
        while(runner != null){

            Node runnerTwo = runner.next;
            boolean findDuplicate = false;

            while(runnerTwo != null){
                //Check if pre last node
                if(runnerTwo.next!=null && runnerTwo.next.next == null && runnerTwo.next.data == runner.data){
                    runnerTwo.next = null;
                    list.tail = runnerTwo;
                    findDuplicate = true;
                    break;
                }

                if(runnerTwo.next != null && runner.data == runnerTwo.data){
                    runnerTwo.data = runnerTwo.next.data;
                    runnerTwo.next = runnerTwo.next.next;
                    findDuplicate = true;
                    break;
                }
                runnerTwo = runnerTwo.next;
            }

            if(findDuplicate == false)
                runner = runner.next;
        }
    }


    public static void main(String args[]){

        LinkedList list = new LinkedList();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(1);
        list.addNode(4);
        list.addNode(1);
        list.addNode(1);
        list.addNode(2);

        list.displayList();
        System.out.println("###############################");
        removeDuplicates(list);
        list.displayList();

    }
}
