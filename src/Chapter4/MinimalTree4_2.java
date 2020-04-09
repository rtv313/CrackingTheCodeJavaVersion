package Chapter4;

class Node{
    public int data;
    public Node leftSon;
    public Node rightSon;

    public Node(int data){
        this.data = data;
        this.leftSon = null;
        this.rightSon = null;
    }
}

public class MinimalTree4_2 {

    public static Node createMinimalTree(int[] sortedArray,int minIndex,int maxIndex){

        if( minIndex > maxIndex){
            return null;
        }

        int middle = (minIndex + maxIndex) / 2;
        int data = sortedArray[middle];

        Node newNode = new Node(data);
        newNode.leftSon = createMinimalTree(sortedArray,minIndex,middle-1);
        newNode.rightSon = createMinimalTree(sortedArray,middle+1,maxIndex);
        return newNode;
    }


    public static void main(String args[]){
        int[] sortedArray = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
        Node rootNode = createMinimalTree(sortedArray,0,sortedArray.length-1);
    }
}
