import java.util.LinkedList;//will add my own classes later for these
import java.util.Queue;
import java.util.Stack;


public class BinaryTree
{
    Node root;

    public BinaryTree(Node root)
    {
        this.root = root;
    }

    public Node leftChild(Node toGet)
    {
        return toGet.getLeftChild();
    }

    public Node rightChild(Node toGet)
    {
        return toGet.getRightChild();
    }

    


///////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////


    public void breadthFirstSearchUsingLoop() 
    {
        if (this.root != null) 
        {
            Queue<Node> queue = new LinkedList<>();
            Node node = this.root;
            queue.add(node); //enqueue

            while (!queue.isEmpty()) 
            {
                node = queue.poll(); //dequeue
                System.out.print(node.data + " ");

                if (node.getLeftChild() != null) 
                {
                    queue.add(node.getLeftChild());
                }

                if (node.getRightChild() != null) 
                {
                    queue.add(node.getRightChild());
                }
            }
        }
    }


///////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////


    public void recursiveBFS() 
    {
        Queue<Node> queue = new LinkedList<>();
        recursiveBFSFunction(this.root, queue);
    }


    private static void recursiveBFSFunction(Node node, Queue<Node> queue) 
    {
        if (node != null) 
        {
            System.out.print(node.data + " ");

            if (node.hasLeft()) 
            {
                queue.add(node.getLeftChild());
            }

            if (node.hasRight()) 
            {
                queue.add(node.getRightChild());
            }

            if (!queue.isEmpty()) 
            {
                recursiveBFSFunction(queue.poll(), queue);
            }
        }
    }



///////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////

    public void iterativeDFS() 
    {
        if (this.root != null) 
        {
            Stack<Node> stack = new Stack<>();
            Node node = this.root;

            stack.push(this.root);

            while (!stack.isEmpty()) 
            {
                System.out.print( stack.pop().data + " ");

                if (node.hasLeft()) 
                {
                    stack.push(node.getLeftChild());
                }

                if (node.hasRight()) 
                {
                    stack.push(node.getRightChild());
                }
            }
        }
    }
}