/*
* File: lc_387_first_unique_character_in_a_string.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_387_first_unique_character_in_a_string;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public int firstUniqChar(String s) {
            HashMap<Character, Boolean> dic = new HashMap<>();
            char[] sc = s.toCharArray();
            for(char c : sc)
                dic.put(c, !dic.containsKey(c));
            for(int i = 0; i < sc.length; i++)
                if(dic.get(sc[i])) return i;
            return -1;
        }
    }

public class lc_387_first_unique_character_in_a_string {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1
        String test_input = "example";

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.firstUniqChar(test_input);
        System.out.println(result);

    }
}
