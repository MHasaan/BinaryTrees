import java.util.LinkedList;//Used in BFS functions
import java.util.Queue;//Used in BFS functions
import java.util.Stack;//Used in DFS function


//add my own classes later
//THIS TREE WORKS WITHOUT REPEATING VALUES eg REPEATING VALUES WILL NOT BE INSERTED AND IGNORED

public class BST
{
    TNode root;

    public BST()
    {
        this.root = null;
    }

    public BST(int data)
    {
        this.insertNode(data);
    }

    public BST(TNode root)
    {
        this.root = root;
    }

///////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////

    public void insertNode(int data)
    {
        TNode newNode = new TNode(data);
        if (root == null) 
        {
            root = newNode;
        }
        else
        {
            recursiveInsertNode(this.root, newNode);
        }
    }
    
    
    private void recursiveInsertNode(TNode rootNode, TNode node)
    {
        // if ( rootNode.data == node.data )
        // {
            
        // }
        if (node.data < rootNode.data)
        {   if(rootNode.getLeftChild() == null)
            {
                rootNode.setLeftChild(node);
            }
            else
            {
                recursiveInsertNode(rootNode.getLeftChild(), node);
            }
        } 
        else if (node.data > rootNode.data) 
        {
            if (rootNode.getRightChild() == null) 
            {
                rootNode.setRightChild(node);
            }
            else
            {
                recursiveInsertNode(rootNode.getRightChild() , node);
            }
        }
    }

///////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////


    public void deleteNode(int data) 
    {
        deleteNode(root, data);
    }

    private TNode deleteNode(TNode rootNode, int dataToDelete) 
    {
        if (rootNode == null) 
        {
            return rootNode;
        }
        else if (dataToDelete < rootNode.data) 
        {
            rootNode.leftChild = deleteNode(rootNode.getLeftChild(), dataToDelete);
        } 
        else if (dataToDelete > rootNode.data) 
        { 
            rootNode.rightChild = deleteNode(rootNode.getRightChild(), dataToDelete);
        }
        else
        {
            //The following two if statements cover conditions:
            //1) no children(if both null then null will be assigned to the Node ToDel)
            //2) one child (either left or right) replacing the Node ToDel
            if (rootNode.getLeftChild() == null) 
            {
                return rootNode.getRightChild();
            } 
            else if (rootNode.getRightChild() == null) 
            {
                return rootNode.getLeftChild();
            }
            else //This part covers for two children of Node ToDel 
            {
                rootNode.data = SucessorInOrder(rootNode.getRightChild());
                rootNode.setRightChild( deleteNode(rootNode.getRightChild(), rootNode.data) );
            }
        }
                return rootNode;
    }

    private int SucessorInOrder(TNode node) 
    {
        while (node.getLeftChild() != null) 
        {
            node = node.getLeftChild();
        }
        return node.data;
    }

///////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////

    public TNode search(int data)
    {
        return BSTSearch(root, data);
    }


    public TNode BSTSearch(TNode root, int data)
    {
        if (root == null || root.data == data)
        {
            return root;
        }
        else if (data < root.data)
        {
            return BSTSearch(root.getLeftChild(), data);
        }
        else
        {
            return BSTSearch(root.getRightChild(), data);
        }
    }

///////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////


