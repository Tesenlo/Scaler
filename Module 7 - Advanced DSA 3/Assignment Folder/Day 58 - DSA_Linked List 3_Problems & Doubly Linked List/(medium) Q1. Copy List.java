Problem Description
You are given a linked list A
Each node in the linked list contains two pointers: a next pointer and a random pointer
The next pointer points to the next node in the list
The random pointer can point to any node in the list, or it can be NULL
Your task is to create a deep copy of the linked list A
The copied list should be a completely separate linked list from the original list, but with the same node values and random pointer connections as the original list
You should create a new linked list B, where each node in B has the same value as the corresponding node in A
The next and random pointers of each node in B should point to the corresponding nodes in B (rather than A)


Problem Constraints
0 <= |A| <= 106

Input Format
The first argument of input contains a pointer to the head of linked list A.

Output Format
Return a pointer to the head of the required linked list.

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        
        RandomListNode x = head;
        if(x == null){
            return null;
        }
        
        //STEP 1 - insert new nodes in betweeen old nodes without random pointer
        while(x!=null){
            RandomListNode y = new RandomListNode(x.label);
            y.next = x.next;
            x.next = y;
            x = x.next.next;
        }

        //STEP 2 - update the 'random' pointer of the new nodes
        RandomListNode temp = head;
        while(temp!=null){
            if(temp.random == null){
                temp.next.random = null;
            }else{
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        //STEP 3 - detach the 2 LL 
        RandomListNode h2 = head.next;
        x = head;
        RandomListNode y = h2;
        while(x!=null){
            x.next = x.next.next;
            if(y.next!=null){
                y.next = y.next.next;
            }
            x = x.next;
            y = y.next;
        }

        return h2;
    }
}
