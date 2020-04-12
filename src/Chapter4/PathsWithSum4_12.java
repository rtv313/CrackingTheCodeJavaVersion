package Chapter4;

import java.util.LinkedList;

import static Chapter4.FindSuccesor4_6.createTreeWithParent;

public class PathsWithSum4_12 {

    public static void pathsWithSum(NodeWP rootNode, int target,LinkedList<Integer> listPrevious,LinkedList<LinkedList<Integer>> listResults){
        if(rootNode == null)
            return;

        LinkedList<Integer>  listPath = new LinkedList<Integer>(listPrevious);
        listPath.add(rootNode.data);

        int sumResult = 0;
        for(Integer element : listPath)
            sumResult+= element;

        if(sumResult == target) {
            listResults.add(listPath);
            return;
        }

        pathsWithSum(rootNode.leftSon,target,listPath,listResults);
        pathsWithSum(rootNode.rightSon,target,listPath,listResults);
    }

    public static void callPathsWithSum(NodeWP root,int target){
        LinkedList<Integer> listPrevious = new <Integer> LinkedList();
        LinkedList<LinkedList<Integer>> listResults = new <LinkedList<Integer>> LinkedList();
        pathsWithSum(root,target,listPrevious,listResults);
        System.out.println(listResults);
    }

    public static void main(String args[]){
        int[] listNodesT1 = new int[]{ 1, 2, 3, 4, 5, 6, 7};
        NodeWP rootTreeOne = createTreeWithParent(listNodesT1,0,listNodesT1.length-1,null);
        callPathsWithSum(rootTreeOne,6);
    }
}
