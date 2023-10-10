/*
* File: sfo_39_the_majority_element_in_an_array_s1.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_39_the_majority_element_in_an_array_s1;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    public int majorityElement(int[] nums) {
        int x = 0, votes = 0;
        for(int num : nums){
            if(votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }
}

public class sfo_39_the_majority_element_in_an_array_s1 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int[] nums = { 1, 2, 3, 2, 2, 2, 5, 4, 2 };
        // ====== Driver Code ======
        Solution slt = new Solution();
        int res = slt.majorityElement(nums);
        System.out.println(res);
    }
}
