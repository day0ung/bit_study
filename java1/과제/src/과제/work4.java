package 과제;
//메소드명 : isNumber
//기 능 : 주어진 문자열이 모두 숫자로만 이루어져있는지 확인한다.
//모두 숫자로만 이루어져 있으면 true를 반환하고,
//그렇지 않으면 false를 반홖한다.
//만일 주어진 문자열이 null이거나 빈 문자열“”이라면 false를 반홖한다.
//반환타입 : boolean
//매개변수 : String str - 검사할 문자열
//
//[Hint] String클래스의 charAt(int i)메소드를 사용하면 문자열의 i번째 위치한 문자를
//얻을 수 있다.
public class work4 {

	public static void main(String[] args) {

		String str = "123";
		System.out.println(str+"는 숫자입니까? "+isNumber(str));
		str = "1234o";
		System.out.println(str+"는 숫자입니까? "+isNumber(str));

		}
	
	/*
	(1) isNumber메소드를 작성하시오.
	*/
	static boolean isNumber(String num) {
	//	boolean b = true;
		
		for (int i = 0; i < num.length(); i++) { //한글자씩 빼기위한작업
			int n = (int)num.charAt(i);
			if(n < 48 || n >57) { //n < 48 || n >57 ascii코드
			//	b = false;
			//	break;
				return false;
			}			
		}
	//	return b;
		return true;
	}
}
