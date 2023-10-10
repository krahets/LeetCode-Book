/*
* File: sfo_37_serialize_and_deserialize_a_binary_tree_s1.cpp
* Created Time: 2021-12-09
* Author: Krahets (krahets@163.com)
*/

#include "../include/include.hpp"

class Codec {
public:
    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        if(root == nullptr) return "[]";
        string res = "[";
        queue<TreeNode*> que;
        que.emplace(root);
        while(!que.empty()) {
            TreeNode* node = que.front();
            que.pop();
            if(node != nullptr) {
                res += (to_string(node->val) + ",");
                que.emplace(node->left);
                que.emplace(node->right);
            }
            else res += "null,";
        }
        res.pop_back();
        res += "]";
        return res;
    }

    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        vector<string> list = split(data.substr(1, data.length() - 2), ",");
        TreeNode *root = new TreeNode(std::stoi(list[0]));
        queue<TreeNode*> que;
        que.emplace(root);
        int i = 1;
        while(!que.empty()) {
            TreeNode *node = que.front();
            que.pop();
            if(list[i] != "null") {
                node->left = new TreeNode(std::stoi(list[i]));
                que.emplace(node->left);
            }
            i++;
            if(list[i] != "null") {
                node->right = new TreeNode(std::stoi(list[i]));
                que.emplace(node->right);
            }
            i++;
        }
        return root;
    }

private:
    // Split a str by a delim
    vector<string> split(string str, string delim) {
        vector<string> list;
        int i = 0, j = 0, len = str.length();
        while (i < len) {
            while (j < len && str[j] != ',')
                j++;
            list.push_back(str.substr(i, j - i));
            i = ++j;
        }
        return list;
    }
};

int main() {
    // ======= Test Case =======
    string data = "[1,2,3,null,null,4,5,null,null,null,null]";
    // ====== Driver Code ======
    Codec* codec = new Codec();
    TreeNode* root = codec->deserialize(data);
    string res = codec->serialize(root);
    PrintUtil::printTree(root);
    cout << res << endl;
}
