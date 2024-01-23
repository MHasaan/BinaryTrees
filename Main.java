public class Main
{
    public static void main(String[] args) 
    {

        BST tree = new BST();

        tree.insertNode(5);
        tree.insertNode(3);
        tree.insertNode(7);
        tree.insertNode(2);
        tree.insertNode(4);
        tree.insertNode(6);
        tree.insertNode(8);
        tree.insertNode(10);
        

        // tree.inorderTraversal(tree.root);

        tree.BFSrecursive();System.out.println();
        tree.deleteNode(5);
        tree.BFSrecursive();System.out.println();
        tree.deleteNode(3);
        tree.BFSrecursive(); System.out.println();
        tree.deleteNode(7);
        tree.BFSrecursive();System.out.println();
        tree.deleteNode(2);
        tree.BFSrecursive();System.out.println();
        tree.deleteNode(6);
        tree.BFSrecursive();System.out.println();
        tree.deleteNode(4);
        tree.BFSrecursive(); System.out.println();
        tree.deleteNode(8);
        tree.BFSrecursive(); System.out.println();
        tree.deleteNode(10);
        
        System.out.println("after deletion:");
        tree.BFSrecursive(); System.out.println();
        // TNode returned = tree.search(4);
        // returned = tree.findParent(tree.root , returned);

        // System.out.println(tree.findDepth(tree.root, tree.search(10) , 0 ));
        // System.out.println(tree.findTreeDepth(tree.root)); //not working

        // System.out.println("\n" + returned.data);
    }
}   //    the tree
    //        5
    //   3          7
    // 2   4      6   8
