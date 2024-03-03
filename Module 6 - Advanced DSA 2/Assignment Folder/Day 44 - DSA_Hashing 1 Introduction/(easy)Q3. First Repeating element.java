// Problem Description
// Given an integer array A of size N, find the first repeating element in it.
// We need to find the element that occurs more than once and whose index of the first occurrence is the smallest.
// If there is no repeating element, return -1.

// Problem Constraints
// 1 <= N <= 105
// 1 <= A[i] <= 109

// Input Format
// The first and only argument is an integer array A of size N.

// Output Format
// Return an integer denoting the first repeating element.

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

        for(int i=0; i<n; i++){
            int num = A.get(i);
            if(map.get(num)>1){
                return num;
            }
        }

        return -1;
    }
}