    public void BFSUsingLoop() 
    {
        if (this.root != null) 
        {
            Queue<TNode> queue = new LinkedList<>();
            TNode node = this.root;
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



    public void BFSrecursive() 
    {
        Queue<TNode> queue = new LinkedList<>();
        recursiveBFSFunction(this.root, queue);
    }


    private static void recursiveBFSFunction(TNode node, Queue<TNode> queue) 
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

    public void DFSiterative() 
    {
        if (this.root != null) 
        {
            Stack<TNode> stack = new Stack<>();
            TNode node = this.root;

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


///////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////


    // Method to perform pre-order traversal of the binary tree
    public void preorderTraversal(TNode root) 
    {
        if (root != null) 
        {
            // Visit the current node
            System.out.print(root.data + " ");

            // Recursively traverse the left subtree
            preorderTraversal(root.getLeftChild());

            // Recursively traverse the right subtree
            preorderTraversal(root.getRightChild());
        }
    }

    public void postorderTraversal(TNode root) 
    {
        if (root != null) 
        {
            // Recursively traverse the left subtree
            postorderTraversal(root.getLeftChild());

            // Recursively traverse the right subtree
            postorderTraversal(root.getRightChild());

            // Visit the current node
            System.out.print(root.data + " ");
        }
    }

    public void inorderTraversal(TNode root) 
    {
        if (root != null) 
        {
            // Recursively traverse the left subtree
            inorderTraversal(root.getLeftChild());

            // Visit the current node
            System.out.print(root.data + " ");

            // Recursively traverse the right subtree
            inorderTraversal(root.getRightChild());
        }
    }


///////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
////////ASSIGNMENT QUESTIONS BELOW
///////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////


    public TNode findParent(TNode parentNode, TNode target)
    {
        if (parentNode == null || target == null || parentNode == target ) 
        {
            return null; // No parent found or target node is root
        }
        else if (( parentNode.getLeftChild() == target) || (parentNode.getRightChild() == target)) 
        {
            return parentNode;
        }
        else if( target.data < parentNode.data)
        {
            return findParent(parentNode.getLeftChild(), target);
        }
        else
        {
            return findParent(parentNode.getRightChild(), target);
        }
        // no need for any else above becase each condition has return
        // return left != null ? left : right; 
    }



    public int findDepth(TNode node, TNode target, int depth) 
    {

        if (node == target) 
        {
            return depth;
        }
        else if(target.data < node.data)
        {
            return findDepth(node.getLeftChild(), target, depth + 1);
        }
        else if(target.data > node.data)
        {
            return findDepth(node.getRightChild(), target, depth + 1);
        }
        else 
        {
            return -1; // Node not found
        }
    }
    


    public int findTreeDepth(TNode node) //not working properly
    {
        if (node == null) 
        {
            return 0;
        }

        int leftDepth = findTreeDepth(node.getLeftChild());
        int rightDepth = findTreeDepth(node.getRightChild());

        return 1 + (leftDepth >= rightDepth? leftDepth : rightDepth); //equal because if both equal then return that value
        // return 1 + Math.max(leftDepth,rightDepth);
    }


    public boolean isFullTree(TNode node)//meaning either full or zero children
    {
        if (node == null) //for root node if = null
        {
            return true;
        }
        else if (node.getLeftChild() == null && node.getRightChild() == null) 
        {
            return true;
        }
        else if (node.getLeftChild() != null && node.getRightChild() != null) 
        {
            return isFullTree(node.getLeftChild()) && isFullTree(node.getRightChild());
        }
        else
            return false;
    }


    public boolean areNodesAtSameLevel(TNode parentNode, TNode firstNode, TNode secondNode) 
    {
        int depthA = findDepth(parentNode, firstNode, 0);
        int depthB = findDepth(parentNode, secondNode, 0);

        if (depthA != -1 && depthB != -1 && depthA == depthB)
        {
            return true;
        }
        else
            return false;
    }


    public int countNodes(TNode node) 
    {
        if (node == null) 
        {
            return 0;
        }

        return 1 + (countNodes(node.getLeftChild()) + countNodes(node.getRightChild()));
    }


    public boolean areEqual(TNode node1, TNode node2) 
    {
        if (node1 == null && node2 == null) 
        {
            return true;
        }

        if (node1 == null || node2 == null) 
        {
            return false;
        }

        return node1.data == node2.data && areEqual(node1.getLeftChild(), node2.getLeftChild()) && areEqual(node1.getRightChild(), node2.getRightChild());
    }


    public boolean areSameShape(TNode node1, TNode node2) //if shape of tree same. not considering data
    {
        if (node1 == null && node2 == null) 
        {
            return true;
        }
        else if (node1 == null || node2 == null) 
        {
            return false;
        }
        else if (areSameShape(node1.getLeftChild(), node2.getLeftChild()) && 
                 areSameShape(node1.getRightChild(), node2.getRightChild())) 
        {
            return true;
        }
        else
            return false;
    }
}
