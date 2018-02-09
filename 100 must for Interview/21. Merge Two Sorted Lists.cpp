//21. Merge Two Sorted Lists
//recursive: 每次取小为新的node，res->next = mergeTwoLists(l1, l2);

class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        if(l1 == NULL){
        	return l2;
        }
        if(l2 == NULL){
        	return l1;
        }
        ListNode* res = new ListNode(l1->val);
        if(l2->val <= l1->val){
        	res = new ListNode(l2->val);
        	l2 = l2->next;
        }else{
        	l1 = l1->next;
        }
        res->next = mergeTwoLists(l1, l2);
        return res;
    }
};