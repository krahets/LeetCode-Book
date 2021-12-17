/*
* File: sfo_17_print_from_1_to_the_largest_n_digits_s2.java
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

package sfo_17_print_from_1_to_the_largest_n_digits_s2;

import include.*;
import java.util.*;

// ===== Solution Code =====
class Solution {
    StringBuilder res;
    int count = 0, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public String printNumbers(int n) {
        this.n = n;
        res = new StringBuilder(); // 数字字符串集
        num = new char[n]; // 定义长度为 n 的字符列表
        dfs(0); // 开启全排列递归
        res.deleteCharAt(res.length() - 1); // 删除最后多余的逗号
        return res.toString(); // 转化为字符串并返回
    }
    void dfs(int x) {
        if(x == n) { // 终止条件：已固定完所有位
            res.append(String.valueOf(num) + ","); // 拼接 num 并添加至 res 尾部，使用逗号隔开
            return;
        }
        for(char i : loop) { // 遍历 ‘0‘ - ’9‘
            num[x] = i; // 固定第 x 位为 i
            dfs(x + 1); // 开启固定第 x + 1 位
        }
    }
}

public class sfo_17_print_from_1_to_the_largest_n_digits_s2 {
    public static void main(String[] args) {
        // ======= Test Case =======
        int n = 1;
        // ====== Driver Code ======
        Solution slt = new Solution();
        String res = slt.printNumbers(n);
        System.out.println(res);
    }
}
