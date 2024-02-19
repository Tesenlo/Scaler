public class Solution {

    // 1s place    : 1 to 9 = 1 * n/10 
    // 10s place   : 10 to 19 = 10 * n/100
    // 100s place  : 100 to 199 = 100 * n/1000;
    // 1000s place : 1000 to 1999 = 1000;
    // .
    // .
    public int solve(int A) {
       
       if(A==0){
           return 0;
       }
       int count = 0;
       int i=1;
       while(A/i>0){
           count += (A/(i*10))*i + Math.min(Math.max(A%(i*10)-(i-1),0),i);
           i = i*10;
       }

       return count;
    }
}
