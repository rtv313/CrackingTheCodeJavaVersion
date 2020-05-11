package Chapter1;

import java.util.Hashtable;

public class IsUnique1_1 {

    public static boolean all_chars_unique(String string){

        Hashtable<String,Integer> charsCount = new Hashtable<String, Integer>();

        for (char ch: string.toCharArray()){
            String key = "" + ch;
            if (charsCount.get(key)==null) {
                charsCount.put(key, 1);
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]){

        boolean unique = IsUnique1_1.all_chars_unique("abc");
        System.out.println("abc:" + unique);
        unique = IsUnique1_1.all_chars_unique("abccc");
        System.out.println("abccc:" + unique);
    }
}
