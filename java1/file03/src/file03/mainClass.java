package file03;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class mainClass {
	public static void main(String[] args) throws Exception {
		//파일쓰기
		File file = new File("d:\\tmp\\newfile.txt");
		
		
		//쓰기(한문자)
		/*
		FileWriter fw = new FileWriter(file);
		fw.write("하이하이"+"\n");
		fw.close(); //->이거하지않으면 기입이안됨 
		//여기서 만든파일은 utf이기 때문에 read에서 불러온 txt는 깨지지않음
		*/
		
		//추가쓰기
		/*
		FileWriter fappend = new FileWriter(file, true); //(file, append) append부분을 true로 defalut값은 false
		fappend.write("건강하세요" + "\n"); //건강하세요건강하세요 개행\n을 하지않았을때는 옆에 쓰임
		fappend.close();
		*/
		
		//문장으로 기입하기
		if(checkBeforeWriteFile(file)) {
			FileWriter fWriter = new FileWriter(file); //파일의 writer부분을 사용하기위함 기입(파일 포인터의 설정)
			BufferedWriter bw = new BufferedWriter(fWriter); // 문장으로 모아주는 부분
			PrintWriter pw = new PrintWriter(bw); 
			
			pw.print("안녕하세요" + "\n");
			pw.println("하이"); //하이해주고나서 개행
			pw.println("건강하세요");
			
			pw.close();
			//----메모장.txt출력결과
//			안녕하세요
//			하이
//			건강하세요

			
		}
		else {
			System.out.println("파일이 없거나 쓰기를 할수 없습니다.");
		}
		
	}
	
	static boolean checkBeforeWriteFile(File f) { //파일을 검사하는 함수
		if(f.exists()) {// 파일이 존재하느냐
			if(f.isFile() && f.canWrite()) { // 파일맞는지 && 파일에 쓰기를 할수 있는지
				return true;
			}
		}
		return false;
	}

}
