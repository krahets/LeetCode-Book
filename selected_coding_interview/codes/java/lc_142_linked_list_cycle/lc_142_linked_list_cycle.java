/*
* File: lc_142_linked_list_cycle.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_142_linked_list_cycle;

import include.*;
import java.util.*;

// ===== Solution Code =====
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode fast = head, slow = head;
            while (true) {
                if (fast == null || fast.next == null) return null;
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) break;
            }
            fast = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return fast;
        }
    }

public class lc_142_linked_list_cycle {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1
        // TODO: Add appropriate test case

        // ====== Driver Code ======
        Solution slt = new Solution();
        // result = slt.detectCycle(...)
        // print(result)

    }
}
