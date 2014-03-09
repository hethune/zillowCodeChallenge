import org.junit.Test;

import static org.junit.Assert.*;


/**
 *  Created by wenhang on 3/8/14.
 */
public class TriNaryTreeTest {
    @Test
    public void testAdd() throws Exception {
        Node head = new Node(5);
        head.left = new Node(4);
        head.left.left = new Node(2);
        head.right = new Node(9);

        assertTrue(TriNaryTree.insert(head, 2));
        assertTrue(TriNaryTree.insert(head, 5));
        assertTrue(TriNaryTree.insert(head, 7));
    }

    @Test
    public void testDelete() throws Exception {
        Node head = constructTree();

        //delete Middle
        Node expected = head.middle;
        head = TriNaryTree.delete(head, 6);
        assertEquals(head, expected);

        //delete empty middle
        expected = head.left.right;
        head = TriNaryTree.delete(head, 6);
        assertEquals(head, expected);

        head = constructTree();

        //delete from left
        expected = head.left.left;
        head = TriNaryTree.delete(head, 4);
        assertEquals(head.left, expected);

        //delete from right
        expected = head.right.left;
        head = TriNaryTree.delete(head, 9);
        assertEquals(head.right, expected);

        //delete leaf
        head = TriNaryTree.delete(head, 7);
        assertNull(head.right);

        //delete unexisted val
        try {
            TriNaryTree.delete(head, 100);
        } catch (Exception e) {
            fail("Error in deleting unexsited value");
        }

    }

    private static Node constructTree() {
        Node head = new Node(6);
        head.middle = new Node(6);
        head.left = new Node(4);
        head.left.left = new Node(2);
        head.left.left.left = new Node(2);
        head.left.right = new Node(5);
        head.right = new Node(9);
        head.right.left = new Node(7);
        return head;
    }


}
