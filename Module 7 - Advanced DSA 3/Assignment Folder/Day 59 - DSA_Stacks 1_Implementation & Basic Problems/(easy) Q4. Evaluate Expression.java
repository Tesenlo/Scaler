Problem Description
An arithmetic expression is given by a string array A of size N. Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are +, -, *, /. Each string may be an integer or an operator.
Note: Reverse Polish Notation is equivalent to Postfix Expression, where operators are written after their operands.

Problem Constraints
1 <= N <= 105

Input Format
The only argument given is string array A.

Output Format
Return the value of arithmetic expression formed using reverse Polish Notation.

public class Solution {
    public int evalRPN(ArrayList<String> A) {
        int n = A.size();

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++){
            String str = A.get(i);
            if(str.equals("+")
            || str.equals("-")
            || str.equals("*")
            || str.equals("/")){
                char operatorChar = str.charAt(0);
                int num1 = stack.pop();
                if(stack.size() != 0){  
                    int num2 = stack.pop();
                    int value = 0;
                    switch(operatorChar){
                        case '+':
                        value = num2 + num1;
                        break;

                        case '-':
                        value = num2 - num1;
                        break;

                        case '*':
                        value = num2 * num1;
                        break;

                        case '/':
                        value = num2 / num1;
                        break;
                    }
                    stack.push(value);
                   
                }else{
                     
                    stack.push(-num1);
                        
                }
                
            }else{
                int num = Integer.valueOf(str);
                stack.push(num);
            }
        }

        return stack.pop();
    }
}


