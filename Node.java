public class Node
{
    int data;
    Node leftChild;
    Node rightChild;

    public Node(int data)
    {
        this.data = data;
    }

    public void setLeftChild(Node toSet)
    {
        this.leftChild = toSet;
    }
    
    public void setRightChild(Node toSet)
    {
        this.rightChild = toSet;
    }

    public Node getLeftChild()
    {
        return this.leftChild;
    }

    public Node getRightChild()
    {
        return this.rightChild;
    }



    public boolean hasLeft()
    {
        return this.getLeftChild() != null;
    }
    
    public boolean hasRight()
    {
        return this.getRightChild() != null;
    }

    
}
