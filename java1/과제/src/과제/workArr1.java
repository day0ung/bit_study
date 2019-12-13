package 과제;
//다음은 알파벳과 숫자를 아래에 주어진 암호표로 암호화하는 프로그램이다.
//(1)에 알맞은 코드를 넣어서 완성하시오.
//
//a b c d e f g h i j k l m n o p q r s t u v w x y z
//` ~ ! @ # $ % ^ & * ( ) - _ + = | [ ] { } ; : , . /
//
//0 1 2 3 4 5 6 7 8 9
//q w e r t y u i o p
//암호화/복호화 함수를 제작하라.
public class workArr1 {

	public static void main(String[] args) {
		String src = "abc012";
		String secuCode = "";
		
		secuCode = security(src);
		
		System.out.println("원본: " +src);
		
		System.out.println("암호화 :" +secuCode);
		
		String oriCode = "";
	
		
		oriCode = deciphering(secuCode);
		
		System.out.println("복호화된 코드: " +src);
		
		
	}
	/*
	 * 함수명 : security
	 * parameter: String
	 * return: String
	 * 내용: 일반 문자와 숫자를 암호화하여 돌려주는 함수
	 */
	//암호화시키는 함수
	static String security(String src) {
		char[] abcCode = //a~z

			{ '`','~','!','@','#','$','%','^','&','*', //a b c d e
			'(',')','-','_','+','=','|','[',']','{',
			'}',';',':',',','.','/'};

			

			char[] numCode = { //0~9
					'q','w','e','r','t','y','u','i','o','p'};
		
		String resultCode ="";
		
		//src문자열이 넘어옴, 문자열하나하나를 분리해서 암호화해야함
		for (int i = 0; i < src.length(); i++) {
					
		//한문자한문자 꺼내기 위한 작업
		char ch = src.charAt(i);
		int num = (int)ch; //아스키코드값을 인트값으로받음
		
		//알파벳의 경우
		if( num >= 97 && num <= 122) { 
			num = num -97; //a인 경우 0이 되어버림 매치시키는것
			resultCode = resultCode + abcCode[num];
		}
		//숫자의 경우
		//if(num >= 48 && num <= 57)
		else {
			num = num -48;
			resultCode = resultCode + numCode[num]; //numCode 에num 의값을 넣음
			}
		}
		return resultCode;
	}
	
	//복호화 시키는 함수
	static String deciphering(String src) {
		char[] abcCode =

			{ '`','~','!','@','#','$','%','^','&','*',
			'(',')','-','_','+','=','|','[',']','{',
			'}',';',':',',','.','/'};

			// 0 1 2 3 4 5 6 7 8 9

			char[] numCode = {'q','w','e','r','t','y','u','i','o','p'};
			
			String oriStr = "";
			
			for (int j = 0; j < src.length(); j++) {
				
			
			char c = src.charAt(j);
			int n = (int)c; //한글자만꺼내는거생각해봐
			//ascii값을 꺼냈을때 현재 몇인지 암호표가  알파벳으로 되어있음
			int index = 0;
			if( n >= 97 && n <=122) {//숫자라는 뜻 (비교)
				for (int i = 0; i < numCode.length; i++) {
					if(c == numCode[i]) { //비교함, 번지수가 중요 0번째냐 1번째냐 (바꾸는것)
						index = i; //0~9
						break;
					}
				}
				//계산하기 편리하게 하기위해서
				index = index + 48; //숫자키 0번이 아스키코드 48
				oriStr = oriStr + (char)index;  //함수특성상 char로 형변환
			}
			else { //알파벳
				for (int i = 0; i < abcCode.length; i++) {
					if(c == abcCode[i]) {
						index = i;
						break;
					}
				}
				index = index + 97; //알파벳은 97부터시작함
				oriStr = oriStr + index;				
			}
			
			}
			return oriStr;
	}

}
