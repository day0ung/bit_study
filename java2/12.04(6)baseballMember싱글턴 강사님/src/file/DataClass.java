package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;

import dto.Batter;
import dto.Human;
import dto.Pitcher;
import single.Singleton;

public class DataClass { 
	private File file;
	
    public DataClass(String filename) {
		file = new File("d:\\tmp\\" + filename + ".txt");
	
		createFile();
	}
    
    public void createFile() {
		try {
			if(file.createNewFile()) {
				System.out.println("파일생성 성공");
			}else {
			System.out.println("파일생성 실패");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    public void writeFile() {	//맵은 여기까지 끌고올필요가없음, String data는 싱글턴의 맵에 있음
		Singleton s = Singleton.getInstance();
    	try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			
			//맵에서 꺼내줄땐 iterator
			/*
			for (int i = 0; i < data.length; i++) {
				pw.println(data[i]);
			}
			*/
			Iterator<String> it = s.map.keySet().iterator();
			while(it.hasNext()) {
				String key = it.next();
				Human h = s.map.get(key);
				pw.println(h.toString());
			}
			pw.close();
    	
    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
		System.out.println("파일에 성공적으로 기입하였습니다");
	}
    
    public void readFile() { //해쉬맵 리턴으로 넘겨줄 필요없음
    	
    	Singleton s = Singleton.getInstance();
    	try {
    	if(checkbeforeReadFile(file)) { // ->검사에 성공했을때
    	
				BufferedReader br = new BufferedReader(new FileReader(file));
				String str = "";
				Human human = null;
				
					while((str = br.readLine()) != null) {
						String split[] = str.split("-"); //휴먼데이터가 스트링으로넘어온것임(한줄)
						
						//투수
						if(Integer.parseInt(split[0]) < 2000) {
							human = new Pitcher(Integer.parseInt(split[0]),//number, 
									  			split[1],//name, 
									  			Integer.parseInt(split[2]),//age, 
									  			Double.parseDouble(split[3]),//height, 
									  			Integer.parseInt(split[4]),//win, 
									  			Integer.parseInt(split[5]),//lose, 
									  			Double.parseDouble(split[6]));//defence)
						}
						//타자
						else {
							human = new Batter(Integer.parseInt(split[0]),//number,
												split[1],//name, 
												Integer.parseInt(split[2]),//age,
												Double.parseDouble(split[3]),//height, 
												Integer.parseInt(split[4]),//batcount, 
												Integer.parseInt(split[5]),//hit, 
												Double.parseDouble(split[6]));//hitAvg)
						}
						s.map.put(human.getName(), human);
					}
			
			} else { // ->검사실패
				System.out.println("파일이 없거나 읽을 수 없습니다.");

			}
    	} catch (Exception e) {
    		//익셉션 두개하기 싫을때 그냥 exception만 남겨주면됨
    		e.printStackTrace();
    	}		
    	
		if(s.map.size()>0) {
			
			Iterator<String> it = s.map.keySet().iterator(); //파일을불러와서 맵에다집어넣음 제일마지막번호를뽑아야함
			//주의사항(어떤건 1000번부터시작하고, 2000부터시작하고 다름)
			
			int lastNum = 0; //초기화
			while(it.hasNext()) {
				//이걸써주는 목적: 맨마지막번호1002번을 얻어오기 위함 
				String key = it.next();
				Human h = s.map.get(key); //휴먼데이터를뽑은것
				//이것리스트가 아니기때문에 마지막번호가 몇번인지 비교로 뽑으면됨
				
				int lastMemNum = h.getNumber();
				if(lastMemNum >= 2000) {//2000이상의 경우 -1000을해준다
					lastMemNum = lastMemNum -1000;
				}
				
				if(lastNum <lastMemNum) { //제일컷을때 데이터가들어감
					lastNum = lastMemNum;
				}
				
			}
			
			s.MemNumber = lastNum +1;
			
		}
	}
    
    //파일이 있으며 읽을 수 있는 파일인지 확인용 메소드
    public boolean checkbeforeReadFile(File f) {
		if(f.exists()) { //파일이 있냐 없냐
			
			if(f.isFile() && f.canRead()) { //파일이 맞니? && 읽을 수 있니
				return true;
			}
		}
		return false;
	}
}
