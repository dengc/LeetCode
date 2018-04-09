//234. Palindrome Linked List
//用slow 和 fast 找到中间node，然后reverse后面的list，再和head对比

class Solution {
public:
    bool isPalindrome(ListNode* head) {
        if(!head || !head->next){
            return true;
        }
        
        ListNode* slow = head;
        ListNode* fast = head;
        while(fast->next!= NULL && fast->next->next!= NULL){
            slow = slow->next;
            fast = fast->next->next;
        }
        slow->next = reverseList(slow->next);
        slow = slow->next;
        while(slow){
            if(head->val!= slow->val){
                return false;
            }
            head = head->next;
            slow = slow->next;
        }
        return true;
    }
    ListNode* reverseList(ListNode* head){
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