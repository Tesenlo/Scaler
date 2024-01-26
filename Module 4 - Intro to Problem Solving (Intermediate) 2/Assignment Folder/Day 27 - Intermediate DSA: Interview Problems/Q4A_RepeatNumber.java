// Problem Description
// You're given a read-only array of N integers. Find out if any integer occurs more than N/3 times in the array in linear time and constant additional space.
// If so, return the integer. If not, return -1.
// If there are multiple solutions, return any one.

// Note: Read-only array means that the input array should not be modified in the process of solving the problem

// Problem Constraints
// 1 <= N <= 7*105
// 1 <= A[i] <= 109

public class Solution {
	// DO NOT MODIFY THE LIST
	public int repeatedNumber(final List<Integer> a) {  //TC = O(n)  SC = O(n)

        int n = a.size();
        HashMap<Integer, Integer> map = new HashMap<>();  

        for(int i=0; i<n; i++){
            int key = a.get(i);
            if(map.containsKey(key)){
                map.put(key, map.get(key)+1);
            }else{
                map.put(key,1);
            }
        }

        for(int key:map.keySet()){
            int value = map.get(key);
            if(value>n/3){
                return key;
            }
        }

        return -1;
	}
}
