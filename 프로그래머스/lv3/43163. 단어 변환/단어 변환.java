import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] visitedWords = new boolean[words.length];
        Queue<Node> queue = new LinkedList<Node>();

    	for(int j=0; j<words.length;j++) {
			int diffrentCnt= 0;
    		for(int i=0; i<begin.length();i++) {
    			if(begin.charAt(i)!=words[j].charAt(i)) {
    				diffrentCnt++;
    				if(diffrentCnt>=2) {
    					break;
    				}
    			}
    		}
    		if(diffrentCnt==1) {
    			boolean[] copyVisitedWords = visitedWords.clone();
    			copyVisitedWords[j]=true;
    			queue.add(new Node(copyVisitedWords, 1, words[j]));
    		}
    	}
//    	System.out.println(queue.peek());
    	
    	while(!queue.isEmpty()) {
    		Node node = queue.poll();
//    		System.out.println("Count :"+node.count+", Word :"+node.word);
    		if(node.word.equals(target)) {
    			return node.count;
    		}
    		
        	for(int j=0; j<words.length;j++) {
        		if(node.visitedWord[j]==true) {
        			continue;
        		}
    			int diffrentCnt= 0;
        		for(int i=0; i<node.word.length();i++) {
        			if(node.word.charAt(i)!=words[j].charAt(i)) {
        				diffrentCnt++;
        				if(diffrentCnt>=2) {
        					break;
        				}
        			}
        		}
        		if(diffrentCnt==1) {
        			boolean[] copyVisitedWords = node.visitedWord.clone();
        			copyVisitedWords[j]=true;
        			queue.add(new Node(copyVisitedWords, node.count+1, words[j]));
        		}
        	}
    	}
    	
        return answer;
    }
}

class Node{
	boolean[] visitedWord;
	int count;
	String word;
	
	public Node(boolean[] visitedWord, int count, String word) {
		this.visitedWord = visitedWord;
		this.count = count;
		this.word = word;
	}
}