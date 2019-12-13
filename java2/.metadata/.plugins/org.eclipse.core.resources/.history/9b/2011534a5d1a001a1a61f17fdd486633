package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterWriter;
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
				
		createfile();
	}
	
	public void createfile() {
		try {
			if(file.createNewFile()) {		
				System.out.println("파일 생성 성공!");
			}else{			
				System.out.println("파일 생성 실패");
			}
		} catch (IOException e) {			 
			e.printStackTrace();
		}
	}

	public void writeFile() {
		
		Singleton s = Singleton.getInstance();
		
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			/*
			for (int i = 0; i < data.length; i++) {
				pw.println(data[i]);
			}
			*/
			Iterator<String> it = s.map.keySet().iterator();
			while (it.hasNext()) {
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
	
	public void readFile() {
		Singleton s = Singleton.getInstance();
		
		try {
			if(checkBeforeReadFile(file)) {			
				BufferedReader br = new BufferedReader(new FileReader(file));
			
				String str = "";
				Human human = null;
								
				while((str = br.readLine()) != null) {
						
					String split[] = str.split("-");
					
					// 투수
					if(Integer.parseInt(split[0]) < 2000) {
						human = new Pitcher(Integer.parseInt(split[0]), 
											split[1], 
											Integer.parseInt(split[2]), 
											Double.parseDouble(split[3]), 
											Integer.parseInt(split[4]), 
											Integer.parseInt(split[5]), 
											Double.parseDouble(split[6]));
					}
					// 타자
					else {
						human = new Batter(Integer.parseInt(split[0]), 
										split[1], 
										Integer.parseInt(split[2]), 
										Double.parseDouble(split[3]), 
										Integer.parseInt(split[4]), 
										Integer.parseInt(split[5]), 
										Double.parseDouble(split[6]));
					}					
					s.map.put(human.getName(), human);
				} 		
			
			}else {
				System.out.println("파일이 없거나 읽을 수 없습니다");
			}
		} catch (Exception e) {			
			e.printStackTrace();
		} 	
		
				
		if(s.map.size() > 0) {
			
			Iterator<String> it = s.map.keySet().iterator();
			
			int lastNum = 0;
			while(it.hasNext()) {
				String key = it.next();
				Human h = s.map.get(key);
				
				int lastMemNum = h.getNumber();
				
				if(lastMemNum >= 2000) {	// 2000이상의 경우 -1000을 해준다
					lastMemNum = lastMemNum - 1000;
				}
				
				if(lastNum < lastMemNum) {
					lastNum = lastMemNum;
				}
			}
			s.MemNumber = lastNum + 1;	
			System.out.println("s.MemNumber:" + s.MemNumber);
		}
		
		
	}
	
	// 파일이 있으며 읽을 수 있는 파일인지 확인용 메소드
	public boolean checkBeforeReadFile(File f) {
		if(f.exists()) {			
			if(f.isFile() && f.canRead()) {
				return true;				
			}
		}
		return false;
	}
	
	
}



