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

import dto.Batter;
import dto.Human;
import dto.Pitcher;

public class DataClass { 
	private File file;
	
    public DataClass(String filename) {
		file = new File("d:\\tmp\\" + filename + ".txt");
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
    
    public void writeFile(String data[]) {	//맵은 여기까지 끌고올필요가없음
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

			for (int i = 0; i < data.length; i++) {
				pw.println(data[i]);
			}
			pw.close();
    	
    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
		System.out.println("파일에 성공적으로 기입하였습니다");
	}
    
    public HashMap<String, Human> readFile() { //리턴을 해쉬맵으로함
    	//다오의 파일불러오는부분 생성을 여기서함, 받는것은 다오의 멤버변수에서 받음
    	HashMap<String, Human> map = new HashMap<String, Human>();
    	
    	//read파일은 파일이 있느냐 없느냐 확인해야함 ->
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
						map.put(human.getName(), human);
					}
			
			} else { // ->검사실패
				System.out.println("파일이 없거나 읽을 수 없습니다.");

			}
    	} catch (Exception e) {
    		//익셉션 두개하기 싫을때 그냥 exception만 남겨주면됨
    		e.printStackTrace();
    	}
		return map;
		
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
