import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberDAO {
	Scanner sc = new Scanner(System.in);
	//private MemberDTO member[];
	//private int MEMBER_NUM =10;
	
	//private int count; //필요햠
	
	private ArrayList<MemberDTO> list;
	//생성자만들어야함
	public MemberDAO() {
		/*
		//생성자는 한번실행됨, memberdto클래스 배열잡기
		member = new MemberDTO[MEMBER_NUM];//변수만 10개잡힌거임값이있는건아님)
						//정적으로들어가있는 상수의값 대입
		member[0] = new MemberDTO(1001, "홍길동"	, 24, "서울시");
		member[1] = new MemberDTO(1002, "일지매"	, 22, "부산시");
		member[2] = new MemberDTO(1003, "정수동"	, 25, "광주시");
		
		
		count =3;  //lenth = 3이나옴
		*/
		list = new ArrayList<MemberDTO>();
		list.add(new MemberDTO(1001, "홍길동"	, 24, "서울시"));
		list.add(new MemberDTO(1002, "일지매"	, 22, "부산시"));
		list.add(new MemberDTO(1003, "정수동"	, 25, "광주시"));
	}
	
	public void insert() {
		System.out.println("====입력====");
		System.out.print("번호: ");
		int number = sc.nextInt();
		System.out.print("이름: ");
		String name = sc.next();
		System.out.print("나이: ");
		int age = sc.nextInt();
		System.out.print("주소: ");
		String address = sc.next();
		//생성자를통해서 집어넣음
		MemberDTO dto = new MemberDTO(number, name, age, address);
		//멤버배열안에집어넣음
		//member[count] =dto; 필요없음
		//멤버dto배열 한번에선언하기
		//member[count] = new MemberDTO(number, name, age, address);
		
		//count++; 필요없음
		list.add(dto);
	}

	public void delete() {
		int findIndex; //초기화필요없음 리턴값넘어옴
		
		System.out.print("삭제할 이름: ");
		String name = sc.next();
		
		findIndex = search(name);
		
		if(findIndex == -1) {
			System.out.println("회원을 찾을 수 없습니다.");
		}else {
			list.remove(findIndex);
			/*
			//멤버배열에 잇는 파인드인덱스부분의 set 부분 지우기
			member[findIndex].setName("");
			member[findIndex].setNumber(0);
			member[findIndex].setAge(0);
			member[findIndex].setAddress("");
			System.out.println("회원정보를 삭제했습니다.");
			*/
		}
	}

	public void select() {
		int findIndex; //초기화필요없음 리턴값넘어옴
		
		System.out.print("검색할 이름: ");
		String name = sc.next();
		
		findIndex = search(name);
		
		if(findIndex == -1) {
			System.out.println("회원을 찾을 수 없습니다.");
		}else {
			System.out.println("찾은 회원 정보는");
			//System.out.println(member[findIndex].toString());
			System.out.println(list.get(findIndex).toString());
			System.out.println("입니다.");
		}
	}
	 //search는 세군대서 사용할수 있음, 공동코드 search
	public int search(String name) { //String name검색해야할 부분이필요함
		//indextnumber만 찾으면됨
		int indexNum = -1;
		/*
		for (int i = 0; i < member.length; i++) {
			MemberDTO dto = member[i]; //member[i]직접잡아도됨
			if(dto != null && dto.getName().equals("")) {
				if(name.equals(dto.getName())) {
					indexNum = i;
					break;
			}
		}
	}*/
		/*
		int i = 0;
		for (MemberDTO dto : member) { 
	//for ecah문인덱스넘버가넘어오는것이아니라 멤버배열안에 있는것이 하나씩들어옴
			if(dto != null && dto.getName().equals("")) {
				if(name.equals(dto.getName())) {
					indexNum = i;
					break;
				}
			}
			i++;
		}
		return indexNum;
	}
	*/
		for (int i = 0; i < list.size(); i++) {
			MemberDTO dto = list.get(i);
			if(name.equals(dto.getName())) {
				indexNum = i;
				break;
			}
		}
		return indexNum;
	}
	public void update() {
		int findIndex; //초기화필요없음 리턴값넘어옴
		
		System.out.print("수정할 이름: ");
		String name = sc.next();
		
		findIndex = search(name);
		
		if(findIndex == -1) {
			System.out.println("회원을 찾을 수 없습니다.");
		}else {
			System.out.println("수정할 주소입력: ");
			String address = sc.next();
			//member[findIndex].setAddress(address);
			MemberDTO dto = list.get(findIndex);
			dto.setAddress(address); //인스턴스는 관리만인스턴스가하기때문에 이렇게만셋팅하면 리스트안에있는데이터가바뀜
			System.out.println("수정되었습니다.");
		
		}

	}
	
	public void allPrint() {
		for (int i = 0; i < list.size(); i++) {
			MemberDTO dto = list.get(i);
			if(dto != null && !dto.getName().equals("")) {
				System.out.println(dto.toString());
			}
			
		}
		
	}
}