import java.text.SimpleDateFormat;
import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) throws Exception{
        String answer = null;
        Queue<Music> answerQ = new LinkedList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        List<String> mList = new ArrayList<>();
        
        //m->mList 변환
        for(int i=m.length()-1; i>=0;i--) {
        	if(m.charAt(i)=='#') {
        		mList.add(m.substring(i-1, i+1));
        		i--;
        	}else {
        		mList.add(m.substring(i,i+1));
        	}
        }
        Collections.reverse(mList);
        for(String musicinfo:musicinfos) {
        	String[] musicinfoSplit =musicinfo.split(","); 
        	long term = (sdf.parse(musicinfoSplit[1]).getTime()-sdf.parse(musicinfoSplit[0]).getTime())/1000/60;
        	String musicName = musicinfoSplit[2];
        	String melody = musicinfoSplit[3];
        	List<String> melodyList = new ArrayList<>();
        	List<String> acboList = new ArrayList<>();
        	
        	//melody-> melodyList 변환
            for(int i=melody.length()-1; i>=0;i--) {
            	if(melody.charAt(i)=='#') {
            		melodyList.add(melody.substring(i-1, i+1));
            		i--;
            	}else {
            		melodyList.add(melody.substring(i,i+1));
            	}
            }
            Collections.reverse(melodyList);
        	
            //melodyList를 이용해 acboList 생성
        	for(int i=0; i<term;i++) {
        		acboList.add(melodyList.get(i%melodyList.size()));
        	}
//        	System.out.println("mList :"+mList);
//        	System.out.println("melodyList :"+melodyList);
//        	System.out.println("acboList :"+acboList);
//        	System.out.println("======================");
        	
        	//acboList에서 mList에 포함하는지 체크
        	for(int i=0; i<=acboList.size()-mList.size();i++) {
        		boolean equal = true;
        		for(int j=0; j<mList.size();j++) {
        			if(!acboList.get(i+j).equals(mList.get(j))) {
        				equal = false;
        				break;
        			}
        		}
        		if(equal) {
        			answerQ.add(new Music(term, musicName));
        		}
        	}
        	
//        	System.out.println("=================");
        }
        
        Music q = null;
        //정답이 있을경우
        if(!answerQ.isEmpty()) {
        	q=answerQ.poll();
        	answer = q.musicName;
        //정답이 없을경우
        }else {
        	return "(None)";
        }

        //정답 Queue중 시간이 긴거 찾기
        while(!answerQ.isEmpty()) {
        	Music ele = answerQ.poll();
        	if(ele.term>q.term) {
        		q = ele;
        		answer = ele.musicName; 
        	}
        }
        
        return answer;
    }
}

class Music{
	long term;
	String musicName;
	
	public Music(long term, String musicName) {
		this.term = term;
		this.musicName = musicName;
	}
}