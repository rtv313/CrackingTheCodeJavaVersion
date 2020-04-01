package Chapter1;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation1_4 {

    public static boolean palindrome_permutation(String string){

        char[] stringArray =  string.toCharArray();
        Map<String,Integer> hashMap = new HashMap<String,Integer>();

        for(char ch : stringArray){
            String key = " " + ch;
            if (!hashMap.containsKey(key)){
                hashMap.put(key,1);
            }else{
                int counter  = hashMap.get(key) + 1;
                hashMap.put(key,counter);
            }
        }

        int count_impairs = 0;
        for (String key : hashMap.keySet()){

            if(hashMap.get(key)%2 != 0){
                count_impairs ++;
            }

            if (count_impairs > 1){
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]){
        System.out.println("aabaa:" + PalindromePermutation1_4.palindrome_permutation("aabaa"));
        System.out.println("aabbbaa:" + PalindromePermutation1_4.palindrome_permutation("aabbbaa"));
        System.out.println("aacbbcaa:" + PalindromePermutation1_4.palindrome_permutation("aacbbcaa"));
        System.out.println("aaaa:" + PalindromePermutation1_4.palindrome_permutation("aaaa"));
        System.out.println("aaaabbbz:" + PalindromePermutation1_4.palindrome_permutation("aaaabbbz"));
        System.out.println("aaaabbbcz:" + PalindromePermutation1_4.palindrome_permutation("aaaabbbcz"));
    }
}
