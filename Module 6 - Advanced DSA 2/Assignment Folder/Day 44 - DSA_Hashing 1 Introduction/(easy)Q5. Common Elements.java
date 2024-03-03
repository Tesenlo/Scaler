// Problem Description
// Given two integer arrays, A and B of size N and M, respectively. Your task is to find all the common elements in both the array.

// NOTE:
// Each element in the result should appear as many times as it appears in both arrays.
// The result can be in any order.

// Problem Constraints
// 1 <= N, M <= 105
// 1 <= A[i] <= 109

// Input Format
// First argument is an integer array A of size N.
// Second argument is an integer array B of size M.

// Output Format
// Return an integer array denoting the common elements.
// Do not write code to include libraries, main() function or accept any input from the console.
// Initialization code is already written and hidden from you. Do not write code for it again.
public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        // Just write your code below to complete the function. Required input is available to you as the function arguments.
        // Do not print the result or any output. Just return the result via this function.

        int a = A.size();
        int b = B.size();

        HashMap<Integer, Integer> mapA = new HashMap<>();
        HashMap<Integer, Integer> mapB = new HashMap<>();
       
        for(int i=0; i<a; i++){
            int num = A.get(i);
            if(mapA.containsKey(num)){
                mapA.put(num, mapA.get(num)+1);
            }else{
                mapA.put(num, 1);
            }
        }

        for(int i=0; i<b; i++){
            int num = B.get(i);
            if(mapB.containsKey(num)){
                mapB.put(num, mapB.get(num)+1);
            }else{
                mapB.put(num, 1);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(int key : mapA.keySet()){
            if(
                mapB.containsKey(key)
            ){        
                int freq = Math.min(mapA.get(key), mapB.get(key));
                for(int i=0; i<freq; i++){
                    ans.add(key);
                }
            }
        }
        return ans;
    }
}
