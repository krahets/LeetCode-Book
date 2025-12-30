/*
* File: lc_20_valid_parentheses.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_20_valid_parentheses;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        private static final Map<Character,Character> map = new HashMap<Character,Character>(){{
            put('{','}'); put('[',']'); put('(',')'); put('?','?');
        }};
        public boolean isValid(String s) {
            if(s.length() > 0 && !map.containsKey(s.charAt(0))) return false;
            LinkedList<Character> stack = new LinkedList<Character>() {{ add('?'); }};
            for(Character c : s.toCharArray()){
                if(map.containsKey(c)) stack.addLast(c);
                else if(map.get(stack.removeLast()) != c) return false;
            }
            return stack.size() == 1;
        }
    }

public class lc_20_valid_parentheses {
    public static void main(String[] args) {
        // ======= Test Case =======
        // Test case 1
        String test_input = "example";

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.isValid(test_input);
        System.out.println(result);

    }
}
