Problem Description
Given an array A, find the next greater element G[i] for every element A[i] in the array.
The next greater element for an element A[i] is the first greater element on the right side of A[i] in the array, A.

More formally:
G[i] for an element A[i] = an element A[j] such that 
    j is minimum possible AND 
    j > i AND
    A[j] > A[i]
Elements for which no greater element exists, consider the next greater element as -1.

Problem Constraints
1 <= |A| <= 105
1 <= A[i] <= 107

Input Format
The first and the only argument of input contains the integer array, A.

Output Format
Return an integer array representing the next greater element for each index in A.

public class Solution {
    public ArrayList<Integer> nextGreater(ArrayList<Integer> A) {

        int n = A.size();
        ArrayList<Integer> ans = new ArrayList<>();

        if(n == 1){
            ans.add(-1);
            return ans;
        }

        Stack<Integer> stack = new Stack<>();
        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && stack.peek()<=A.get(i)){
                stack.pop();
            }
            
            if(stack.isEmpty()){
                ans.add(-1);
            }else{
                ans.add(stack.peek());      
            }
            stack.push(A.get(i));
        }

        int size = ans.size();
        int l = 0;
        int r = size-1;
        while(l<r){
            int temp = ans.get(l);
            ans.set(l, ans.get(r));
            ans.set(r, temp);
            l++;
            r--;
        }

        return ans;
    }
}
