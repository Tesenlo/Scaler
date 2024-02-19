/*Problem Description
Given an array of integers A and an integer B, find and return the number of pairs in A whose sum is divisible by B.
Since the answer may be large, return the answer modulo (109 + 7).

Note: Ensure to handle integer overflow when performing the calculations.

Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 109
1 <= B <= 106

Input Format
The first argument given is the integer array A.
The second argument given is the integer B.

Output Format
Return the total number of pairs for which the sum is divisible by B modulo (109 + 7).
*/

public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        int mod = 1000000007;

        //array of first number modulus with B
        ArrayList<Integer> firstModuloNumber = new ArrayList<>();
        for(int i=0; i<n; i++){
            firstModuloNumber.add(A.get(i)%B);
        }

        //map of all modulos along with its freq
        HashMap<Integer, Long> moduloFreqMap = new HashMap<>();
        //range of mod is [0, B-1]. Initializing every key-value pair with value as 0
        for(int j=0; j<B; j++){
            moduloFreqMap.put(j,0l);
        }

        //populating with frequency count
        for(int i=0; i<n; i++){
            int key = firstModuloNumber.get(i);
            if(moduloFreqMap.containsKey(key)){
                moduloFreqMap.put(key,moduloFreqMap.get(key)+1);
            }
        }

        //handle zero case 
        long pairCount = 0;
        long ZeroFreq = moduloFreqMap.get(0);
        pairCount += (ZeroFreq*(ZeroFreq-1))/2;

        //if even, handle central element count;
        if(B%2==0){
            long centralElementCount = moduloFreqMap.get(B/2);
            pairCount += (centralElementCount*(centralElementCount-1))/2;
            
        }

        for(int i=1; i<((B+1)/2); i++){
            long firstNumberCount = moduloFreqMap.get(i);
            long secondNumberCount = moduloFreqMap.get(B-i);
            pairCount += (firstNumberCount*secondNumberCount);
        }


        return (int)(pairCount%mod);
    }
}




