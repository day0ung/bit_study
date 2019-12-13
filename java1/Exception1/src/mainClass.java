import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class mainClass {
	public static void main(String[] args) {
		//Exception
		
		//NullpointerException 빈도수높음
		String str = null;
		
		try {
		System.out.println(str.length());
		}catch(NullPointerException e) {
			System.out.println("str이 할당되지 않았습니다.");
		}
		
		//ArrayIndexOutOfBoundsException 빈도수높음
		int arr[] = {2, 4, 6};
		
		try {
		System.out.println(arr[3]);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("index 범위 초과");
		}
		
		//FilNotFound
		//File >> java.io 소속
		File file = new File("c: \\xxxx.txt");
		FileInputStream is; //파일의 흐름을 가져올수 있는것 파일을 읽어주기 위해서
		try {
			is = new FileInputStream(file);
		}catch(FileNotFoundException e) {
	//		System.out.println("파일을 찾을 수 없습니다.");
			
		}
		
		//NumberFormatException 빈도수높음
		int num;
		try {
			num = Integer.parseInt("123.456"); 
		}catch (NumberFormatException e) {
			System.out.println("형식이 다릅니다.");
		}
		
		//StringIndexOutOfBoundsException
		String str1 = "abc";
		try {			
			str1.charAt(3);
		}catch (StringIndexOutOfBoundsException e) {
			System.out.println("String Index 범위를 초과하였습니다");
		}
		
		//그냥 exception만 써도됨
	}
}
