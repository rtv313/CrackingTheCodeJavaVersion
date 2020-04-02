package Chapter1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class OneWay1_5 {

    public static boolean oneWay(String stringOne,String stringTwo){

        int lenStringOne = stringOne.length();
        int lenStringTwo = stringTwo.length();
        int lenDif = lenStringOne - lenStringTwo;

        if (Math.abs(lenDif) > 1){
            return false;
        }

        Map<Character,Integer> mapStringOne = new HashMap<Character, Integer>();
        Map<Character,Integer> mapStringTwo = new HashMap<Character, Integer>();

        for(char ch : stringOne.toCharArray()){

            if(!mapStringOne.containsKey(ch)){
                mapStringOne.put(ch,1);
            }else{
                int counter = mapStringOne.get(ch) + 1;
                mapStringOne.put(ch,counter);
            }
        }

        for(char ch : stringTwo.toCharArray()){

            if(!mapStringTwo.containsKey(ch)){
                mapStringTwo.put(ch,1);
            }else{
                int counter = mapStringTwo.get(ch) + 1;
                mapStringTwo.put(ch,counter);
            }
        }

        int countChanges = 0;
        Set keys = new HashSet<Character>();
        keys.addAll(mapStringOne.keySet());
        keys.addAll(mapStringTwo.keySet());

       for (Object item : keys.toArray()){
           char key = (char)item;
           int countHashOne = 0;
           int countHashTwo = 0;

           if(mapStringOne.containsKey(key)){
               countHashOne = mapStringOne.get(key);
           }

           if(mapStringTwo.containsKey(key)){
               countHashTwo = mapStringTwo.get(key);
           }

           int changes = Math.abs(countHashOne - countHashTwo);
           countChanges+=changes;
       }

       if (lenStringOne == lenStringTwo && countChanges > 2){
           return false;
       }

        if (lenStringOne < lenStringTwo && countChanges > 1){
            return false;
        }

        if (lenStringOne > lenStringTwo && countChanges > 1){
            return false;
        }

       return true;
    }

    public static void main(String args[]) {

        System.out.println("aabbcc -> aabbcd :" + OneWay1_5.oneWay("aabbcc","aabbcd")+": true");
        System.out.println("aabbcc -> aabbdd :" + OneWay1_5.oneWay("aabbcc","aabbdd")+": false");
        System.out.println("ababab -> abbbbb:" + OneWay1_5.oneWay("ababab","abbbbb")+": false");
        System.out.println("ababab -> ababbb :" + OneWay1_5.oneWay("ababab","ababbb")+": true");
        System.out.println("ababab -> bbabbb :" + OneWay1_5.oneWay("ababab","bbabbb")+": false");
        System.out.println("aabbcc -> aabbc :" + OneWay1_5.oneWay("aabbcc","aabbc")+": true");
        System.out.println("aabbcc -> abbbc :" + OneWay1_5.oneWay("aabbcc","abbbc")+": false");
        System.out.println("aabbcc -> axbbc :" + OneWay1_5.oneWay("aabbcc","axbbc")+": false");
        System.out.println("aabbc -> aabb :" + OneWay1_5.oneWay("aabbc","aabb")+": true");
        System.out.println("aabbcc -> aabbccd :" + OneWay1_5.oneWay("aabbcc","aabbccd")+": true");
        System.out.println("aabbcc -> aabbcxcd:" + OneWay1_5.oneWay("aabbcc","aabbcxcd")+": false");
        System.out.println("aabbcc -> aabbccc :" + OneWay1_5.oneWay("aabbcc","aabbccc")+": true");
    }
}
