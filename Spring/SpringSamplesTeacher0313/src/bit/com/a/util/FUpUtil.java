package bit.com.a.util;

import java.util.Date;

public class FUpUtil {
	//myfile.txt => f.indexOf('.') -> 6
	//파일명, 확장자명을 꺼내야함
	//f.substring( 6 ) -> .txt : 확장자명을 뽑은것
	//f.substring(0, 6) -> myfile: 파일명 뽑은것
	
	//파일명은 충돌이날수있음 그렇지않게하기위해, time으로 바꿈
	// myfile-> 23423423.txt
	public static String getNewFileName(String f) {
		String filename=""; //완성된파일네임으로 나가기 위한 변수
		String fpost=""; //위치에 따라서 파일명을 가지고 올 수 있는 것
		
		if(f.indexOf('.') >= 0) { //파일 확장자명이 존재함
			fpost = f.substring(f.indexOf('.')); //.txt
			filename =  new Date().getTime() + fpost; //시간타임 2342340.txt
		}else { //확장자명이 없음
			filename = new Date().getTime() + ".back";
		}
		return filename;
	}
}
