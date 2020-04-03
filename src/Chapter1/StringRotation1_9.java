package Chapter1;

public class StringRotation1_9 {

    public static boolean isRotation(String stringOne,String stringTwo){

        String uniteStringTwo = stringTwo + stringTwo;
        boolean result = uniteStringTwo.contains(stringOne);
        return result;
    }

    public static void main (String args[]){
        System.out.println(isRotation("waterbottle","erbottlewat"));
    }
}
