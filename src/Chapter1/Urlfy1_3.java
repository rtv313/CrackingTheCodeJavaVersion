package Chapter1;

public class Urlfy1_3 {

    public static String easy_urlfy(String string){
        string = string.replace(" ","%20");
        return string;
    }

    public static String urlfy(String string){

        char[] stringArray =  string.toCharArray();
        int lastCharPosition = 0;

        // Find last not empty space position
        for(int i = 0; i < stringArray.length;i++){
            if(stringArray[i]!=' ')
                lastCharPosition = i;
        }

        // Replace values in array
        for(int i = 0; i < lastCharPosition; i++){

            if(stringArray[i]==' '){

                for (int x = lastCharPosition + 2; x > i; x--){
                    stringArray[x] = stringArray[x-2];
                }

                stringArray[i] = '%';
                stringArray[i+1] = '2';
                stringArray[i+2] = '0';
                lastCharPosition+= 2;
            }
        }

        String urlfy = new String(stringArray);
        return  urlfy;
    }

    public static void main(String args[]){
        System.out.println(Urlfy1_3.easy_urlfy("Mr John Smith"));
        System.out.println(Urlfy1_3.urlfy("Mr John Smith          "));
    }
}
