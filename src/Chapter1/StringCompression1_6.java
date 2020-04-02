package Chapter1;

public class StringCompression1_6 {

    public static String compressString(String string){
        char actualChar = string.charAt(0);
        int counter = 0;
        int counterOnlyOnes=0;
        String result = "";

        for(char ch:string.toCharArray()){
            if(actualChar == ch){
                counter++;
            }else{
                result += actualChar + String.valueOf(counter);
                actualChar = ch;
                if(counter==1){
                    counterOnlyOnes++;
                }
                counter=1;
            }
        }

        if(counter==1)
            counterOnlyOnes++;

        result += actualChar + String.valueOf(counter);

        if (counterOnlyOnes == string.length())
            return string;

        return result;
    }

    public static void main(String args[]){
        System.out.println(StringCompression1_6.compressString("aabcccccaaa") +"->"+"a2b1c5a3");
        System.out.println(StringCompression1_6.compressString("abcd") +"->"+"abcd");
    }
}
