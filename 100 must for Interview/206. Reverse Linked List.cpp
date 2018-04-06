//206. Reverse Linked List
//p,head->next,res,head 循环相等

class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        ListNode* res = NULL;
        while(head){
        	ListNode* p = head->next;
        	head->next = res;
        	res = head;
        	head = p;
        }
        return res;
    }
};