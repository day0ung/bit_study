package constructor;

public class mainClass {
	public static void main(String[] args) {
		/* 
		 *   				structure[참고]c언어
		 *   				struct AAA{
		 *   					int i;  0번째에 int
		 *   					char c; 1 
		 *   				}
		 *   
		 *   				AAA = aaa{1,'A'};
		 *   constructor: 생성자
		 *   			    함수(메소드)
		 *   			  class명과 같은 method
		 *   			  return 값이 없다.
		 *   			  Over Loading이 가능
		 *   			    자동호출(클래스생성시)
		 *   			    별도의 호출이 불가능하다(1회)
		 *   			    생략이 가능하다	
		 *   			    초기값 설정에 많이사용
		 *   destructor : 소멸자( c++)
		 *   				자동호출
		 *   				java에는 없음
		 *   
		 *   this 참조  
		 */
		MyClass cls = new MyClass(); //출력결과 MyClass MyClass() >>new생성자가 ()에서 호출함
		cls.setNumber(135.4f); //생성자를만들고 나중에 메소드 값을 집어넣는것도 가능하고
		MyClass cls1 = new MyClass(12);
		
		MyClass cls2 = new MyClass(12.3F);//생성자안에 미리 만들어놓는것도가능
		
		float f = cls2.getNumber();
		System.out.println("f = "+ f);
		
		//----------------studentClass확인
		Student stu = new Student();
		System.out.println(stu); //출력결과 15db9742 --주소값
		System.out.println(stu.getThis()); //출력결과 15db9742 --주소값 / 자기자신이 갖고있는 영역
		
	}

}
