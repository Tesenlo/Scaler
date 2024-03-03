// Problem Description
// Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.
// If the given array contains a sub-array with sum zero return 1, else return 0.

// Problem Constraints
// 1 <= |A| <= 100000
// -10^9 <= A[i] <= 10^9

// Input Format
// The only argument given is the integer array A.

// Output Format
// Return whether the given array contains a subarray with a sum equal to 0.

public class Solution {
  public int solve(ArrayList<Integer> A) {

      int n = A.size();
      ArrayList<Long> pfs = new ArrayList<>();
      pfs.add((long)A.get(0));

      //pfs creation and checking if sum may also be zero
      for(int i=1; i<n; i++){
          long num = pfs.get(i-1) + A.get(i);
          if(num == 0){
              return 1;
          }else{
              pfs.add(num);
          }
      }

      HashSet<Long> set = new HashSet<>();
      for(int i=0; i<n; i++){
          set.add(pfs.get(i));
      }

      if(set.size() == pfs.size()){
          return 0;
      }else{
          return 1;
      }
  }
}
