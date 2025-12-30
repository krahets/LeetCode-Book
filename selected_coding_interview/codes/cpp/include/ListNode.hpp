/*
 * File: ListNode.hpp
 * Created Time: 2025-12-30
 * Author: krahets
 */

#pragma once

#include <iostream>
#include <vector>
using namespace std;

/**
 * @brief Definition for a singly-linked list node
 *
 */
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(nullptr) {
    }
};

/**
 * @brief Generate a linked list with a vector
 *
 * @param list
 * @return ListNode*
 */
ListNode *vectorToLinkedList(vector<int> list) {
    ListNode *dum = new ListNode(0);
    ListNode *head = dum;
    for (int val : list) {
        head->next = new ListNode(val);
        head = head->next;
    }
    return dum->next;
}

/**
 * @brief Get a list node with specific value from a linked list
 *
 * @param head
 * @param val
 * @return ListNode*
 */
ListNode *getListNode(ListNode *head, int val) {
    while (head != nullptr && head->val != val) {
        head = head->next;
    }
    return head;
}

/**
 * @brief Definition for a list node with random pointer
 *
 */
class Node {
public:
    int val;
    Node* next;
    Node* random;

    Node(int _val) {
        val = _val;
        next = nullptr;
        random = nullptr;
    }
};
