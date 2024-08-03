Problem Description
Write a program to find the node at which the intersection of two singly linked lists, A and B, begins. For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗
B:     b1 → b2 → b3
NOTE:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
The custom input to be given is different than the one explained in the examples. Please be careful.

Problem Constraints
0 <= |A|, |B| <= 106

Input Format
The first argument of input contains a pointer to the head of the linked list A.
The second argument of input contains a pointer to the head of the linked list B.

Output Format
Return a pointer to the node after which the linked list is intersecting.

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode getIntersectionNode(ListNode A, ListNode B) {
        
        if(A == null || B == null){
            return null;
        }
        ListNode temp1 = A;
        ListNode temp2 = B;
        ListNode ans = null;

        //count length of both LL
        int n1 = 0;
        int n2 = 0;
        while(temp1!=null){
            n1++;
            temp1 = temp1.next;
        }

        while(temp2!=null){
            n2++;
            temp2 = temp2.next;
        }

        temp1 = A;
        temp2 = B;
        //if both LL are of same length
        if(n1 == n2){
            ans = checkIntersection(temp1, temp2);
        }

        //if LL A is larger than B
        else if(n1>n2){   
            int startPos = n1-n2;
            for(int i=1; i<=startPos; i++){
                temp1 = temp1.next;
            }
            ans = checkIntersection(temp1, temp2);

        //if B is larger than A
        }else{
            int startPos = n2-n1;
            for(int i=1; i<=startPos; i++){
                temp2 = temp2.next;
            }
            ans = checkIntersection(temp1, temp2);
        }

        return ans;
	
	}

    //Check intersection point when both LL are of same length;
    public static ListNode checkIntersection(ListNode x, ListNode y){
        ListNode ans = null;
        ListNode p = x;
        ListNode q = y;

        while(p!=null){
            if(p == q){
                ans = p;
                break;
            }

            p = p.next;
            q = q.next;
        }

        return ans;
    }
}

