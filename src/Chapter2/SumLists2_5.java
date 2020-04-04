package Chapter2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class SumLists2_5 {

    public static java.util.LinkedList sumLists(java.util.LinkedList listOne,java.util.LinkedList listTwo){

        int lenListOne = listOne.size();
        int lenListTwo = listTwo.size();
        int max = Math.max(lenListOne,lenListTwo);
        int carry = 0;
        java.util.LinkedList resultList = new java.util.LinkedList();

        for(int i = 0; i < max ; i++){

            int valueOne = 0;
            if(i <= lenListOne-1) {
                valueOne = (int)listOne.get(i);
            }

            int valueTwo = 0;
            if(i <= lenListTwo-1) {
                valueTwo = (int)listTwo.get(i);
            }

            int resultTemporary = valueOne + valueTwo + carry;
            String result = String.valueOf(resultTemporary);

            if(result.length() > 1){
                carry = Integer.parseInt(result.charAt(0)+"");
                resultList.add(Integer.parseInt(result.charAt(1)+""));
            }else{
                carry = 0;
                resultList.add(Integer.parseInt(result.charAt(0)+""));
            }
        }

        if(carry > 0){
            resultList.add(carry);
        }

        Collections.reverse(resultList);
        return resultList;
    }

    public static void main(String args[]){
        java.util.LinkedList listOne = new <Integer>LinkedList();
        java.util.LinkedList listTwo = new <Integer>LinkedList();
        // 999 is reversed
        listOne.add(9);
        listOne.add(9);
        listOne.add(9);

        //111 is reverse
        listTwo.add(1);
        listTwo.add(1);
        listTwo.add(1);

        java.util.LinkedList result = sumLists(listOne,listTwo);
        String result_s ="";
        for(Object i : result){
            result_s += String.valueOf((int)i);
        }
        System.out.println(result_s);
    }
}
