public class Main
{
    public static void main(String[] args) 
    {

        Node root = new Node(1);
        BinaryTree tree = new BinaryTree(root);

        // Example usage
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);


        root.setLeftChild(node2);
        root.setRightChild(node3);
        node2.setLeftChild(node4);
        node2.setRightChild(node5);
        node3.setLeftChild(node6);
        node3.setRightChild(node7);

        tree.inorderTraversal(root);
    }
}

    //        1
    //   2          3
    // 4   5      6   7
