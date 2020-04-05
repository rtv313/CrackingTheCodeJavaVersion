package Chapter2;

import java.util.HashMap;

public class CircularListDetection2_8 {

    public static Node detectCircularNode(LinkedList list){

        HashMap<Node,Integer> counterNodes = new HashMap<>();
        Node runner = list.head;

        while(runner != null){

            if(counterNodes.containsKey(runner)){
                int counter = counterNodes.get(runner) + 1;
                if (counter >= 2)
                    return runner;
                counterNodes.put(runner,counter);
            }else{
                counterNodes.put(runner,1);
            }
            runner = runner.next;
        }
        return null;
    }

    public static void main(String args[]){
        LinkedList listOne = new LinkedList();
        listOne.addNode(1);
        listOne.addNode(2);
        listOne.addNode(3);
        Node nodeIntersec = listOne.addNode(4);
        listOne.addNode(5);
        listOne.addNode(6).next = nodeIntersec;
        System.out.println(detectCircularNode(listOne).data);
    }
}
