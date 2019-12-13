import java.io.File;
import java.io.IOException;

public class mainClass {
	public static void main(String[] args) {
		/*
		 * file은 기능이다. 머리로하는게아님.
		 * 
		 * 	기능부분    : file, upload (블로그정리하면좋음)
		 * 	logic부분: 직접구현DAO, DTO, Mode1
		 * 
		 *  window -> 파일로이루어져있음 
		 *  		  *.lib    	     	*.dll
		 *    		  libaray  	 	  (dynamic ling library)
		 *    			정적		 	         동적
		 *    		메모리에잡혀있음(보안)  필요할때마다 읽음  		
		 *    		   *.jar
		 *  
		 *  저장매체 -> 데이터 -> file, Database(file)
		 *  				 이름   나이    주소 >> 항목(열colum)
		 *  				홍길동  24   서울시  -> low이거만 뽑아내는 데이터 parsing
		 *  												     parser -> 파싱하는 프로그램	 
		 *  
		 *    *.txt (모든파일의 조상)
		 *    파일(Database)출력의 목적: 데이터관리, 저장, 유지
		 *    						CURD
		 *    						추가(insert), 삭제(delete), 읽기(read), 쓰기(write)
		 *    						검색(search, select), 수정(update), 
		 *    제일중요한항목(읽기read, 쓰기 wrtie)
		 */		
		
		
		//--------파일 목록(파일검색)---------
		File fdir = new File("c:\\");
		/*
		String filelist[] = fdir.list(); //String으로 받음
		for (int i = 0; i < filelist.length; i++) {
			System.out.println(filelist[i]); 
			//c드라이브에 있는 파일들  swapfile.sys>>감춰진파일
		}
		*/
		
		File filelist[] = fdir.listFiles(); //file이 배열로넘어옴, 파일이냐 폴더냐 구분
		for (int i = 0; i < filelist.length; i++) {
			if(filelist[i].isFile()) { //isFile() boolean형 isFile() ->파일이냐 아니냐
				System.out.println("[파일]"+ filelist[i].getName()); //.getName() String으로 넘어옴
			}
			else if(filelist[i].isDirectory()) {// isDirectory() >>폴더
				System.out.println("[폴더]"+ filelist[i].getName());
			}
			else {
				System.out.println("[?]"+ filelist[i].getName());
			}
		}
		
		//-------------파일생성----createNewFile----------
		String fileStr = "d:\\tmp\\newfile.txt";
		File newFile = new File(fileStr); //파일 포인터만생성되는 부분
		
	
		try {
			if (newFile.createNewFile()) {
				// newFile.createNewFile();에러남 createNewFile() >> boolean 형, 조건잡아줘야함
				// 에러나는곳 클릭하면 surrounded try/catch사용하면됨
				System.out.println("파일생성성공");
			} else {
				System.out.println("파일생성실패");

			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		//--------폴더생성(directory작업공간생성)--mkdirs()----
		String dirStr = "d:/tmp1/sub"; // >> "d:\\tmp1\\sub"; 원래는이거 "d:/tmp1/sub"; 가능 외부에서 폴더지우고나서
		
		File newDir = new File(dirStr);
		
		if(newDir.mkdirs()) {
			System.out.println("폴더생성 성공");
		}else {
			System.out.println("폴더생성 실패");
		}
		//폴더안에 폴더를만들고싶을때 mkdirs() 사용
		//폴더만들때  mkdir()사용
		
		String filename = "newfile1" +".txt"; //확장자설정 +".txt";
		File myfile = new File(dirStr +"\\" + filename);
		
		try {
			if(myfile.createNewFile()) {
				System.out.println(filename+"파일생성 성공");
			}else {
				System.out.println(filename+ "파일생성 실패");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//------파일존재여부---exists()----
		if(myfile.exists()) {
			System.out.println("파일이 존재합니다.");
		}else {
			System.out.println("파일이 존재하지않습니다.");
		}
		
		//--------파일 삭제---.delete()------
		/*
		if(myfile.delete()) {
			System.out.println("파일을 삭제했습니다.");
		}else {
			System.out.println("파일을 삭제하지 못했습니다.");
		}
		*/
		
		//myfile.setReadOnly(); //-> 쓰기가 불가능함
		
		//------읽기, 쓰기 가능여부---.canRead(), canWrite()---
		if(myfile.canRead()) {
			System.out.println("파일 읽기가 가능합니다.");
		}else {
			System.out.println("파일 읽기가 불가능합니다.");
		}
		
		if(myfile.canWrite()) {
			System.out.println("파일 쓰기가 가능합니다.");
		}else {
			System.out.println("파일 쓰기가 불가능합니다.");
		}
		
		
		
	}

}