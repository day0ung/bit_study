
public class mainClass {
	public static void main(String[] args) {
		/*
		 	Array : 배열
		 			같은 자료형의 묶음
		 			
		 	사용목적: 같은목적의 다수의 변수를 관리하기위해서
		 	자료형   배열명[] = new 자료형[배열의갯수]; >>할당할때는 동적, 할당 후에는 정적(정해짐)
		 				 new=동적할당
		 	동적(allocation)/정적(static)
		 	
		 	자료형 []배열명 = new 자료형[배열의갯수];
		 	자료형[] 배열명 = new 자료형[배열의갯수];
		 	      stack      heap
		 	배열명[index number] = 값; //배열을 갖고 접근을하는것임
		 	
		 */
		int arrNum[] = new int[3]; //0 ~ (n-1)
		//int []arrNum = new int[3]; >>가능
		
		//arrNum[] //접근하는것 
		arrNum[0] = 1;
		arrNum[1] = 2;
		arrNum[2] = 3;
		System.out.println(arrNum[2]);
		
		int arrNum1[] = {11,22,33};
		
		System.out.println(arrNum[2]);
		
		int numArr[] = {111,222,333};
		int numAlias[] = numArr;  //포인터원리를
		
		numAlias[1] = 666;
		
		System.out.println("numArr[1] ="+numArr[1]);
		
		//swap
		char aaa[] = {'a', 'b', 'c'};
		char bbb[] = {'A', 'B', 'C'};
		
		char aaaAlias[] = aaa;
		char bbbAlias[] = bbb;
		/*
		int temp;
		for (int i = 0; i < bbb.length; i++) {
			temp = aaa[i];
			aaa[i] = bbb[i];
			bbb[i] = temp;
			*/
		char tempArr[];
		
		tempArr = aaaAlias;
		aaaAlias = bbbAlias;
		bbbAlias = tempArr;
		
		for (int i = 0; i < bbbAlias.length; i++) {
			System.out.println("bbb["+ i +"] = " +bbbAlias[i]);
			//length배열의 길이값  연산자, bbbAlias에는 항상 배열의길이가있다. 
		}
		System.out.println("bbbAlias["+(bbbAlias.length -1)+ "] ="+ bbbAlias[(bbbAlias.length -1)]);
		//배열의마지막을 모를때 쓰는코드
		}
	}


