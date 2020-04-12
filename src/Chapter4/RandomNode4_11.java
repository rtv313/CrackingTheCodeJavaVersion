package Chapter4;
import java.util.Random;
import java.util.LinkedList;

import static Chapter4.FindSuccesor4_6.createTreeWithParent;

public class RandomNode4_11 {

    public static void preOrderTraversal(LinkedList<NodeWP> list, NodeWP root){
        if(!(root == null)){
            list.add(root);
            preOrderTraversal(list,root.leftSon);
            preOrderTraversal(list,root.rightSon);
        }
    }

    public static NodeWP getRandom(NodeWP root){
        LinkedList<NodeWP> list = new <NodeWP>LinkedList();
        preOrderTraversal(list,root);
        int length = list.size()-1;
        Random RANDOM = new Random();
        int selectedValue = RANDOM.nextInt(length) + 0;
        return list.get(selectedValue);
    }

    public static void main(String args[]){
        int[] listNodesT1 = new int[]{ 1, 2, 3, 4, 5, 6, 7};
        NodeWP rootTreeOne = createTreeWithParent(listNodesT1,0,listNodesT1.length-1,null);
        System.out.println(getRandom(rootTreeOne).data);
        System.out.println(getRandom(rootTreeOne).data);
        System.out.println(getRandom(rootTreeOne).data);
        System.out.println(getRandom(rootTreeOne).data);
        System.out.println(getRandom(rootTreeOne).data);
        System.out.println(getRandom(rootTreeOne).data);
        System.out.println(getRandom(rootTreeOne).data);
        System.out.println(getRandom(rootTreeOne).data);
    }
}
