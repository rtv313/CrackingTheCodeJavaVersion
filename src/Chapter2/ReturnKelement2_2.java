package Chapter2;

import java.util.Stack;

public class ReturnKelement2_2 {

    public static Node returnkelement(LinkedList list,int kElement){

        Node runner = list.head;
        Stack stack = new Stack();

        while(runner!=null){
            stack.push(runner);
            runner = runner.next;
        }

        for(int i=0; i <= kElement; i++){
            if(i==kElement){
                return (Node)stack.pop();
            }
            stack.pop();
        }
        return null;
    }


    public static void main(String args[]){
        LinkedList list = new LinkedList();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);
        list.addNode(6);
        list.displayList();
        System.out.println("#####################");
        System.out.println(returnkelement(list,1).data);
        System.out.println(returnkelement(list,2).data);
        System.out.println(returnkelement(list,3).data);
    }
}
