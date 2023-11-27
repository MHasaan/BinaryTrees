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

        // tree.inorderTraversal(tree.root);

        tree.BFSrecursive();

        TNode returned = tree.search(4);
        returned = tree.findParent(tree.root , returned);

        System.out.println("\n" + returned.data);
    }
}
    //        5
    //   3          7
    // 2   4      6   8
