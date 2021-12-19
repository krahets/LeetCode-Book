/*
 * File: PrintUtil.hpp
 * Created Time: 2021-12-19
 * Author: Krahets (krahets@163.com)
 */

#pragma once

#include <iostream>
#include <string>
#include <sstream>
#include "ListNode.hpp"
#include "TreeNode.hpp"

/**
 * @brief Find an element in a vector
 * 
 * @tparam T 
 * @param vec 
 * @param ele 
 * @return int 
 */
template <typename T>
int vecFind(const vector<T>& vec, T ele) {
    int j = INT_MAX;
    for (int i = 0; i < vec.size(); i++) {
        if (vec[i] == ele) {
            j = i;
        }
    }
    return j;
}

/**
 * @brief Concatenate a vector with a delim
 * 
 * @tparam T 
 * @param delim 
 * @param vec 
 * @return string 
 */
template <typename T>
string join(const string& delim, const T& vec) {
    ostringstream s;
    for (const auto& i : vec) {
        if (&i != &vec[0]) {
            s << delim;
        }
        s << i;
    }
    return s.str();
}

/**
 * @brief Repeat a string for n times
 * 
 * @param str 
 * @param n 
 * @return string 
 */
string repeat(string str, int n) {
    ostringstream os;
    for(int i = 0; i < n; i++)
        os << str;
    return os.str();
}

/**
 * @brief Get the Vector String object
 * 
 * @tparam T 
 * @param list 
 * @return string 
 */
template <typename T>
string getVectorString(vector<T> &list) {
    return "[" + join(", ", list) + "]";
}

/**
 * @brief Print a vector
 * 
 * @tparam T 
 * @param list 
 */
template <typename T>
void printVector(vector<T> &list) {
    cout << getVectorString(list) << '\n';
}

/**
 * @brief Print a vector matrix
 * 
 * @tparam T 
 * @param matrix 
 */
template <typename T>
void printVectorMatrix(vector<vector<T>> &matrix) {
    cout << "[" << '\n';
    for (vector<T> &list : matrix)
        cout << "  " + getVectorString(list) + "," << '\n';
    cout << "]" << '\n';
}

/**
 * @brief Print a linked list
 * 
 * @param head 
 */
void printLinkedList(ListNode *head) {
    vector<int> list;
    while (head != nullptr) {
        list.push_back(head->val);
        head = head->next;
    }
    
    cout << join(" -> ", list) << '\n';
}

/**
 * @brief Print helper for binary tree
 * 
 * @param root 
 * @param level 
 */
void printTreeHelper(TreeNode *root, int level) {
    if (root == nullptr)
        return;
    printTreeHelper(root->right, level + 1); 
    cout << repeat(" ", 4 * level) + "->" << root->val << '\n';
    printTreeHelper(root->left, level + 1);
}

/**
 * @brief Print a binary tree (90º counter-clockwise rotated)
 * 
 * @param root 
 */
void printTree(TreeNode *root) {
    printTreeHelper(root, 0);
}
