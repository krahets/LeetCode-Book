/*
* File: lc_205_isomorphic_strings.java
* Created Time: 2025-12-30
* Author: krahets
*/

package lc_205_isomorphic_strings;

import include.*;
import java.util.*;

// ===== Solution Code =====
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            Map<Character, Character> s2t = new HashMap<>(), t2s = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char a = s.charAt(i), b = t.charAt(i);
                // 对于已有映射 a -> s2t[a]，若和当前字符映射 a -> b 不匹配，
                // 说明有一对多的映射关系，则返回 false ；
                // 对于映射 b -> a 也同理
                if (s2t.containsKey(a) && s2t.get(a) != b || 
                    t2s.containsKey(b) && t2s.get(b) != a)
                    return false;
                s2t.put(a, b);
                t2s.put(b, a);
            }
            return true;
        }
    }

public class lc_205_isomorphic_strings {
    public static void main(String[] args) {
        // ======= Test Case =======
        String test_input_s = "egg";
        String test_input_t = "add";
        var expected_output = true;

        // ====== Driver Code ======
        Solution slt = new Solution();
        var result = slt.isIsomorphic(test_input_s, test_input_t);
        System.out.println(result);

    }
}
