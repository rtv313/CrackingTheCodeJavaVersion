package Chapter1;

public class PrintFiboIterative {
    public  static int[] fibo(int limit){
        int [] numbers = new int[limit];
        int numIteration=limit;
        int resultado1=1;
        int resultado2=1;
        int resultadoFinal=0;

        for(int x=0;x<numIteration;x++){
            if(x==0 || x==1){
                resultadoFinal=1;
                numbers[x]=resultadoFinal;

            }else{
                resultadoFinal= resultado1+resultado2;
                numbers[x]=resultadoFinal;
                resultado1=resultado2;
                resultado2=resultadoFinal;
            }
        }
        return numbers;
    }

    public static void main(String args[]){

        int[] numbers = fibo(5);

        for(int x=0;x<numbers.length;x++){
            System.out.println(numbers[x]);
        }
    }
}
