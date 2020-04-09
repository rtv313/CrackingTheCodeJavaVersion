package Chapter4;

import java.util.HashMap;
import java.util.LinkedList;

public class PrintDepths4_3 {

    public static void createDepthLists(Node rootNode, HashMap<Integer, LinkedList<Integer>> depthMap,int depth){

        if(rootNode == null){
            return;
        }

        if(depthMap.containsKey(depth)){
            depthMap.get(depth).add(rootNode.data);
        }else{
            LinkedList<Integer> newDepthList = new LinkedList<Integer>();
            newDepthList.add(rootNode.data);
            depthMap.put(depth,newDepthList);
        }

        createDepthLists(rootNode.leftSon,depthMap,depth + 1);
        createDepthLists(rootNode.rightSon,depthMap,depth + 1);
    }

    public static void printDepths(HashMap<Integer, LinkedList<Integer>> depthMap){
        for(Integer key : depthMap.keySet()){
            String depth = "";
            for(Integer element : depthMap.get(key)){
                depth+= Integer.toString(element) + ",";
            }
            System.out.println(depth);
        }
    }

    public static void main(String args[]){
        int[] sortedArray = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
        Node rootNode = MinimalTree4_2.createMinimalTree(sortedArray,0,sortedArray.length-1);
        HashMap<Integer, LinkedList<Integer>> depthMap = new HashMap<Integer,LinkedList<Integer>>();
        createDepthLists(rootNode,depthMap,0);
        printDepths(depthMap);
    }
}
