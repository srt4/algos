/**
 * 
 * @author srt4@uw.edu
 */
public class SinglyLinkedLists {

    static class ListNode {

        ListNode next;
        String value;

        /**
         * 
         * @param value The String value of the linked list node
         * @param next Pointer to the next value 
         */
        ListNode(String value, ListNode next) {
            this.value = value;
            this.next = next;
        }

        public static ListNode of(final String nodeValue) {
            return new ListNode(nodeValue, null);
        }

        public ListNode and(final String nextNodeValue) {
            ListNode cursor = this;
            while (cursor.next != null) {
                cursor = cursor.next;
            }
            cursor.next = ListNode.of(nextNodeValue);
            return this;
        }

        public ListNode and(final String ... nextNodeValues) {
            for (String nextNodeValue : nextNodeValues) {
                and(nextNodeValue);
            }

            return this;
        }

        public String toString() {
            return value + " -> " + next;
        }

    }

    public static void main(String[] args) {
        ListNode toInterleave = ListNode.of("A").and("B").and("C").and("D").and("E").and("F").and("G");
        ListNode validPalindrome = ListNode.of("A").and("M", "A", "M", "A");
        ListNode invalidPalindrome = ListNode.of("A").and("Z", "A", "M", "A");
        System.out.println("Interleaving " + toInterleave + ". Output=" + interleaveList(toInterleave));
        System.out.println("Testing invalid palindrome: " + invalidPalindrome + ", isPalindrome=" +
                isPalindrome(invalidPalindrome));
        System.out.println("Testing valid palindrome: " + validPalindrome + ", isPalindrome=" +
                isPalindrome(validPalindrome));
    }

    static ListNode left;
    static boolean isPalindrome(ListNode right) {
        if (left == null) { // base case: first call
            left = right;
        }
        if (right == null) { // base case: past the end
            return true;
        }

        boolean retVal = isPalindrome(right.next) && right.value.equals(left.value);

        left = left.next;
        return retVal;
    }

    /**
     * Take a singly-linked list, and reorder in such a way that the first element points to the last element, 
     * second element points to second-to-last element, and so on. 
     * 
     * @param head list such as [ A, B, C, D, E, F, G ]
     * @return interleaved list from reverse end, such as [ A, G, B, F, C, E, D ]
     */
    static ListNode interleaveList(ListNode head) {
        ListNode midpoint = head.next;
        ListNode cursor = head;
        ListNode previous = null;
        
        int position = 1;
        // Walk to the end of the linked list, with another iterator to find the midpoint
        while (cursor.next != null) {
            if (position % 2 == 0) {
                previous = midpoint;
                midpoint = midpoint.next;
            }

            cursor = cursor.next;
            position++;
        }

        // cut array in half - the second half will be reversed
        previous.next = null;
        ListNode latterHalf = reverse(midpoint);

        /**
         * Store a pointer to the next node and latter half's next node, assign current node's next to 
         * next element in latter half of list. Iterate to next node in former + latter half. 
         */
        ListNode root = head;
        while (root != null && latterHalf != null) {
            ListNode rootNext = root.next;
            ListNode latterHalfNext = latterHalf.next;
            root.next = latterHalf;
            root.next.next = rootNext;
            root = rootNext;
            latterHalf = latterHalfNext;
        }

        return head;
    }

    /**
     * Iteratively reverse linked list in place
     * 
     * @param head The beginning of the list
     * @return reversed list
     */
    static ListNode reverse(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        ListNode next;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }

}
