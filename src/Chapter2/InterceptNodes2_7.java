package Chapter2;

import java.util.HashMap;
import java.util.HashSet;

public class InterceptNodes2_7 {

    public static Node getInterceptNode(LinkedList listOne,LinkedList listTwo){
        HashSet<Node> nodesSet = new HashSet<Node>();
        Node runnerListOne = listOne.head;
        Node runnerListTwo = listTwo.head;

        while(runnerListOne != null){
            nodesSet.add(runnerListOne);
            runnerListOne = runnerListOne.next;
        }

        while(runnerListTwo != null){

            if(nodesSet.contains(runnerListTwo))
                return runnerListTwo;

            runnerListTwo = runnerListTwo.next;
        }

        return  null;
    }

    public static void main(String args[]){

        LinkedList listOne = new LinkedList();
        listOne.addNode(1);
        listOne.addNode(2);
        listOne.addNode(3);
        Node nodeIntersec = listOne.addNode(4);
        listOne.addNode(5);
        listOne.addNode(6);

        LinkedList listTwo= new LinkedList();
        listTwo.addNode(1);
        listTwo.addNode(2);
        listTwo.addNode(3).next = nodeIntersec;

        System.out.println(getInterceptNode(listOne,listTwo).data);
    }
}
