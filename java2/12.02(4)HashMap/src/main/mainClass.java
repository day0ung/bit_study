package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

public class mainClass {
	public static void main(String[] args) {
		/*
		  	HashMap : 사전
		  				사과:apple
		  				key:value ->1쌍(pair)
		  				중복키값을 사용할 수 없다
		  				Web -> Json == hashmap
		 	    //list는 조사할때 index넘버로 함(선형)
		 				tree 구조      0 (2진트리, 뿌리하나에 두개만연결)
		 				         0   0
		 				        0 0 0 0        
		 		TreeMap = HashMap + sorting
		 		          sorting -> key값으로만함
		 				       
		 */
		
		//hashmap == class
		HashMap<Integer, String> hMap = new HashMap<Integer, String>();		
		//이것도 가능
		//Map<Integer, String> hMap = new HashMap<Integer, String>(); 
		
		
		//추가
		hMap.put(111,"백십일"); //111== 백십일 에 대한 key값 0번째가 아님
		hMap.put(222,"이백이십이");
		hMap.put(333, "삼백삼십삼");
		
		//value취득 
		String value = hMap.get(222);
		System.out.println("value = " + value);
		
		// 검색
		//1. 있는지 없는지
		boolean b = hMap.containsKey(new Integer(333));
		System.out.println("b = " + b);
		
		//2. 검색을 통해서 값을취득
		if(hMap.containsKey(333)) {
			value = hMap.get(333);
			System.out.println("value = " + value);
			//value = 삼백삼십삼(출력결과)
		}
		
		//삭제
		String val = hMap.remove(222); 
		//삭제된값을 넘겨주면서 삭제됨, 뭐가 삭제되었는지 확인 할 수 있다.
		System.out.println(val +" 값이 삭제 되었습니다.");
		
		//수정
		/*
		hMap.put(111, "100+10+1"); 
		//put을해도 수정이됨, 중복key값 허용하지 않기 때문에
		*/
		hMap.replace(111, new String( "1+ 10 + 100"));
		value = hMap.get(111);
		System.out.println("value = " +value);
		
		
		// key값을 모두 취득
		// iterator == for each와 똑같음 요소를 갖고 오는것
		Iterator<Integer> it = hMap.keySet().iterator();
		
		while(it.hasNext()) {
			Integer key = it.next(); //key하나만 넘어옴
			System.out.println("key: " +key);
			//출력결과
//			key: 333 순서대로 나오지않음
//			key: 111
			
			//key값을 알면 value값을 알수 있음
			String _val = hMap.get(key);
			System.out.println("value = "+ _val);
		}
		
		
		//-----------
		HashMap<String, String> sMap = new HashMap<String, String>();
		
		//추가
		sMap.put("apple", "사과");
		sMap.put("pear", "배");
		sMap.put("grape", "포도");
		sMap.put("banana","바나나");
		
		//취득
		String _value = sMap.get("grape");
		System.out.println("_value = " + _value);
		
		//모두출력
		Iterator<String> sKey = sMap.keySet().iterator();
		while(sKey.hasNext()) {
			String key = sKey.next();
			
			String sval = sMap.get(key);
			System.out.println("key: "+ key +"|"+ " value: " + sval);
		}
		
		//정렬 숫자, 문자 -> key값만 갖고 정렬함
		//TreeMap <-->HashMap (호환가능) 인스턴스하나만더만들면됨, 
		//기본데이터는 손상이가면안됌,
		
		//똑같은 키값과 벨유로 설정해야함
		TreeMap<String, String> treeMap = new TreeMap<String, String> (sMap);
		
		//오름차순
		//Iterator<String> itkey = treeMap.keySet().iterator(); 
		
		//내림차순
		Iterator<String> itkey = treeMap.descendingKeySet().iterator(); 
		//출력
		while(itkey.hasNext()) {
			String key = itkey.next();
			
			System.out.println("key: " + key + "\tvalue: " + treeMap.get(key));
		}
		
		//map에다가 집어넣을때
		int count = 1;
		ArrayList<String> list = new ArrayList<String>();
		list.add("Tigers");
		list.add("Lions");
		list.add("Twins");
		
		HashMap<Integer, String> mymap = new HashMap<Integer, String>();
		
		//출
		for (int i = 0; i < list.size(); i++) {
			mymap.put(count,list.get(i));
			count++;
		}
		
		//--------------------복습
		HashMap<Integer, MyData> dataMap = new HashMap<Integer, MyData>();
		MyData md1 = new MyData(1, "귤");
		MyData md2 = new MyData(2, "사과");
		MyData md3 = new MyData(3, "배");
		MyData md4 = new MyData(4, "포도");
		MyData md5 = new MyData(5, "수박");
		

		//추가
		dataMap.put(1, md1);
		dataMap.put(2, md2);
		dataMap.put(3, md3);
		dataMap.put(4, md4);
		dataMap.put(5, md5);
		MyData val2 = dataMap.get(1);
		System.out.println("value = " + val2);
		
		//삭제
		MyData val3 = dataMap.remove(2);
		System.out.println(val3);
		
		//검색
		//1. 있는지 없는지
		boolean bool = dataMap.containsKey(3); 
		System.out.println("검색 = " + bool);
		//2. 검색하여 값취득
		if(dataMap.containsKey(3)) {
			MyData val4 = dataMap.get(3);
			System.out.println("value = " + val4);
		}
		
		//수정
		dataMap.replace(1, new MyData(7,"수정"));
		MyData val5 = dataMap.get(1);
		System.out.println("value = " +val5);
		
		//모두출력
		Iterator<Integer> myit = dataMap.keySet().iterator();
		while(myit.hasNext()) {
			Integer ikey = myit.next();
			
			System.out.println("key: " +ikey);
			//출력결과
//			key: 333 순서대로 나오지않음
//			key: 111
			
			//key값을 알면 value값을 알수 있음
			MyData mval = dataMap.get(ikey);
			System.out.println("value = "+ mval);;
		}
		//정렬
		

	}
}
