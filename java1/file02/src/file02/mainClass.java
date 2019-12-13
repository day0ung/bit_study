package file02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

//파일의 목적, 파일생성, 기입, 불러오기
public class mainClass {
	public static void main(String[] args)throws Exception {
		//file read
		
		File file = new File("d:\\tmp\\newfile.txt"); //파일갖고오는것
		
		FileReader fr = new FileReader(file); 
		//new FileReader(file);익셉션걸림 main메소드에 throws Exception이거해줘도되고 try/catch해도됨
		/*
		//방법1. 한문자씩 읽어들인다.
		
		int c = fr.read();
		while(c != -1) {//while(c != -1은 파일 끝부분) c가 -1때까지 읽어라
			System.out.println((char)c);
			c = fr.read(); //파일 끝부분까지 C를 갱신해주면서 가는것임(그다음라인으로보냄)
		}
		*/
		
		// 위의코드와 동일한 처리
		/*
		int c;
		while((c = fr.read()) != -1) {// (c = fr.read()) != -1조건이 참인지 확인하면서 반복
			System.out.println((char)c);

		}
		*/
		
		//Buffer == 저장공간
		BufferedReader br = new BufferedReader(fr);
		
		String str = br.readLine();
		while(str != null) { //while(str != null) str이 null이 아닐때까지 읽어라
			System.out.println( str);
			str = br.readLine();
		}
		br.close(); //buffer는 항상 close해줘야함
		
		/*
		//위으코드와동일함
		String str;
		while((str = br.readLine()) != null) { //while(str != null) str이 null이 아닐때까지 읽어라
			System.out.println( str);
			str = br.readLine();
		}
		br.close();
		*/
	}
	
}
