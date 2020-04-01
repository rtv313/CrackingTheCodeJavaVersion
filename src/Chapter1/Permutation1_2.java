package Chapter1;

import com.sun.org.apache.xpath.internal.functions.FuncFalse;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Permutation1_2 {

    public static boolean isPermutation(String stringOne,String stringTwo){

        if(stringOne.length() != stringTwo.length())
            return false;

        Set<String> setOne = new HashSet<String>();
        Set<String> setTwo = new HashSet<String>();
        Map<String,Integer> hashStringOne = new HashMap<String,Integer>();
        Map<String,Integer> hashStringTwo = new HashMap<String,Integer>();

        for(char ch : stringOne.toCharArray()){
            String key = ""+ch;
            setOne.add(key);
            if(hashStringOne.get(key) == null) {
                hashStringOne.put(key, 1);
            }else{
                int counter = hashStringOne.get(key) + 1;
                hashStringOne.put(key,counter);
            }
        }

        for(char ch : stringTwo.toCharArray()){
            String key = ""+ch;
            setTwo.add(key);
            if(hashStringTwo.get(key) == null) {
                hashStringTwo.put(key, 1);
            }else{
                int counter = hashStringTwo.get(key) + 1;
                hashStringTwo.put(key,counter);
            }
        }

        if(!setOne.equals(setTwo)){
            return false;
        }

        for (String key : setOne){
            if(hashStringOne.get(key) != hashStringTwo.get(key)){
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]){
        System.out.println(Permutation1_2.isPermutation("dog","god"));
        System.out.println(Permutation1_2.isPermutation("dog","godd"));
        System.out.println(Permutation1_2.isPermutation("aabbccc","cccbbaa"));
        System.out.println(Permutation1_2.isPermutation("aabbccc","cccbtaa"));
    }
}
