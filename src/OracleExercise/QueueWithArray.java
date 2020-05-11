package OracleExercise;


public class QueueWithArray {
    int [] array ;
    int indexPush;
    int indexPop ;
    int actualSize;

    public QueueWithArray(int size){
        array = new int[size];
        indexPush = 0;
        indexPop = 0;
        actualSize = 0;
    }

    public void push(int newValue){

        if(actualSize >= array.length){
            return;
        }

        array[indexPush] = newValue;
        indexPush++; // 1,2,3

        if(indexPush >= array.length){
            indexPush = 0;
        }

        actualSize++;
    }

    public int peek(){

        if(actualSize <= 0){
            throw new ArrayIndexOutOfBoundsException("Error in the Queue");
        }
        return  array[indexPop];
    }

    public int pop(){

        if (actualSize <= 0){
            throw new ArrayIndexOutOfBoundsException("Error in the Queue");
        }

        int popValue  = array[indexPop];
        indexPop++;

        if(indexPop >= array.length){
            indexPop = 0;
        }

        actualSize--;
        return popValue;
    }

    public static void main(String args[]){
        // push, pop, and peek

    }
}
