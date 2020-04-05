package Chapter3;

public class ThreeStacksOneArray3_1 {

    int[] stacksWithArray = new int[9];
    //First Stack
    int stackOneLowerLimit = 0;
    int stackOneUpperLimit = 2;
    int stackOneIndex = 3;
    boolean flagStartEmptyStackOne = true;

   //Second Stack
   int stackTwoLowerLimit = 3;
   int stackTwoUpperLimit = 5;
   int stackTwoIndex = 6;
   boolean flagStartEmptyStackTwo = true;

   //Third Stack
   int stackThreeLowerLimit = 6;
   int stackThreeUpperLimit = 8;
   int stackThreeIndex = 9;
   boolean flagStartEmptyStackThree = true;


    public boolean push(int stack,int data){

        switch(stack) {
            case 1:
                if (flagStartEmptyStackOne == true) {
                    flagStartEmptyStackOne = false;
                    stackOneIndex--;
                    stacksWithArray[stackOneIndex] = data;
                    stackOneIndex--;
                    return true;
                }

                if (stackOneIndex > stackOneUpperLimit) { // Vacia
                    return false;
                }

                if (stackOneIndex < stackOneLowerLimit) { // Llena
                    return false;
                }

                stacksWithArray[stackOneIndex] = data;
                stackOneIndex--;
                return true;

            case 2:
                if (flagStartEmptyStackTwo == true) {
                    flagStartEmptyStackTwo = false;
                    stackTwoIndex--;
                    stacksWithArray[stackTwoIndex] = data;
                    stackTwoIndex--;
                    return true;
                }

                if (stackTwoIndex > stackTwoUpperLimit) { // Vacia
                    return false;
                }

                if (stackTwoIndex < stackTwoLowerLimit) { // Llena
                    return false;
                }

                stacksWithArray[stackTwoIndex] = data;
                stackTwoIndex--;
                return true;

            case 3:
                if (flagStartEmptyStackThree == true) {
                    flagStartEmptyStackThree = false;
                    stackThreeIndex--;
                    stacksWithArray[stackThreeIndex] = data;
                    stackThreeIndex--;
                    return true;
                }

                if (stackThreeIndex > stackThreeUpperLimit) { // Vacia
                    return false;
                }

                if (stackThreeIndex < stackThreeLowerLimit) { // Llena
                    return false;
                }

                stacksWithArray[stackThreeIndex] = data;
                stackThreeIndex--;
                return true;

            default:
                return false;
        }
    }


    public int peek(int stack){

        switch (stack) {

            case 1:
                if (stackOneIndex > stackOneUpperLimit) {// vacia
                    return -1;
                }

                if (stackOneIndex < stackOneLowerLimit) { // llena
                    return stacksWithArray[stackOneLowerLimit];
                }

                return stacksWithArray[stackOneIndex];

            case 2:
                if (stackTwoIndex > stackTwoUpperLimit) {// vacia
                    return -1;
                }

                if (stackTwoIndex < stackTwoLowerLimit) { // llena
                    return stacksWithArray[stackTwoLowerLimit];
                }

                return stacksWithArray[stackTwoIndex];

            case 3:
                if (stackThreeIndex > stackThreeUpperLimit) {// vacia
                    return -1;
                }

                if (stackThreeIndex < stackThreeLowerLimit) { // llena
                    return stacksWithArray[stackThreeLowerLimit];
                }

                return stacksWithArray[stackThreeIndex];

            default:
                return -1;
        }
    }

    public int pop(int stack){

        switch (stack) {
            case 1:
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

            case 2:
                if (stackTwoIndex > stackTwoUpperLimit) { // Vacia
                    return -1;
                }

                if (stackTwoIndex < stackTwoLowerLimit) { // Llena
                    stackTwoIndex++;
                    int value2 = stacksWithArray[stackTwoIndex];
                    stackTwoIndex++;
                    return value2;
                }

                int value2 = stacksWithArray[stackTwoIndex];
                stackTwoIndex++;
                return value2;

            case 3:
                if (stackThreeIndex > stackThreeUpperLimit) { // Vacia
                    return -1;
                }

                if (stackThreeIndex < stackThreeLowerLimit) { // Llena
                    stackThreeIndex++;
                    int value3 = stacksWithArray[stackThreeIndex];
                    stackThreeIndex++;
                    return value3;
                }

                int value3 = stacksWithArray[stackThreeIndex];
                stackThreeIndex++;
                return value3;

            default:
                return -1;
        }
    }



    public static  void main(String args[]){
        ThreeStacksOneArray3_1 stacks = new ThreeStacksOneArray3_1();

        System.out.println("Stack 1");
        System.out.println("Stack 1 Vacia peek" + stacks.peek(1));
        System.out.println("Stack 1 Vacia pop" + stacks.pop(1));
        System.out.println("Stack 1 Push 1 " + stacks.push(1,1));
        System.out.println("Stack 1 Push 2 " + stacks.push(1,2));
        System.out.println("Stack 1 Push 3 " + stacks.push(1,3));
        System.out.println("Stack 1 peek:" + stacks.peek(1));
        System.out.println("Stack 1 push:" + stacks.push(1,0));
        System.out.println("Stack 1  pop " + stacks.pop(1));
        System.out.println("Stack 1  pop " + stacks.pop(1));
        System.out.println("Stack 1  pop " + stacks.pop(1));
        System.out.println("Stack 1 Vacia pop " + stacks.pop(1));
        System.out.println("################");


        System.out.println("Stack 2");
        System.out.println("Stack 2 Vacia peek" + stacks.peek(2));
        System.out.println("Stack 2 Vacia pop" + stacks.pop(2));
        System.out.println("Stack 2 Push 1 " + stacks.push(2,1));
        System.out.println("Stack 2 Push 2 " + stacks.push(2,2));
        System.out.println("Stack 2 Push 3 " + stacks.push(2,3));
        System.out.println("Stack 2 peek:" + stacks.peek(2));
        System.out.println("Stack 2 push:" + stacks.push(2,0));
        System.out.println("Stack 2  pop " + stacks.pop(2));
        System.out.println("Stack 2  pop " + stacks.pop(2));
        System.out.println("Stack 2  pop " + stacks.pop(2));
        System.out.println("Stack 2 Vacia pop " + stacks.pop(2));
        System.out.println("################");


        System.out.println("Stack 3");
        System.out.println("Stack 3 Vacia peek" + stacks.peek(3));
        System.out.println("Stack 3 Vacia pop" + stacks.pop(3));
        System.out.println("Stack 3 Push 1 " + stacks.push(3,1));
        System.out.println("Stack 3 Push 2 " + stacks.push(3,2));
        System.out.println("Stack 3 Push 3 " + stacks.push(3,3));
        System.out.println("Stack 3 peek:" + stacks.peek(3));
        System.out.println("Stack 3 push:" + stacks.push(3,0));
        System.out.println("Stack 3  pop " + stacks.pop(3));
        System.out.println("Stack 3  pop " + stacks.pop(3));
        System.out.println("Stack 3  pop " + stacks.pop(3));
        System.out.println("Stack 3 Vacia pop " + stacks.pop(3));

    }
}
