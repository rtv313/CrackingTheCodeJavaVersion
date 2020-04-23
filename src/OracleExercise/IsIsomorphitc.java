package OracleExercise;

import java.util.HashMap;

public class IsIsomorphitc {


    public static boolean isIsomorphicTwo(String stringOne, String stringTwo){

        // Validar tamaños
        if(stringOne.length() != stringTwo.length()){
            return false;
        }

        char [] arrayStringOne = stringOne.toCharArray();
        char [] arrayStringTwo = stringTwo.toCharArray();

        HashMap<Character,Character> map = new HashMap<Character,Character>();

        for(int i = 0; i < stringOne.length(); i++){

            char keyStringOne = arrayStringOne[i];
            char valueStringTwo =  arrayStringTwo[i];

            if(!map.containsKey(keyStringOne)){
                map.put(keyStringOne,valueStringTwo);
            }else{
                if(!(map.get(keyStringOne) == valueStringTwo)){
                    return false;
                }
            }
        }
        return true;
    }


    public static boolean isIsomorphic(String stringOne, String stringTwo){

        // Validar tamaños
        if(stringOne.length() != stringTwo.length()){
            return false;
        }

        HashMap<String,String> map = new HashMap<String,String>();

        for(int i = 0; i < stringOne.length(); i++){

            String keyStringOne = ""+stringOne.toCharArray()[i];
            String valueStringTwo = "" + stringTwo.toCharArray()[i];

            if(!map.containsKey(keyStringOne)){
                map.put(keyStringOne,valueStringTwo);
            }else{
                if(!map.get(keyStringOne).equals(valueStringTwo)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String args[]){
        //System.out.println(isIsomorphic("egg","add") + "= " +"true");
        //System.out.println(isIsomorphic("foo","bar") + "= " +"false");
        //System.out.println(isIsomorphic("paper","title") + "= " +"true");

        System.out.println(isIsomorphicTwo("foo","bar")+ "= " +"false");
    }
}
