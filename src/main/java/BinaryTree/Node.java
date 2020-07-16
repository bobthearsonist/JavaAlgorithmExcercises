package BinaryTree;

public class Node {
    int val;
    Node left;
    Node right;
    public Node(int val) { this.val = val; }
    public Node(Node node) { var copy = new Node(node.val); copy.left = node.left; copy.right = node.right; }
    public Node(int val, Node left, Node right) {
          this.val = val;
          this.left = left;
          this.right = right;
     }
}
