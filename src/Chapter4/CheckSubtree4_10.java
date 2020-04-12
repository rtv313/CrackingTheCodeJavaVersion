package Chapter4;


import java.util.LinkedList;

import static Chapter4.FindSuccesor4_6.createTreeWithParent;

public class CheckSubtree4_10 {

    public static void preOrderTraversal(LinkedList<String> list, NodeWP root){
        if(!(root == null)){
            list.add(String.valueOf(root.data));
            preOrderTraversal(list,root.leftSon);
            preOrderTraversal(list,root.rightSon);
        }else{
            list.add("x");
        }
    }

    public static boolean checkIsSubTree(NodeWP rootOne,NodeWP rootTwo){
        LinkedList<String> treeOnePreorder = new <String> LinkedList();
        preOrderTraversal(treeOnePreorder,rootOne);
        LinkedList<String> treeTwoPreorder = new <String> LinkedList();
        preOrderTraversal(treeTwoPreorder,rootTwo);

        String treeOne = "";
        String treeTwo = "";

        for(String s : treeOnePreorder)
            treeOne+=s;

        for(String s : treeTwoPreorder)
            treeTwo+=s;

        if(treeOne.contains(treeTwo)){
            return true;
        }
        return false;
    }

    public static void main(String args[]){
        // Is Subtree
        int[] listNodesT1 = new int[]{ 1, 2, 3, 4, 5, 6, 7};
        NodeWP rootTreeOne = createTreeWithParent(listNodesT1,0,listNodesT1.length-1,null);
        int[] listNodesT2 = new int[]{5, 6, 7};
        NodeWP rootTreeTwo = createTreeWithParent(listNodesT2,0,listNodesT2.length-1,null);
        System.out.println(checkIsSubTree(rootTreeOne,rootTreeTwo));

        // Not Subtree
        listNodesT1 = new int[]{ 1, 2, 3, 4, 5, 6, 7};
        rootTreeOne = createTreeWithParent(listNodesT1,0,listNodesT1.length-1,null);
        listNodesT2 = new int[]{5, 6, 7, 8};
        rootTreeTwo = createTreeWithParent(listNodesT2,0,listNodesT2.length-1,null);
        System.out.println(checkIsSubTree(rootTreeOne,rootTreeTwo));

    }
}
