
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Iterator;

public class mainClass {
	public static void main(String[] args) {
		
	/*
	 *  List: 목록
	 *  
	 *  관리를 유동적으로 할 수 있는 배열
	 *  
	 *  목적: 데이터를 효율적으로 관리하기 위한 목록을 사용
	 *  collection: 수집(데이터)
	 *  	List
	 *  
	 *  	ArrayList(Vector)
	 *  			배열처럼 사용할 수 있는 목록
	 *  			선형구조 0-0-0-0-0
	 *  			검색속도가 빠르다
	 *  			index number 로 관리 0~ (n-1)
	 *  	LinkedList
	 *  			빈번하게 추가,삭제의 작업이 필요한 경우 사용하기적합
	 *  	Map
	 *  		
	 *  	HashMap
	 *  			key and value로 관리  "apple:사과" pair
	 *  							   "apple:능금" >> 사과의값은사라짐
	 *  			xml -> Json key and value
	 *  			key중복을 허용하지 않음
	 *  			tree구조(검색우수)
	 *  	Tree Map
	 *  			soring추가
	 */
		//<>안에는 일반자료형들어갈수없다, 
		//wrapperClass 혹은 class가능
	 ArrayList<Integer> arrlist = new ArrayList<>(); //뒤에 <>는 비워놔도됨
//	 List<Integer> list = new ArrayList<>();
	 
	 //CRUD
	 //====추가(뒤에)====
	 arrlist.add(111); //일반클래스에서는 통용되지않음, 111은 value임,value만 사용하는 것은 wrapper클래스
	 
	 //이게정석임, 일반클래스를할때는 생성해주고넣어야함
	 Integer in = new Integer(222); //생성자에 값을넣어놈
	 arrlist.add(in);
	 
	 arrlist.add(new Integer(333));
	 
	 //list size(리스트 크기)
	 int len = arrlist.size(); //size 라는 함수, 배열에서는 length, 리스트에서는 size
	 System.out.println("list의 크기:" + len); 
	 //출력결과: 3, 첫번째 111, 두번째 222, 세번쨰333  이기때문
	 
	 //산출(데이터를 꺼낼떄)
	 Integer out = arrlist.get(0); //배열의 arrlist[0] 와 동일
	 System.out.println(out);
	 
	 for (int i = 0; i < arrlist.size(); i++) { //
		Integer var = arrlist.get(i); //i의 값부터 얻어와라
		System.out.println("arrlist["+i+"] =" +var);
	 }
	 
	 for (Integer i : arrlist) { //arrlist부분에 배열이들어갈수도있고, list도들어갈수 잇다
		//value가 나오는것임 , index넘버가아님
		 System.out.println(i);
	}
	 
	 //원하는 위치에 추가하기
	 Integer num = new Integer(123);
	 
	 //0번째와 1번째 사이에 넣고싶다 add(index, element);
	 arrlist.add(1, num); //1번째, element요소(123)
	 
	 //확인용
	 for (int i = 0; i < arrlist.size(); i++) { //
			Integer var = arrlist.get(i); //i의 값부터 얻어와라
			System.out.println("arrlist["+i+"] =" +var);
		 }
	 
	 //===삭제===
	 arrlist.remove(2); //index 2번째 삭제, (222)
	 
	//확인용
		 for (int i = 0; i < arrlist.size(); i++) { //
				Integer var = arrlist.get(i); //i의 값부터 얻어와라
				System.out.println("arrlist["+i+"] =" +var);
			 }
		 //----출력결과---
		 //arrlist[0] =111
		 //arrlist[1] =123
		// arrlist[2] =333
	 
	 
	 //===검색=== (인덱스로찾을수도있고, 벨유로도 찾을수도있다.
	 //오브젝트로 찾는방법(
		 int findIndex = arrlist.indexOf(333); //indexOf앞에서부터찾아서 인덱스넘버를 리턴해줌 object = 111을 취급하고잇음
		 System.out.println("findIndex: " +findIndex);
	 
	// 찾는방법 2, 원래는이걸더많이씀
		 findIndex = -1;
		 for (int i = 0; i < arrlist.size(); i++) {
			Integer var = arrlist.get(i);
			if(var == 123) {
				findIndex = i;
				break;
			}
		}
		 System.out.println("findIndex: "+ findIndex);
	
		 
		 //====수정====
		 Integer updateData = new Integer(555);
		 arrlist.set(2, updateData);
		 
		 for (Integer i : arrlist) {
			System.out.println(i);
		}
		 //출력결과>> 333이 555로바뀜
		 
		 
		 
		 //-------복습--------
		 //String
		 /*
		  * 야구팀 String으로 추가 삭제하기, 
		  */
		 
		 
		 ArrayList<String> baseball = new ArrayList<String>();
		 //추가
		 String name = new String("내마음");
		 baseball.add(name);
		 
		 String name2 = new String("책임져");
		 baseball.add(name2);
		 
		 String name3 = new String("빼빼로");
		 baseball.add(name3);
		 
		 for (int i = 0; i < baseball.size(); i++) {
			String var = baseball.get(i);
			System.out.println(i +var);
		 }
		//삭제
	
		
		//===================
		ArrayList<String> strlist = new ArrayList<String>();
		
		
		//추가---
		//뒤에
		ArrayList<MemberDTO> memlist = new ArrayList<MemberDTO>();
		MemberDTO dto = new MemberDTO(101, "홍길동");
		memlist.add(dto);
		
		memlist.add(new MemberDTO(102,"일지매"));
		
		memlist.add(new MemberDTO( 1011,"김영숙"));
		
		memlist.add(new MemberDTO( 1021,"김영숙"));
		
		//dto = new MemberDTO(); 중복됨????
		//리스트에 집어넣을때는 생성하고 집어넣어야함
		dto.setNumber(103);
		dto.setName("정수동");
		memlist.add(dto);
		/*
		//출력
		for (MemberDTO mem : memlist) {
			System.out.println(mem.toString());
		}
		
		for (int j = 0; j < memlist.size(); j++) {
			MemberDTO d = memlist.get(j);
			//출력
			System.out.println(d.toString());
		}
		*/
		
		//원하는 위치에
		dto = new MemberDTO(1021, "성춘향");
		memlist.add(2, dto);
		
		/*데이터 출력
		for (int j = 0; j < memlist.size(); j++) {
			MemberDTO d = memlist.get(j);
			//출력
			System.out.println(d.toString());
		}
		*/
		
		//----삭제
		//index넘버를 통해서 삭제가능
		memlist.remove(1);
		
		for (int j = 0; j < memlist.size(); j++) {
			MemberDTO d = memlist.get(j);
			//출력
			System.out.println(d.toString());
		}
		
		
		//----검색(검색은 for문을 돌려야함
		String findname = "정수동";
		int indexNumber = -1;
		
		for (int j = 0; j < memlist.size(); j++) {
			MemberDTO mem = memlist.get(j);//데이터 꺼내기 위함
			if(mem.getName().equals(findname)) {
				indexNumber = j;
				break;
			}
		}
		
		System.out.println("찾은데이터:"+ memlist.get(indexNumber).toString());
		
		//다수의데이터 
		//담아놓는곳(배열에다 담아놓음)갯수를 카운트(세기위해서 for문돌림)
		//배열 동적할당(갯수에맞춰서 잡아주기위해서 for문, 이게싫으면 리스트를돌리면됨)
		//찾아서데이터를 넣어준다
		
		ArrayList<MemberDTO> findDataList = new ArrayList<MemberDTO>();
		
		for (int j = 0; j < memlist.size(); j++) {
			MemberDTO d = memlist.get(j);
			if(d.getName().equals("김영숙")) {
				//찾은거임, 이것들이 리스트에 쌓임
				findDataList.add(d);
			}
		}
		
		for (int j = 0; j < findDataList.size(); j++) {
			MemberDTO d = findDataList.get(j);
			System.out.println("찾은 데이터:"+ d.toString());
		}
		
		
		//----수정
		MemberDTO updateDto = new MemberDTO(2022, "향단이");
		
		memlist.set(2, updateDto);
		
		for (MemberDTO mem : memlist) {
			System.out.println(mem.toString());
		}
		}
	}

