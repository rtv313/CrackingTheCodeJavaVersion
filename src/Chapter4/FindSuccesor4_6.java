package Chapter4;

class NodeWP{
    public int data;
    public NodeWP leftSon;
    public NodeWP rightSon;
    public NodeWP parent;

    public NodeWP(int data, NodeWP parent){
        this.data = data;
        this.leftSon = null;
        this.rightSon = null;
        this.parent = parent;
    }
}

public class FindSuccesor4_6 {
    public static NodeWP createTreeWithParent(int [] sortedArray,int minIndex,int maxIndex,NodeWP parent){

        if(maxIndex < minIndex)
            return null;

        int centerIndex = (minIndex + maxIndex)/2;
        int data = sortedArray[centerIndex];

        NodeWP newNode = new NodeWP(data,parent);
        newNode.leftSon = createTreeWithParent(sortedArray,minIndex,centerIndex - 1,newNode);
        newNode.rightSon = createTreeWithParent(sortedArray,centerIndex + 1,maxIndex,newNode);

        return  newNode;
    }

    public static NodeWP getMin(NodeWP node){

        NodeWP runner = node;

        while(runner != null){

            if(runner.leftSon == null && runner.rightSon == null)
                return runner;

            if(runner.leftSon != null){
                runner = runner.leftSon;
                continue;
            }

            if(runner.rightSon != null){
                runner = runner.rightSon;
                continue;
            }
        }
        return runner;
    }

    public static NodeWP findSuccesor(NodeWP node){

        if(node.rightSon != null){
            return getMin(node.rightSon);
        }

        NodeWP runner = node;

        while(runner.parent != null){
            if(runner == runner.parent.leftSon)
                return  runner.parent;
            else
                runner = runner.parent;
        }

        return  runner;
    }

    public static void main(String args[]){
        int[] sortedArray = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
        NodeWP rootNode = createTreeWithParent(sortedArray,0,sortedArray.length-1,null);

        System.out.println(rootNode.data);
        System.out.println(findSuccesor(rootNode).data);

        // Node 4, next 5
        NodeWP node = rootNode.rightSon.leftSon;
        System.out.println(findSuccesor(node).data);

        // Node 2, next 3
        node = rootNode.leftSon.rightSon;
        System.out.println(findSuccesor(node).data);

        // Node 7, next null(no succesor)
        node = rootNode.rightSon.rightSon.rightSon;

        if(findSuccesor(node).parent == null)
            System.out.println("No succesor");
    }
}
