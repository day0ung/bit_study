
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;



public class MemberDAO {
	Scanner scan = new Scanner(System.in);
	private HashMap<String, HumanDTO> map;
	private int memberNum;
	
	public MemberDAO() {
		memberNum = 1000;
		map = new HashMap<String, HumanDTO>();
	}
	
	public void insert() {
		HumanDTO human = null;
		System.out.println("===>>선수등록<<===");
		System.out.println("투수(1)/ 타자(2) ");
		System.out.print("번호입력>>> ");
		int choice = scan.nextInt();
		
		System.out.print("이름: ");
		String name = scan.next();
		
		System.out.print("나이: ");
		int age = scan.nextInt();
		
		System.out.print("신장: ");
		double height = scan.nextDouble();
		
		if(choice == 1) {
			System.out.print("승: ");
			int win = scan.nextInt();
			System.out.print("패: ");
			int lose = scan.nextInt();
			System.out.print("방어율: ");
			double defense = scan.nextDouble();
			human = new PitcherDTO(memberNum, name, age, height, win, lose, defense);
		}
		else {
			System.out.print("타수: ");
			int bat = scan.nextInt();
			System.out.print("안타: ");
			int hit = scan.nextInt();
			System.out.print("타율: ");
			double batAvg = scan.nextDouble();
			human = new BatterDTO(memberNum+100, name, age, height, bat, hit, batAvg);
		}
		map.put(human.getName() , human);
		memberNum++;
		allPrint();
	}
	public void delete() {
		
	}
	
	public void select() {
		
		
		
	}
	
	public void update() {
		
	}
	
	public void allPrint() {
		Iterator<String > it = map.keySet().iterator();
		
		while(it.hasNext()) {
			String key = it.next();
			HumanDTO dto = map.get(key);
			System.out.println(key);
			System.out.println(dto);
		}
	}
	
	
	


}
