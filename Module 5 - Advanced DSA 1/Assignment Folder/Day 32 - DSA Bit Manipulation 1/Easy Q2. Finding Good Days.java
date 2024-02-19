public class Solution {
    public int solve(int A) {
        int count = 0;
        for(int i=0; i<31; i++){
            if((A&1<<i)>0){
                count++;
            }
        }

        return count;
    }
}
