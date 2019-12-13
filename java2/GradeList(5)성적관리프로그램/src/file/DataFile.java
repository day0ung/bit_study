package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DataFile {
	
	private String fileName;
	private File file;
	
	public DataFile(String fileName) { //우리가 지정하려고
		this.fileName = fileName;
		file = new File("d:\\tmp\\" + fileName +".txt");
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
	
	public void writeFile(String[] datas) { //접근은 dao에서 해야함, 파일기입하고 불러오는것은  string 으로 되어있음
		try {
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
		//데이터 집어넣는 부분
		for (int i = 0; i < datas.length; i++) {
			pw.println(datas[i]);
		}
		pw.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String[] readFile() {  //file에서 읽어서 내보내 주어야함 return필요 
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			//데이터갯수를 카운터
			String str;
			String arrStr[] = null;
			int count = 0;
			// 데이터를 읽고 기입해야함
			try {
				while ((str = br.readLine()) != null) { // 카운트의 갯수를 읽어들일려고
					count++;
				}
				br.close();

				arrStr = new String[count];

				br = new BufferedReader(new FileReader(file)); // 메모장맨앞 으로 초기화해주는것
				int w = 0;
				while ((str = br.readLine()) != null) {
					arrStr[w] = str;
					w++;
				}
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrStr;
	}
}
