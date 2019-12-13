import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<MemberDTO> memlist = new ArrayList<MemberDTO>();
		MemberDTO dto = new MemberDTO(01,"롯데", 11, "빼빼로");
		memlist.add(dto);
		memlist.add(new MemberDTO(02, "삼성", 22, "갤럭시"));
		memlist.add(new MemberDTO(03, "엘지", 22, "유플러스"));
		
		System.out.println("====입력====");
		System.out.print("번호: ");
		int number = sc.nextInt();
		System.out.print("이름: ");
		String name = sc.next();
		System.out.print("나이: ");
		int age = sc.nextInt();
		System.out.print("주소: ");
		String address = sc.next();		
		memlist.add(new MemberDTO(number, name,age,address));
		
		for (int i = 0; i < memlist.size(); i++) {
			MemberDTO d= memlist.get(i);
			System.out.println(d.toString());
		}
		
	}

}
