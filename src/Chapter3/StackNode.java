package Chapter3;

public class StackNode {
    public int data;
    public StackNode next;
    public StackNode min;

    public StackNode(int data){
        this.data = data;
        this.next = null;
        this.min = null;
    }
}
