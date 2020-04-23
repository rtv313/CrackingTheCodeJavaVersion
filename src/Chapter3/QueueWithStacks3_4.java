package Chapter3;

import java.util.LinkedList;

public class QueueWithStacks3_4 {

    LinkedList stackOne = new <Integer> LinkedList();
    LinkedList stackTwo = new <Integer> LinkedList();

    public int peek(){

        if(stackOne.size() == 0){
            return -1;
        }

        int size = stackOne.size();

        for(int i = 0; i < size; i++){
            stackTwo.add(0,stackOne.pop());
        }

        int peekValue = (int) stackTwo.peek();

        for(int i = 0; i < size; i++){
            stackOne.add(0,stackTwo.pop());
        }
        return peekValue;
    }

    public void push(int data){
        stackOne.add(0,data);
    }

    public int pop(){

        if(stackOne.size() == 0){
            return -1;
        }

        int sizeStack = stackOne.size();
        for(int i = 0; i < sizeStack; i++){
            stackTwo.add(0,stackOne.pop());
        }

        int popValue = (int) stackTwo.pop();
        sizeStack = stackTwo.size();

        for(int i = 0; i < sizeStack; i++){
            stackOne.add(0,stackTwo.pop());
        }
        return popValue;
    }

    public static void main(String args[]){
        QueueWithStacks3_4 queue = new QueueWithStacks3_4();
        queue.push(1);
        queue.push(2);
        queue.push(3);

        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}
