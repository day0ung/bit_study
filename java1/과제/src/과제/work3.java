package 과제;

//메소드명 : max
//기 능 : 주어진 int형 배열의 값 중에서 제일 큰 값을 반환한다.
//만일 주어진 배열이 null이거나 크기가 0인 경우, -999999를 반환한다.
//반환타입 : int
//매개변수 : int[] arr - 최대값을 구할 배열
public class work3 {

	public static void main(String[] args) {

		int[] data = { 3, 2, 9, 4, 7 };
		System.out.println(java.util.Arrays.toString(data));
		System.out.println("최대값:" + max(data));
	}

	/*
	 * (1) max메소드를 작성하시오.
	 */
	 static int max(int array[]) {
		
		 
		int max_num = array[0]; //맨처음들어오는값 아무거나적어도됨
		
		for (int i = 0; i < array.length; i++) {
			if(max_num < array[i]) {
				max_num =array[i];
			}
		}

		return max_num;
	}

}
