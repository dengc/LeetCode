//2. Add Two Numbers
//recursive: res->next = addTwoNumbers(l1->next,l2->next);

class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        if(l1 == NULL && l2 == NULL){
            return NULL;
        }
        int a = 0, b = 0;
        ListNode *resL1 = NULL;
        ListNode *resL2 = NULL;
        
        if(l1 != NULL){
            a = l1->val;
            resL1 = l1->next;
        }
        if(l2 != NULL){
            b = l2->val;
            resL2 = l2->next;
        }
        
        int firstNum = a + b;
        if(firstNum >= 10){
            firstNum -= 10;
            if(resL1 == NULL){
                resL1 = new ListNode(1);
            }
            else{
                resL1->val++;
            }
        }
        ListNode *res = new ListNode(firstNum);
        
        res->next = addTwoNumbers(resL1,resL2);
        return res;
    }
};