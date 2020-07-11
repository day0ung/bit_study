package es;

public class Student {
	private int number;
	private String name;
	
	
	
	/*
	 * this 참조
	 * 자기 객체가 저장되어 있는 heap영역의 주소
	 */
	
	public Student() {
		this.number = 123; //this.이거 정석임
	}
	
	public Student getThis() {//Student Class를 리턴값으로 잡음
		return this;
	}
	
	public void setNumber(int number) {
		this.number = number;
	//멤버변수 number,  파라미터 number  //this는 자기자신 객체가들어가는 힙영역의 주소값
	}
	
	/*
	    *    this 참조
	    *    자기 객체가 저장되어 있는 heap영역의 주소
	    */
	   
	   
	    
	   public Student() {
	      // this.number = 123;  원래는 아래말고 이거임
	      number = 123;
	   }
	   
	   public Student getThis() {
	      return this;
	   }
	   
	   public void setNumber(int number) {
	      this.number = number;
	      //  멤버변수 number = 파라미터 number
	      // this는 자기자신 객체가 들어가는 힙영역의 주소값
	   }
	   
	   public String getName() {
	      return name;
	   }

	   public void setName(String name) {
	      this.name = name;
	   }
	   
	   
	

}

