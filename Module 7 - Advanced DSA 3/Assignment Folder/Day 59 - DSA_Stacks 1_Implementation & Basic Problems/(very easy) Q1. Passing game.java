Problem Description
There is a football event going on in your city. In this event, you are given A passes and players having ids between 1 and 106.
Initially, some player with a given id had the ball in his possession. You have to make a program to display the id of the player who possessed the ball after exactly A passes.

There are two kinds of passes:
1) ID
2) 0

For the first kind of pass, the player in possession of the ball passes the ball "forward" to the player with id = ID.
For the second kind of pass, the player in possession of the ball passes the ball back to the player who had forwarded the ball to him.
In the second kind of pass "0" just means Back Pass.
Return the ID of the player who currently possesses the ball.

Problem Constraints
1 <= A <= 100000
1 <= B <= 100000
|C| = A

Input Format
The first argument of the input contains the number A.
The second argument of the input contains the number B ( id of the player possessing the ball in the very beginning).
The third argument is an array C of size A having (ID/0).

Output Format
Return the "ID" of the player who possesses the ball after A passes.

public class Solution {
    public int solve(int A, int B, ArrayList<Integer> C) {

        //APPROACH USING ONLY STACK
        Stack<Integer> stack = new Stack<>();
        stack.push(B);

        for(int i=0; i<A; i++){
            int pass = C.get(i);
            if(pass == 0){
                stack.pop();
            }else{
                stack.push(pass);
            }
        }

        return stack.pop();
    }
}
