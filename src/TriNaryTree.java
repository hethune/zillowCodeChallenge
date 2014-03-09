/**
 *  Implement insert and delete in a tri-nary tree.
 *  A tri-nary tree is much like a binary tree but with three child nodes
 *  for each parent instead of two -- with the left node being values less than the parent,
 *  the right node values greater than the parent, and the middle nodes values equal to the parent.
 * Created by wenhang on 3/8/14.
 */
public class TriNaryTree {
    public static boolean insert(Node head, int val) {
        boolean result = false;
        if (head == null) { return result; }

        // case 1 val == current node
        if (val == head.val) {
            if (head.middle == null) {
                head.middle = new Node(val);
                result = true;
            } else {
                result = insert(head.middle, val);
            }
        }

        // case 2 val < current node
        if (val < head.val) {
            if (head.left == null) {
                head.left = new Node(val);
                result = true;
            } else {
                result = insert(head.left, val);
            }
        }

        // case 2 val > current node
        if (val > head.val) {
            if (head.right == null) {
                head.right = new Node(val);
                result = true;
            } else {
                result = insert(head.right, val);
            }
        }

        return result;
    }

    public static Node delete(Node head, int val) {
        if (head == null) { return null; }

        // case1 val == head.val
        if (head.val == val) {
            if (head.middle != null) {
                Node tmp = head;
                head = tmp.middle;
                head.left = tmp.left;
                head.right = tmp.right;
            } else {
                if (head.left == null) { head = head.right; return head; }
                Node prev = head;
                Node curr = head.left;
                Node next = head.left.right;
                while (next != null) {
                    prev = curr;
                    curr = next;
                    next = next.right;
                }
                // Need to move curr to root curr cannot have any right child
                if (prev != head) {
                    prev.right = curr.left;
                } else {
                    prev.left = curr.left;
                }
                curr.left = head.left;
                curr.right = head.right;
                head = curr;
            }
        }

        if (val < head.val) {
            head.left = delete(head.left, val);
        }

        if (val > head.val) {
            head.right = delete(head.right, val);
        }

        return head;
    }
}
