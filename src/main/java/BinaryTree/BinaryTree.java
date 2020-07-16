package BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class BinaryTree {

    public boolean leafSimilar(Node root1, Node root2) {
        var stack = new Stack<Node>();
        var leaf = new ArrayList<Node>();

        if (root1 == null && root2 == null) return true;
        if (root1 != null ^ root2 != null) return false;

        stack.push(root1);
        var prev = root1;

        while (!stack.empty()) {
            var current = stack.peek();
            System.out.println(Arrays.toString(new int[]{current.val, prev.val}));

            if (current.left == null && current.right == null) {
                stack.pop();
            } else if (current.left != null & current.left.val != prev.val) {
                stack.push(current.left);
            } else if (current.right != null & current.right.val != prev.val) {
                stack.push(current.right);
            }
            prev = current;
        }

        return false;
    }
}
