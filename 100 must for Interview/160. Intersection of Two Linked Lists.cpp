//160. Intersection of Two Linked Lists
//a走到null时，变为b的head；b同理。直到a==b

class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        ListNode *a = headA, *b = headB;
        while (a != b){
            a = a?a->next:headB;
            b = b?b->next:headA;
        }
        return a;
    }
};