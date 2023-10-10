/*
* File: sfo_33_postorder_traversal_of_a_binary_search_tree_s1.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

// ===== Solution Code =====
class Solution {
public:
    bool verifyPostorder(vector<int>& postorder) {
        return recur(postorder, 0, postorder.size() - 1);
    }
private:
    bool recur(vector<int>& postorder, int i, int j) {
        if(i >= j) return true;
        int p = i;
        while(postorder[p] < postorder[j]) p++;
        int m = p;
        while(postorder[p] > postorder[j]) p++;
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }
};

int main() {
    // ======= Test Case =======
    vector<int> postorder = { 1, 6, 3, 2, 5 };
    // ====== Driver Code ======
    Solution* slt = new Solution();
    bool res = slt->verifyPostorder(postorder);
    cout << boolalpha << res << endl;
    
    return 0;
}
