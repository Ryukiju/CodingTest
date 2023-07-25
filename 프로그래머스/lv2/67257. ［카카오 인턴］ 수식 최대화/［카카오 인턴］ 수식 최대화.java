import java.util.*;

class Solution {
    public static long solution(String expression) {
        String[] operators1 = {"+","-","*"}; 
        String[] operators2 = {"+","*","-"}; 
        String[] operators3 = {"-","+","*"}; 
        String[] operators4 = {"-","*","+"}; 
        String[] operators5 = {"*","+","-"}; 
        String[] operators6 = {"*","-","+"}; 
        
        List<Long> list = new ArrayList<>();
        
        list.add(curculate(expression, operators1));
        list.add(curculate(expression, operators2));
        list.add(curculate(expression, operators3));
        list.add(curculate(expression, operators4));
        list.add(curculate(expression, operators5));
        list.add(curculate(expression, operators6));
        
        return Collections.max(list);
    }
    
    public static long curculate(String expression, String[] operators) {
    	for(int i=0;i<operators.length;i++) {
    		if(!expression.contains(operators[i])) {
    			continue;
    		}
    		int operIndex = expression.indexOf(operators[i]);
    		int leftNumIndex = operIndex-2;
    		int rightNumLastIndex = operIndex+2;
    		
//    		System.out.println(operIndex);
    		
    		while(leftNumIndex>=0&&Character.isDigit(expression.charAt(leftNumIndex))) {
    			leftNumIndex--;
    		}
    		leftNumIndex++;
    		while(rightNumLastIndex<expression.length()&&Character.isDigit(expression.charAt(rightNumLastIndex))) {
    			rightNumLastIndex++;
    		}
    		rightNumLastIndex--;
    		
//    		System.out.println(leftNumIndex);
    		
    		long leftNum = Long.parseLong(expression.substring(leftNumIndex, operIndex));
    		if(expression.charAt(leftNumIndex)=='0') {
    			leftNum=-leftNum;
    		}
    		long rightNum = Long.parseLong(expression.substring(operIndex+1, rightNumLastIndex+1));
    		if(expression.charAt(operIndex+1)=='0') {
    			rightNum=-rightNum;
    		}
    		String resultStr;
//    		System.out.println(leftNum+", "+rightNum);
    		
    		if(operators[i]=="+") {
    			
    			if(leftNum+rightNum<0) {
    				resultStr = "0"+Long.toString(leftNum+rightNum).substring(1);
    			}else {
    				resultStr = Long.toString(leftNum+rightNum);
    			}
    		}else if(operators[i]=="-") {
    			if(leftNum-rightNum<0) {
    				resultStr = "0"+Long.toString(leftNum-rightNum).substring(1);
    			}else {
    				resultStr = Long.toString(leftNum-rightNum);
    			}
    			
    		}else {
    			if(leftNum*rightNum<0) {
    				resultStr = "0"+Long.toString(leftNum*rightNum).substring(1);
    			}else {
    				resultStr = Long.toString(leftNum*rightNum);
    			}
    		}
			expression = expression.replace(expression.substring(leftNumIndex,rightNumLastIndex+1), resultStr);
    		if(expression.contains(operators[i])) {
    			i--;
    		}
    		
    	}
//    	System.out.println("Result : "+Long.parseLong(expression));
    	return Long.parseLong(expression);
    }
}