//237. Delete Node in a Linked List
// *node直接改list

class Solution {
public:
    void deleteNode(ListNode* node) {
       *node = *node->next;
    }
};