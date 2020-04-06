package Chapter3;

import java.util.Stack;

public class SortedWithStacks3_5 {

    Stack stackOne = new <Integer> Stack();
    Stack stackTwo = new <Integer> Stack();

    public SortedWithStacks3_5(){
        stackOne.push(3);
        stackOne.push(5);
        stackOne.push(8);
        stackOne.push(1);
        stackOne.push(4);
    }

    public void printStack(){
        for(int i = 0; i < stackOne.size(); i++){
            System.out.println(stackOne.get(i));
        }
    }

    public void sortStacks(){

        for(int i=0; i < stackOne.size(); i++) {

            while (stackOne.size() > 0) {

                if (stackTwo.size() == 0) {
                    stackTwo.push(stackOne.pop());
                }

                int tempStackOne = (int) stackOne.pop();
                int tempStackTwo = (int) stackTwo.pop();

                if (tempStackTwo < tempStackOne) {
                    stackOne.push(tempStackTwo);
                    stackTwo.push(tempStackOne);
                } else {
                    stackTwo.push(tempStackTwo);
                    stackTwo.push(tempStackOne);
                }
            }

            while(stackTwo.size()>0){
                stackOne.push(stackTwo.pop());
            }
        }
        printStack();
    }

    public static void main(String args[]){
        SortedWithStacks3_5 sort  = new SortedWithStacks3_5();
        sort.sortStacks();
    }
}
