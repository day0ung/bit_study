
public class mainClass {
	public static void main(String[] args) {
		int temp;
		int arrNum[] = { 10, 1, 9, 2, 8, 3, 7, 4, 6, 5};
		/*
		  	      	 i = 0----------------------------
		 		  		 i=	1------------------------
		 					    2---------------------
		 */
		for (int i = 0; i < arrNum.length - 1; i++) { // 0 ~ 8   //바깥for = 1, 2, 3
			//arrNum.length - 1; 맨끝에거는 할필요가 없기 떄문에 0 ~8
			for (int j = i +1; j < arrNum.length; j++) {  // (i+1) ~ 9  //안쪽for = ------ i +1, 
																	//i 가 0 이었을때 j = 1
															
				
				
				//오름차순 >, 내림차순 <
				if(arrNum[i] < arrNum[j]) {
					//swap
					temp = arrNum[i];
					arrNum[i] = arrNum[j];
					arrNum[j] =temp;
				}
			}
		}
		for (int i = 0; i < arrNum.length; i++) {
			System.out.print(arrNum[i]+ " ");
		}
		System.out.println();
	}
}
