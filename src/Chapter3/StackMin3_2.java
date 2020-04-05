package Chapter3;

public class StackMin3_2 {
    StackNode head = null;
    StackNode min = null;

    public void push(int data){
        StackNode newNode = new StackNode(data);
        if(head == null){
            head = newNode;
            min = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;

        if(newNode.data < min.data){
            StackNode temp = min;
            min = newNode;
            min.min = temp;
        }
    }

    public int peek(){
        return head.data;
    }

    public StackNode pop(){
        StackNode popNode = head;
        head = head.next;

        if(popNode == min){
            min = popNode.min;
        }
        return popNode;
    }

    public StackNode min(){
        return min;
    }

    public void printStack(){
        StackNode runner = head;
        while(runner != null){
            System.out.println(runner.data);
            runner = runner.next;
        }
    }

    public static void main(String args[]){

        StackMin3_2 stackMin = new StackMin3_2();
        stackMin.push(5);
        stackMin.push(4);
        stackMin.push(3);
        stackMin.push(2);
        stackMin.push(1);
        stackMin.printStack();
        System.out.println("Min:"+stackMin.min().data);
        System.out.println("Pop:"+stackMin.pop().data);
        System.out.println("Pop:"+stackMin.pop().data);
        System.out.println("Min:"+stackMin.min().data);
        System.out.println("Peek:"+stackMin.peek());


        StackMin3_2 stackMin2 = new StackMin3_2();
        stackMin2.push(1);
        stackMin2.push(2);
        stackMin2.push(3);
        stackMin2.push(4);
        stackMin2.push(5);
        stackMin2.printStack();
        System.out.println("Min:"+stackMin2.min().data);
        System.out.println("Pop:"+stackMin2.pop().data);
        System.out.println("Pop:"+stackMin2.pop().data);
        System.out.println("Min:"+stackMin2.min().data);
        System.out.println("Peek:"+stackMin2.peek());
    }
}
