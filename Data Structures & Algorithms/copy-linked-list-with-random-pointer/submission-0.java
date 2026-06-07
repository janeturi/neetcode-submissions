/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // given a head of a linked list w length n
        // each node contains an additional pointer, random, or null
        // we want to create a copy of this but:
        // it needs the original value, val, of copied node
        // a next pointer
        // and a random pointer, pointing to the random val 
        // of the orgiinal node

        // idea is to have a and a', where a originally points to b and 
        // its random pointer points to c, but now, we still have a -> b
        // but a' pointing to c', the copy of c that also has a random pointer
        // since we want the original to point to the random pointer still,
        // we can write it as 

        // a -> a' -> b -> b' -> c -> c' 
        if (head == null){
            return null;
        }

        Node orig = head;
        while (orig != null){
            Node copy = new Node (orig.val);
            // copy of node 
            copy.next = orig.next;
            // copies next is the original pointer
            orig.next = copy;
            // now original points to the copy so that it has the random pointer
            orig = copy.next;
            // now we advance to next node
        }

        Node newHead = head.next;
        // the new head points to the copy of the first node now

        orig = head;// start at beginning 
        while (orig != null){
            if (orig.random != null){
                // if orig.random exists
                orig.next.random = orig.random.next;
                // assign the copy's pointer to a random node
            }
            orig = orig.next.next;
            // now advance
        }

        orig = head; 
        // start at beginning
        while(orig != null){
            Node copy = orig.next;
            orig.next = copy.next;
            // orig points to copy's pointr, the next og node
            if(copy.next != null){
                copy.next = copy.next.next;
                // copy's pointer points to the next copied
                // so now the two lists are seperate
            }
            orig = orig.next;// mvoe forward
        }
        return newHead;
    }
}
