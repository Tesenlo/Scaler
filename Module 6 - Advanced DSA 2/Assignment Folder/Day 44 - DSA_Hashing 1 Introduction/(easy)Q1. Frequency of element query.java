// Problem Description
// Given an array A. You have some integers given in the array B.
// For the i-th number, find the frequency of B[i] in the array A and return a list containing all the frequencies.

// Problem Constraints
// 1 <= |A| <= 105
// 1 <= |B| <= 105
// 1 <= A[i] <= 105
// 1 <= B[i] <= 105

// Input Format
// First argument A is an array of integers.
// Second argument B is an array of integers denoting the queries.

// Output Format
// Return an array of integers containing frequency of the each element in B.

public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int a = A.size();
        int b = B.size();
        ArrayList<Integer> ans = new ArrayList<>();

        //frequency map
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<a; i++){
            int num = A.get(i);
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }else{
                map.put(num, 1);
            }
        }


        for(int i=0; i<b; i++){
            int query = B.get(i);
            if(map.containsKey(query)){
                ans.add(map.get(query));
            }else{
                ans.add(0);
            }
        }
        return ans;

    }
}
