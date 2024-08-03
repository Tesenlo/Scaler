Problem Description
Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.
If the answer does not exist return an array with a single integer "-1".
First sub-array means the sub-array for which starting index in minimum.

Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 109
1 <= B <= 109

Input Format
The first argument given is the integer array A.
The second argument given is integer B.

Output Format
Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single integer "-1".

public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        long sum = A.get(0);

        ArrayList<Integer> ans = new ArrayList<>();

        if(sum == B){
            ans.add(A.get(0));
            return ans;
        }

        int i = 0;
        int j = 0;
        int flag = 0;


        while(j<n){
            if(sum == B){
                flag = 1;
                break;
            }else if(sum<B){
                j++;
                if(j<n){
                    sum += A.get(j);
                }else{
                    ans.add(-1);
                    return ans;
                }
            }else{
                sum -= A.get(i);
                i++;
            }

            //reset and start again
            if(i >= j  && i<n){
                j = i;
                sum = A.get(i);
            }
        }

        if(flag == 1){
            for(int start=i; start<=j; start++){
                ans.add(A.get(start));
            }
            return ans;
        }else{
            ans.add(-1);
            return ans;
        }
    }
}
