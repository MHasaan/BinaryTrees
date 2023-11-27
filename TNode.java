public class TNode
{
    int data;
    TNode leftChild;
    TNode rightChild;

    public TNode(int data)
    {
        this.data = data;
    }

    public void setLeftChild(TNode toSet)
    {
        this.leftChild = toSet;
    }
    
    public void setRightChild(TNode toSet)
    {
        this.rightChild = toSet;
    }

    public TNode getLeftChild()
    {
        return this.leftChild;
    }

    public TNode getRightChild()
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
