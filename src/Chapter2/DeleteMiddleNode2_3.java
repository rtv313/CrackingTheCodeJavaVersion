package Chapter2;

public class DeleteMiddleNode2_3 {

    public static boolean removeMiddleNode(Node nodeToRemove){

        if (nodeToRemove == null || nodeToRemove.next ==null)
            return false;

        nodeToRemove.data = nodeToRemove.next.data;
        nodeToRemove.next = nodeToRemove.next.next;
        return true;
    }

    public static void main(String args[]){
        LinkedList list = new LinkedList();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        Node nodeToRemove = list.addNode(4);
        list.addNode(5);
        list.addNode(6);
        list.displayList();
        System.out.println("###############");
        removeMiddleNode(nodeToRemove);
        list.displayList();
    }
}
