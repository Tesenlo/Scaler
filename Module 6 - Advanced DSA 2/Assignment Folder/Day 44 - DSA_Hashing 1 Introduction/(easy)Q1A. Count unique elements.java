// Problem Description
// You are given an array A of N integers. Return the count of elements with frequncy 1 in the given array.

// Problem Constraints
// 1 <= N <= 105
// 1 <= A[i] <= 109

// Input Format
// First argument A is an array of integers.

// Output Format
// Return an integer.

public class Solution {
    public int solve(ArrayList<Integer> A) {
        int n = A.size();

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            int num = A.get(i);
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }else{
                map.put(num, 1);
            }
        }

        int k = map.size();
        int count = 0;
        for(int key : map.keySet()){
            if(map.get(key)==1){
                count++;
            }
        }

        return count;
    }
}
