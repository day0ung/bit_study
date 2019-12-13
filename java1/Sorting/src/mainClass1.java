import java.util.Scanner;

public class mainClass1 {

	public static void main(String[] args) {
		/*
		 * sorting
		 * 
		 * 선언부
		 * 
		 * 입력부 몇개를 정렬하시겠습니까? 동적할당(갯수에맞춰서) 숫자를 갯수에 맞게 입력받는다 올림(1)/내림(2)
		 * 
		 * 정렬
		 * 
		 * 결과출력
		 */
		Scanner scan = new Scanner(System.in);
		int temp; // swap
		int arrNum[] =null; // 정렬
		int count =0; // 몇개를 정렬할지?
		//선언부


		System.out.println("몇개를 정렬하시겠습니까?");
		count = scan.nextInt();

		arrNum = new int[count]; // 갯수에 맞춰서 정렬
		System.out.println("정렬할 갯수: " + count);

		// 정렬할 숫자들 입력(동적할당)
		for (int i = 0; i < arrNum.length; i++) {
			System.out.println((i + 1) + "번째 수=");
			arrNum[i] = scan.nextInt();
		}

		System.out.println("올림(1)/내림(2)");
		int choice = scan.nextInt();
		if (choice == 1) {
			// 오름차순
			for (int i = 0; i < arrNum.length - 1; i++) {
				for (int j = i + 1; j < arrNum.length; j++) {
					if (arrNum[i] > arrNum[j]) {

						temp = arrNum[i];
						arrNum[i] = arrNum[j];
						arrNum[j] = temp;
					}
				}
			}
			for (int i = 0; i < arrNum.length; i++) {
				System.out.print(arrNum[i] + " ");
			}
			System.out.println();
		} else if (choice == 2) {
			// 내림차순
			for (int i = 0; i < arrNum.length - 1; i++) {
				for (int j = i + 1; j < arrNum.length; j++) {
					if (arrNum[i] < arrNum[j]) {

						temp = arrNum[i];
						arrNum[i] = arrNum[j];
						arrNum[j] = temp;
					}
				}
			}
			for (int i = 0; i < arrNum.length; i++) {
				System.out.print(arrNum[i] + " ");
			}
			System.out.println();
		}

	}

}