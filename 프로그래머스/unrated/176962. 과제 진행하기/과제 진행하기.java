import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        
        String[][] ascPlans = plans.clone();
        
        for(int i=0; i<plans.length;i++) {
        	for(int j=i+1; j<plans.length;j++) {
            	int sum = calTime(ascPlans[i][1]);
            	
            	int jSum =calTime(ascPlans[j][1]);
            	
            	if(sum>jSum) {
            		String[] copyElement = ascPlans[i].clone();
            		ascPlans[i] = ascPlans[j].clone();
            		ascPlans[j] = copyElement;
            	}
        	}
        }
        
//        for(int i=0; i<plans.length;i++) {
//        	for(int j=0; j<3;j++) {
//        		System.out.print(ascPlans[i][j]+", ");
//        	}
//        	System.out.println("");
//        }
//    	System.out.println("===============");
        
        Stack<info> stack = new Stack<>();
        
        int answerIndex = 0;
        int nowTime = calTime(ascPlans[0][1]);
        for(int index=0;index<ascPlans.length;index++) {
        	stack.add(new info(ascPlans[index][0],ascPlans[index][1],Integer.parseInt(ascPlans[index][2])));
        	nowTime = calTime(ascPlans[index][1]);

        	while(!stack.isEmpty()) {
        		info nowPlan = stack.pop();

//    			System.out.println("subject :"+nowPlan.subject+", startTime :"+nowPlan.startTime+", spendTime :"+nowPlan.spendTime);
        		
        		//pending과제 말고 다음 과제가 없다
        		if(index+1>=ascPlans.length) {
        			answer[answerIndex++] = nowPlan.subject;
        		}else {
        			int interval = calTime(ascPlans[index+1][1]) - nowTime;
//        			System.out.println("subject :"+nowPlan.subject+", startTime :"+nowPlan.startTime+", spendTime :"+nowPlan.spendTime);
            		//1. interval이 과제시간 초과시 -> 현재과제 처리 후 stack or 다음과제
        			if(interval==nowPlan.spendTime) {
        				stack.add(new info(ascPlans[index+1][0],ascPlans[index+1][1],Integer.parseInt(ascPlans[index+1][2])));
        				answer[answerIndex++] = nowPlan.subject; 
        				index++;
        				nowTime+=nowPlan.spendTime;
        				
        			}else if(interval>nowPlan.spendTime) {

        				answer[answerIndex++] = nowPlan.subject; 
        				nowTime += nowPlan.spendTime;
//        				stack.add(new info(ascPlans[index][0],ascPlans[index][1],Integer.parseInt(ascPlans[index][2])));
        			//2. interval이 과제시간 이하시 -> 현재과제 push 후 다음과제 push 
        			}else {
                    	nowPlan.spendTime-= interval;
        				nowTime += interval;
                    	stack.add(nowPlan);
        				stack.add(new info(ascPlans[index+1][0],ascPlans[index+1][1],Integer.parseInt(ascPlans[index+1][2])));
        				index++;
        				
        			}
        		}
        	}
        }
//         for(int i=0; i<answer.length;i++) {
//         	System.out.println(answer[i]);
//         }
        
        return answer;
    }
    
    public static int calTime(String date) {
    	int hh = Integer.parseInt(date.split(":")[0]);
    	int mm = Integer.parseInt(date.split(":")[1]);
    	
    	return hh*60 + mm;
    }
}
class info{
	String subject;
	String startTime;
	int spendTime;
	
	public info(String subject, String startTime, int spendTime) {
		this.subject = subject;
		this.startTime = startTime;
		this.spendTime = spendTime;
	}
	
}