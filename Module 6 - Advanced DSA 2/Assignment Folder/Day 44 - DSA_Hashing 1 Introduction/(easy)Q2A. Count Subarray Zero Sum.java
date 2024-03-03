// Problem Description
// Given an array A of N integers.
// Find the count of the subarrays in the array which sums to zero. Since the answer can be very large, return the remainder on dividing the result with 109+7

// Problem Constraints
// 1 <= N <= 105
// -109 <= A[i] <= 109

// Input Format
// Single argument which is an integer array A.

// Output Format
// Return an integer.

//NOTE : ZERO number edge cases are a pain

public class Solution {
    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        int mod = 1000000007;

        // if array is of size 1
        if(n == 1){
            if(A.get(0)==0){
                return 1;
            }else{
                return 0;
            }        
        }

        long count = 0;

         //prefix sum array creation
        ArrayList<Long> pfs = new ArrayList<>();
        pfs.add((long)A.get(0));
        if(pfs.get(0)==0){
            count++;
        }
        for(int i=1; i<n; i++){
            long num = pfs.get(i-1)+A.get(i);
            pfs.add(num);
            if(num == 0){   //for every 0 in pfs, increment count
                count++;
            }
        }
        
        //freq map creation
        HashMap<Long, Long> map = new HashMap<>();
        for(int i=0; i<n; i++){
            long num = pfs.get(i);
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1l);
            }else{
                map.put(num, 1l);
            }
        }

        //compute number of sub arrays possible if freq is greater than 1
        for(long key : map.keySet()){
            long freq = map.get(key);
            if(freq>1l){
                count += (freq*(freq-1))/2;
            }
            
        }

        int finalCount = (int)count%mod;
        return finalCount;
    }
}
