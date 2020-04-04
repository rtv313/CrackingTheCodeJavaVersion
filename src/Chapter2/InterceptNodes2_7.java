package Chapter2;

import java.util.HashMap;

public class InterceptNodes2_7 {

    public static Node getInterceptNode(LinkedList listOne,LinkedList listTwo){
        HashMap<Node,Integer> nodesCounterMap = new HashMap<>();
        Node runnerListOne = listOne.head;
        Node runnerListTwo = listTwo.head;

        while(runnerListOne != null){

            if(nodesCounterMap.containsKey(runnerListOne)){
                int counter = nodesCounterMap.get(runnerListOne) + 1;
                nodesCounterMap.put(runnerListOne,counter);
            }else{
                nodesCounterMap.put(runnerListOne,1);
            }
            runnerListOne = runnerListOne.next;
        }

        while(runnerListTwo != null){

            if(nodesCounterMap.containsKey(runnerListTwo)){
                int counter = nodesCounterMap.get(runnerListTwo) + 1;
                if(counter > 1)
                    return runnerListTwo;
                nodesCounterMap.put(runnerListTwo,counter);
            }else{
                nodesCounterMap.put(runnerListTwo,1);
            }
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
