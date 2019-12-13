package main;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class mainClass {

	public static void main(String[] args) {
		/*
		  ArrayList : 검색에 우수함  == Vector
		  LinkedList : 추가, 삭제 (실시간) 에 우수함
		  
		 */
		
		//C++에서 온것 어레이리스트랑 똑같음 벡터(방향)
		Vector<String> ve = new Vector<String>();
		ve.add("라이온즈");
		ve.size();
		
		//LinkedList ==class소속
		LinkedList<String> list = new LinkedList<String>();
		
		//list == collection(인터페이스)소속
		//List<String> list = new LinkedList<String>();
		
		if(list.isEmpty()) {
			System.out.println("데이터가 하나도 없습니다.");
		}
		
		list.add("Tigers");
		list.add("Giants");
		list.add(1, "Lions");
		
		//출력하고싶을때
		for (int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			System.out.println(s.toString());
		}
		
		//맨 처음 요소에 추가하는 부분(어레이스트에는 없음)
		list.addFirst("Bears");
		//맨 끝 요소에 추가
		list.addLast("Twins");
		
		//출력
		for (String string : list) { //리스트안에있는 것을 하나하나꺼냄
			System.out.println(string);
		}
		
		//iterator : 반복자 == 포인터요소(주소를접근)
		Iterator<String> it; //String s;와 동일함
		
		it = list.iterator(); //bears에 들어가있는 주소가 들어감
		
		//출력for문으로 돌릴수 있고, while 도가능
		while(it.hasNext()) { //hasNext() 처음부터시작해서 다음것을 가지고 있느냐?라는뜻(비었는지 있는지)
			String string  = it.next(); 
			//실제값은 next가 가지고있음, 데이터를 넘겨주면서 그다음포인터(주소)로이동
			System.out.println("it: "+string);
		}
		
		ArrayList<String> arrlist = new ArrayList<String>( list ); //()부분에 linkedlist를넘겨줌
		
		//다넘어왔나 확인 출력
		for (int i = 0; i < arrlist.size(); i++) {
			System.out.println(arrlist.get(i));
		}
		
		// linkedlist == 포인터가이동하지않고 고정
		//검색을할때는  linkedlist로 넘겨줌
		
	}

}
