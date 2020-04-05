package Chapter3;

public class ThreeStacksOneArray3_1 {

    int[] stacksWithArray = new int[9];
    //First Stack
    int stackOneLowerLimit = 0;
    int stackOneUpperLimit = 2;
    int stackOneIndex = 3;
    boolean flagStartEmpty = true;

    public boolean push(int stack,int data){

        if(flagStartEmpty == true){
            flagStartEmpty = false;
            stackOneIndex--;
            stacksWithArray[stackOneIndex]= data;
            stackOneIndex--;
            return true;
        }

        if(stackOneIndex > stackOneUpperLimit){ // Vacia
            return false;
        }

        if(stackOneIndex < stackOneLowerLimit){ // Llena
            return false;
        }

        stacksWithArray[stackOneIndex]= data;
        stackOneIndex--;
        return true;
    }


    public int peek(int stack){

        if(stackOneIndex > stackOneUpperLimit) {// vacia
            return -1;
        }

        if(stackOneIndex < stackOneLowerLimit){ // llena
            return  stacksWithArray[stackOneLowerLimit];
        }

        return stacksWithArray[stackOneIndex];
    }

    public int pop(int stack){


        if (stackOneIndex > stackOneUpperLimit) { // Vacia
            return -1;
        }

        if (stackOneIndex < stackOneLowerLimit) { // Llena
            stackOneIndex++;
            int value = stacksWithArray[stackOneIndex];
            stackOneIndex++;
            return value;
        }

        int value = stacksWithArray[stackOneIndex];
        stackOneIndex++;
        return value;
    }



    public static  void main(String args[]){
        ThreeStacksOneArray3_1 stacks = new ThreeStacksOneArray3_1();

        System.out.println("Stack Vacia peek" + stacks.peek(1));
        System.out.println("Stack Vacia pop" + stacks.pop(1));

        System.out.println("Stauck Push 1 " + stacks.push(1,1));
        System.out.println("Stauck Push 2 " + stacks.push(1,2));
        System.out.println("Stauck Push 3 " + stacks.push(1,3));

        System.out.println("Stack peek:" + stacks.peek(1));
        System.out.println("Stack push:" + stacks.push(1,0));

        System.out.println("################");
        System.out.println("Stack Vacia pop " + stacks.pop(1));
        System.out.println("Stack Vacia pop " + stacks.pop(1));
        System.out.println("Stack Vacia pop " + stacks.pop(1));
        System.out.println("Stack Vacia pop " + stacks.pop(1));
    }

}
