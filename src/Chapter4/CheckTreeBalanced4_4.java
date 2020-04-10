package Chapter4;

public class CheckTreeBalanced4_4 {

    private static int getHeight(Node rootNode,int depth) {
        if (rootNode == null)
            return depth;

        int leftHeight = getHeight(rootNode.leftSon, depth + 1);
        int rightHeight = getHeight(rootNode.rightSon, depth + 1);
        return Math.max(leftHeight, rightHeight);
    }

    public static boolean treeBalanced(Node rootNode){

        if(rootNode == null)
            return true;

        int resultHeight = Math.abs(getHeight(rootNode.leftSon,0)-getHeight(rootNode.rightSon,0));

        if(resultHeight > 1)
            return false;

        return (treeBalanced(rootNode.leftSon) == true && treeBalanced(rootNode.rightSon) == true);
    }

    public static void main(String args[]){
        int[] sortedArray = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
        Node rootNodeBalanced = MinimalTree4_2.createMinimalTree(sortedArray,0,sortedArray.length-1);

        Node rootNodeUnBalanced = new Node(2);
        Node leftRootSon = rootNodeUnBalanced.leftSon = new Node(0);
        Node rightRootSon = rootNodeUnBalanced.leftSon = new Node(1);
        rightRootSon.leftSon = new Node(0);
        rightRootSon.rightSon = new Node(1).rightSon = new Node(0);

        System.out.println(treeBalanced(rootNodeBalanced));
        System.out.println(treeBalanced(rootNodeUnBalanced));
    }
}
