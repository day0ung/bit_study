package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dto.StudentDTO;
import file.DataFile;

public class StudentDAO {
	List<StudentDTO> list;
	Scanner sc = new Scanner(System.in);
	DataFile df;
	
	public StudentDAO() { //데이터 넣기
		list = new ArrayList<StudentDTO>();
		df = new DataFile("student");
		//파일불러들이기
		loadData();
		
//		list.add(new StudentDTO("홍길동", 24, 90, 85 ));
//		list.add(new StudentDTO("일지매", 22, 85, 100 ));
//		list.add(new StudentDTO("정수동", 25, 95, 100 ));
		
	}
	
	public void insert() {
		StudentDTO dto = new StudentDTO(); //먼저생성하고 값을 집어넣는 방식
		
		System.out.print("이름:");
		dto.setName(sc.next());
		
		//위랑 똑같음
//		String name = sc.next();
//		dto.setName(name);
		System.out.print("나이:");
		dto.setAge(sc.nextInt());
		
		System.out.print("영어:");
		dto.setEng(sc.nextInt());
		
		System.out.print("수학:");
		dto.setMath(sc.nextInt());
		
		list.add(dto);
	}
	
	public void delete() {
		System.out.print("이름: ");
		String name = sc.next();
		int findnum = search(name);
		if(findnum ==-1) {
			System.out.println("데이터를 찾을 수 없습니다.");
		}else {
			list.remove(findnum);
			System.out.println("데이터를 삭제하였습니다.");
		}
	}
	
	public void select() {
		
	}
	
	public void update() {
		
	}
	
	public int search(String name) {
		int index = -1; //서치니깐 리턴
		for (int i = 0; i < list.size(); i++) {
			if(name.equals(list.get(i).getName())) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	public void selectOne() {
		
	}
	
	public void allGrade() {
		
	}
	
	public void allAvg() {
		
		
	}
	
	public void gardeSort() {
		
	}
	
	public void allStudents() {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
	}
	
	public void saveData() {
		//file에 데이터를 넣기 편하게 하기위해서	filewriter	
		/*
		 * 이름 -나이-영어-수학 (토큰을이용하면 자동적으로 짤라서씀)
		 */
		
		String [] datas = new String[list.size()]; 
		//dto에 toString 이용하기전		
		for (int i = 0; i < list.size(); i++) {
			//데이터하나하나 넣기
			StudentDTO dto = list.get(i);
			datas[i] =dto.getName() +"-" + dto.getAge() +"-" +dto.getEng()
			+"-" +dto.getMath();
		}
		df.writeFile(datas);
	}
	
	public void loadData() {
		//통째로 들어옴
		String datas[] = df.readFile();
		for (int i = 0; i < datas.length; i++) {
			
		
		String split[] = datas[i].split("-"); 
		StudentDTO dto = new StudentDTO(split[0], 
										Integer.parseInt(split[1]), //원래 age
										Integer.parseInt(split[2]), //원래 eng
										Integer.parseInt(split[3])); //원래 math
		list.add(dto);	
		}
	}
}
