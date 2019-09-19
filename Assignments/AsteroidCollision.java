package Assignments;

import java.util.Stack;

public class AsteroidCollision {
	
public static boolean validateStackSequences(int[] pushed, int[] popped) {
        
        
        Stack<Integer> s = new Stack<>();       // for pushed elements
        int j = 0;  //index for popped
        
        for(int i = 0; i<pushed.length; i++){
            
            if(pushed[i] == popped[j]){
            	System.out.println("PUSHING-------" + pushed[i]);
                j++;
                continue;
            }
            
            	
                while(!s.isEmpty() && s.peek() == popped[j]){
                	System.out.println("Popping-------" + s.peek());
                    s.pop();
                    j++;
                
               
                }
                s.push(pushed[i]);
                
                
           
            
            
            
        }
        while(!s.isEmpty() && popped[j] == s.peek()) {
        	j++;
        	s.pop();
        }
       
        return s.isEmpty();
        
    }

public static void main(String[] args) {
	int push[] = {1,0};
	int pop[] = {1,0};
	System.out.println(validateStackSequences(push, pop));
}

}
