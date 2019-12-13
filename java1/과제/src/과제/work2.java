package 과제;
//메소드명 : shuffle
//기 능 : 주어진 배열에 담긴 값의 위치를 바꾸는 작업을 반복하여 뒤섞이게 한다.
//처리한 배열을 반환한다.
//반환타입 : int[]
//매개변수 : int[] arr – 정수 값이 담긴 배열

public class work2 {
	public static void main(String[] args) {

	int[] original = {1,2,3,4,5,6,7,8,9};
	System.out.println(java.util.Arrays.toString(original));
	int[] result = shuffle(original);
	System.out.println(java.util.Arrays.toString(result));

	}
	/*
	(1) shuffle메소드를 작성하시오.
	*/
	private static int[] shuffle(int[] original) {
		int temp;
		for (int i = 0; i < 1000; i++) {
			int r1 = (int)(Math.random()*original.length);
			int r2 = (int)(Math.random()*original.length);
			
			temp = original[r1];
			original[r1] =original[r2];
			original[r2]= temp;
		}
		
		return original;
	}
	
	

}

