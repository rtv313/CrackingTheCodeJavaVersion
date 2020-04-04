package Chapter2;

import java.util.Collections;

public class IsPalindrome2_6 {

    public static boolean isPalindrome(LinkedList list){

        Node runner = list.head;
        String possiblePalindrome = "";

        while(runner != null){
            possiblePalindrome+= String.valueOf(runner.data);
            runner = runner.next;
        }

        String reversed =  new StringBuilder(possiblePalindrome).reverse().toString();

        if(possiblePalindrome.equals(reversed))
            return true;

        return false;
    }
    public static void main(String args[]){
        LinkedList palindrome = new LinkedList();
        palindrome.addNode(2);
        palindrome.addNode(2);
        palindrome.addNode(1);
        palindrome.addNode(2);
        palindrome.addNode(2);
        System.out.println(isPalindrome(palindrome));

        palindrome = new LinkedList();
        palindrome.addNode(2);
        palindrome.addNode(2);
        palindrome.addNode(1);
        palindrome.addNode(3);
        palindrome.addNode(2);
        System.out.println(isPalindrome(palindrome));
    }
}
