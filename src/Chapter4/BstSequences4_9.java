package Chapter4;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

import static Chapter4.PrintDepths4_3.createDepthLists;

public class BstSequences4_9 {

    public static void createListDepths(LinkedList<LinkedList<Integer>> listDepths,Node rootNode,int depth){
        if(rootNode == null)
            return;

        if(listDepths.size() == depth)
            listDepths.add(new <Integer> LinkedList());

        if(listDepths.size() == 0){
            listDepths.add(new <Integer> LinkedList());
            listDepths.get(depth).add(rootNode.data);
        }else{
            listDepths.get(depth).add(rootNode.data);
        }

        createListDepths(listDepths,rootNode.leftSon,depth + 1);
        createListDepths(listDepths,rootNode.rightSon,depth + 1);
    }

    private static void swap(LinkedList<Integer> list, int i, int j)
    {
        int temp = list.get(i);
        list.set(i,list.get(j));
        list.set(j,temp);
    }

    private static void permutations(LinkedList<Integer> list, int currentIndex,LinkedList<LinkedList<Integer>> permutations)
    {
        if (currentIndex == list.size() - 1) {
            LinkedList<Integer> listCopy = new LinkedList<Integer>(list);
            permutations.add(listCopy);
        }

        for (int i = currentIndex; i < list.size(); i++)
        {
            swap(list, currentIndex, i);
            permutations(list, currentIndex + 1,permutations);
            swap(list, currentIndex, i);
        }
    }

    public static  LinkedList<LinkedList<Integer>> allCombinations(LinkedList<LinkedList<Integer>> listDepths,int levelIndex){

        if(levelIndex > listDepths.size() - 1)
            return null;

        LinkedList<LinkedList<Integer>> levelCombinations = new <LinkedList<Integer>> LinkedList();
        permutations(listDepths.get(levelIndex),0,levelCombinations);
        LinkedList<LinkedList<Integer>> result = new <LinkedList<Integer>> LinkedList();
        LinkedList<LinkedList<Integer>> nextLevelCombinations = allCombinations(listDepths,levelIndex + 1);

        for(LinkedList<Integer> level : levelCombinations){
            if(nextLevelCombinations == null){
                result.add(level);
            }else{
                for(LinkedList<Integer> nextLevel : nextLevelCombinations){
                    LinkedList<Integer> levelCopy = new <Integer> LinkedList(level);
                    levelCopy.addAll(nextLevel);
                    result.add(levelCopy);
                }
            }
        }
        return result;
    }

    public static void main(String args[]){

        int[] sortedArray = new int[]{0, 1, 2, 3, 4, 5, 6};
        Node rootNode = MinimalTree4_2.createMinimalTree(sortedArray,0,sortedArray.length-1);
        LinkedList<LinkedList<Integer>>depthLists = new <LinkedList<Integer>> LinkedList();
        createListDepths(depthLists,rootNode,0);
        LinkedList<LinkedList<Integer>> results = allCombinations(depthLists,0);

        for(LinkedList<Integer> result : results)
            System.out.println(result);
    }
}
