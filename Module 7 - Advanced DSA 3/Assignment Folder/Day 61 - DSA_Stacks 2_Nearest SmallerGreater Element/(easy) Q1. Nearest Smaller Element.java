Problem Description
Given an array A, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.

More formally,
G[i] for an element A[i] = an element A[j] such that
j is maximum possible AND
j < i AND
A[j] < A[i]

Elements for which no smaller element exist, consider the next smaller element as -1.

Problem Constraints
1 <= |A| <= 100000
-109 <= A[i] <= 109

Input Format
The only argument given is integer array A.

Output Format
Return the integar array G such that G[i] contains the nearest smaller number than A[i]. If no such element occurs G[i] should be -1.

public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        int n = A.size();
        ArrayList<Integer> ans = new ArrayList<>();
        if(n == 1){
            ans.add(-1);
            return ans;
        }

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++){
            if(stack.isEmpty()){
                ans.add(-1);
                stack.push(A.get(i));
            }else{
                while(!stack.isEmpty()){
                    int top = stack.peek();
                    if(top>=A.get(i)){
                        stack.pop();
                    }else{
                        ans.add(top);
                        stack.push(A.get(i));
                        break;
                    }
                }
                if(stack.isEmpty()){
                    ans.add(-1);
                    stack.push(A.get(i));
                }
            }
        }

        return ans;
    }
}
