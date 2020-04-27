package Chapter4;
import Chapter2.Node;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import static Chapter4.FindSuccesor4_6.createTreeWithParent;


public class CommonAncestor4_8 {

    public static LinkedList<NodeWP> getAncestorsList(NodeWP node){
        LinkedList<NodeWP> listAncestors = new LinkedList<NodeWP>();
        NodeWP runner = node;

        while(runner != null){
            listAncestors.add(runner);
            runner = runner.parent;
        }
        return listAncestors;
    }

    public static NodeWP findCommonAncestor(NodeWP nodeOne,NodeWP nodeTwo){

        LinkedList<NodeWP> listAncestorsOne = getAncestorsList(nodeOne);
        LinkedList<NodeWP> listAncestorsTwo = getAncestorsList(nodeTwo);
        LinkedList<NodeWP> concatenateLists = new <NodeWP> LinkedList();
        concatenateLists.addAll(listAncestorsOne);
        concatenateLists.addAll(listAncestorsTwo);

        HashSet<NodeWP> set = new <NodeWP> HashSet();

        for(NodeWP node : concatenateLists){

            if(set.contains(node)){
                return node;
            }else{
                set.add(node);
            }
        }
        return null;
    }

    public static void main(String args[]){
        int[] sortedArray = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
        NodeWP rootNode = createTreeWithParent(sortedArray,0,sortedArray.length-1,null);
        NodeWP nodeOne = rootNode.leftSon.leftSon;
        NodeWP nodeTwo = rootNode.rightSon.rightSon;
        NodeWP commonAncestor = findCommonAncestor(nodeOne,nodeTwo);
        System.out.println(commonAncestor.data);
    }
}
