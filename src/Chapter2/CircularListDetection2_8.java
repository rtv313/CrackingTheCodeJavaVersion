package Chapter2;

import java.util.HashMap;
import java.util.HashSet;

public class CircularListDetection2_8 {

    public static Node detectCircularNode(LinkedList list){

        HashSet<Node> counterNodes = new HashSet<Node>();
        Node runner = list.head;

        while(runner != null){

           if(counterNodes.contains(runner)){
               return runner;
           }else{
               counterNodes.add(runner);
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
        listOne.addNode(6);
        listOne.addNode(6).next = nodeIntersec;
        System.out.println(detectCircularNode(listOne).data);


        LinkedList listTwo = new LinkedList();
        listTwo.addNode(1);
        listTwo.addNode(2);
        listTwo.addNode(3);
        listTwo.addNode(4);
        listTwo.addNode(5);
        listTwo.addNode(5);
        System.out.println(detectCircularNode(listTwo));
    }
}
