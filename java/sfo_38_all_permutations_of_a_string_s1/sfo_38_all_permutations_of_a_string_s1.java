/*
* File: sfo_38_all_permutations_of_a_string_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_38_all_permutations_of_a_string_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    List<String> res = new LinkedList<>();
    char[] c;
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }
    void dfs(int x) {
        if(x == c.length - 1) {
            res.add(String.valueOf(c));      // 添加排列方案
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for(int i = x; i < c.length; i++) {
            if(set.contains(c[i])) continue; // 重复，因此剪枝
            set.add(c[i]);
            swap(i, x);                      // 交换，将 c[i] 固定在第 x 位
            dfs(x + 1);                      // 开启固定第 x + 1 位字符
            swap(i, x);                      // 恢复交换
        }
    }
    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }
}

public class sfo_38_all_permutations_of_a_string_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        String s = "abc";
        // ====== Driver Code ======
        Solution slt = new Solution();
        String[] res = slt.permutation(s);
        System.out.println(Arrays.toString(res));
    }
}
