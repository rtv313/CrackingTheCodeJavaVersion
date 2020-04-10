package Chapter4;

import java.util.Collections;
import java.util.HashSet;

public class IsBst4_5 {

    public static void collectNodes(Node rootNode, HashSet<Integer> nodesSet){

        if(rootNode == null)
            return;

        nodesSet.add(rootNode.data);
        collectNodes(rootNode.leftSon,nodesSet);
        collectNodes(rootNode.rightSon,nodesSet);
    }

    public static int getMin(Node rootNode){
        HashSet<Integer> nodesSet = new HashSet<Integer>();
        collectNodes(rootNode,nodesSet);
        return Collections.min(nodesSet);
    }

    public static int getMax(Node rootNode){
        HashSet<Integer> nodesSet = new HashSet<Integer>();
        collectNodes(rootNode,nodesSet);
        return Collections.max(nodesSet);
    }

    public static boolean checkBst(Node rootNode){

        if(rootNode.leftSon == null && rootNode.rightSon == null)
            return true;

        if(rootNode.leftSon == null && rootNode.rightSon != null && rootNode.data <= getMin(rootNode.rightSon))
            return true && checkBst(rootNode.rightSon);

        if(rootNode.leftSon != null && rootNode.rightSon == null && rootNode.data >= getMax(rootNode.leftSon))
            return true && checkBst(rootNode.leftSon);

        int maxValueLeft = getMax(rootNode.leftSon);
        int minValueRight = getMin(rootNode.rightSon);

        if(maxValueLeft <= rootNode.data && rootNode.data <= minValueRight)
            return true && checkBst(rootNode.leftSon) && checkBst(rootNode.rightSon);

        return false;
    }

    public static void main(String args[]){

        int[] sortedArray = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
        Node rootNode = MinimalTree4_2.createMinimalTree(sortedArray,0,sortedArray.length-1);

        int[] sortedArray2 = new int[]{0, 1, 8, 3, 4, 5, 6, 7};
        Node rootNode2 = MinimalTree4_2.createMinimalTree(sortedArray2,0,sortedArray2.length-1);

        System.out.println(checkBst(rootNode));
        System.out.println(checkBst(rootNode2));

    }
}
