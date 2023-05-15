import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        
        List<String> fileList = new ArrayList<>();
        for(String file : files) {
        	fileList.add(file);
        }
        
        fileList.sort(new Comparator<String>() {
        	public int compare(String o1, String o2) {
//        		System.out.println("o1 :"+o1+", o2 :"+o2);
        		String header1;
        		String header2;
        		Integer number1;
        		Integer number2;
        		
        		int header1Index=0;
        		int header2Index=0;
        		int number1Index=0;
        		int number2Index=0;
        		
        		for(int i=0; i<o1.length();i++) {
        			if(o1.charAt(i)>=48&&o1.charAt(i)<=57) {
        				header1Index=i;
        				break;
        			}
        		}

        		for(int i=header1Index; i<o1.length();i++) {
        			if(o1.charAt(i)<48||o1.charAt(i)>57) {
        				number1Index=i;
        				break;
        			}
        		}

        		for(int i=0; i<o2.length();i++) {
        			if(o2.charAt(i)>=48&&o2.charAt(i)<=57) {
        				header2Index=i;
        				break;
        			}
        		}

        		for(int i=header2Index; i<o2.length();i++) {
        			if(o2.charAt(i)<48||o2.charAt(i)>57) {
        				number2Index=i;
        				break;
        			}
        		}
        		if(number1Index==0) {
        			number1Index=o1.length();
        		}
        		if(number2Index==0) {
        			number2Index=o2.length();
        		}
        		
        		header1 = o1.substring(0,header1Index);
        		header2 = o2.substring(0,header2Index);
//        		System.out.println(header1Index+", "+number1Index);
        		number1 = Integer.parseInt(o1.substring(header1Index,number1Index));
        		number2 = Integer.parseInt(o2.substring(header2Index,number2Index));
        		
//        		System.out.println("===================");
//        		System.out.println(header1);
//        		System.out.println(number1);
//        		System.out.println(header2);
//        		System.out.println(number2);
//        		System.out.println("===================");
        		
        		if(header1.toUpperCase().compareTo(header2.toUpperCase())>0) {
        			return 1;
        		}
        		else if(header1.toUpperCase().compareTo(header2.toUpperCase())<0) {
        			return -1;
        		}else if(header1.toUpperCase().compareTo(header2.toUpperCase())==0) {
        			if(number1>number2) {
        				return 1;
        			}else if(number1<number2){
        				return -1;
        			}
        		}
        		return 0;
        	};
		});
        
//        System.out.println(fileList);
        for(int i=0; i<fileList.size(); i++) {
        	answer[i]= fileList.get(i);
        }
        
        return answer;
    }
}