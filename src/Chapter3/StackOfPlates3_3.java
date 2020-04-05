package Chapter3;

import java.util.LinkedList;

public class StackOfPlates3_3 {

    int size;
    LinkedList stackOfPlates;
    int actualStack;

    public StackOfPlates3_3(int size){
        this.size = size;
        stackOfPlates = new<LinkedList>LinkedList();
        stackOfPlates.add(new <Integer> LinkedList());
    }

    public int peek(){
        LinkedList actualStackList = (LinkedList)stackOfPlates.get(actualStack);
        if(actualStackList.size() > 0)
            return (int)actualStackList.peek();
        else
            return -1;
    }

    public void push(int newElement){

        if(stackOfPlates.size() == 0){
            stackOfPlates.add(new <Integer> LinkedList());
        }

        LinkedList actualStackList = (LinkedList)stackOfPlates.get(actualStack);
        actualStackList.add(0,newElement);

        if (actualStackList.size() > size){
            actualStack++;
            stackOfPlates.add(0,new <Integer> LinkedList());
        }
    }

    public int pop(){
        LinkedList actualStackList = (LinkedList)stackOfPlates.get(actualStack);
        int value = (int)actualStackList.pop();

        if(actualStackList.size()==0){
            stackOfPlates.remove(actualStack);
            actualStack--;
        }
        return value;
    }

    public static void main(String args[]){
        StackOfPlates3_3 stack = new StackOfPlates3_3(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("#################");
        System.out.println(stack.peek());

        System.out.println("#################");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("#################");
        System.out.println(stack.peek());

        System.out.println("#################");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
