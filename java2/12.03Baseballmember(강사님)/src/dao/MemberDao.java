package dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

import dto.Batter;
import dto.Human;
import dto.Pitcher;
import file.DataClass;

public class MemberDao {
	
	Scanner sc = new Scanner(System.in);
	
	private HashMap<String, Human> map;
	
	private int MemNumber; //sequence number 관리 변수
	
	DataClass dataCls;
	
	public MemberDao() {
		
		dataCls = new DataClass("baseball");
		dataCls.createFile();
	
		map = dataCls.readFile();
		MemNumber = 1000;  //1000부터 시작해서 숫자가 점점늘어나게
		
		
		//sequence number 산출
		//if(!map.isEmpty(){
		if(map.size()>0) {
			
			Iterator<String> it = map.keySet().iterator(); //파일을불러와서 맵에다집어넣음 제일마지막번호를뽑아야함
			//주의사항(어떤건 1000번부터시작하고, 2000부터시작하고 다름)
			
			int lastNum = 0; //초기화
			while(it.hasNext()) {
				//이걸써주는 목적: 맨마지막번호1002번을 얻어오기 위함 
				String key = it.next();
				Human h = map.get(key); //휴먼데이터를뽑은것
				//이것리스트가 아니기때문에 마지막번호가 몇번인지 비교로 뽑으면됨
				
				int lastMemNum = h.getNumber();
				if(lastMemNum >= 2000) {//2000이상의 경우 -1000을해준다
					lastMemNum = lastMemNum -1000;
				}
				
				if(lastNum <lastMemNum) { //제일컷을때 데이터가들어감
					lastNum = lastMemNum;
				}
				
			}
			
			MemNumber = lastNum +1;
			
		}
	}
	
	public void insert() {
		System.out.println("===>>선수등록<<===");
		System.out.println("투수(1)/ 타자(2) ");
		System.out.print("번호입력>>> ");
		int choice = sc.nextInt(); 
		
		Human human = null;// map에다 넣기 위함
		
		//human
		System.out.print("이름: "); //number는 우리가 지정해주는것임
		String name = sc.next();
		
		System.out.println("나이: ");
		int age = sc.nextInt();
		
		System.out.println("신장: ");
		double height = sc.nextDouble();
		
		if(choice ==1) { //pitcher
			System.out.print("승: "); 
			int win = sc.nextInt();
			
			System.out.print("패: ");
			int lose = sc.nextInt();
			
			System.out.print("방어율: ");
			double defence = sc.nextDouble();
			
			human = new Pitcher(MemNumber, name, age, height, win, lose, defence);
			
		}else { //batter
			System.out.print("타수: "); 
			int batcount = sc.nextInt();
			
			System.out.print("안타수: ");
			int hit = sc.nextInt();
			
			System.out.print("타율: ");
			double hitAvg = sc.nextDouble();
			
			 human = new Batter(MemNumber +1000, name, age, height, 
					 batcount, hit, hitAvg); //batter와 pitch와 구분을 해주어야함 (MemNumber +1000
				 // 투수등록하면 1000, 타자등록하면 2001, 타자 2002, 투수등록하면 1003 -> 선수번호에서 
		}

		//map에 추가
		map.put(human.getName(), human); //휴먼데이터안에 네임, 생성은 안쪽에서 생성 null로 해놓은이유
		MemNumber++;
		
	
	}
	
	public void delete() {
		System.out.println("방출하고 싶은 선수명을 입력해주십시오");
		System.out.print(">>");
		String name = sc.next();
		
		Human h = null;
		h = map.get(name);
		
		if(h == null || h.getName().equals("")) {
			System.out.println("데이터를 찾을 수 없습니다.");
			return; //그다음작업하지않게
		}
		
		//그것이 아니였을때는
		h = map.remove(name); //지워진데이터를 리턴받아서 출력해줌
		System.out.println(h.getName() +"의 데이터가 삭제되었습니다");
	}
	
	public void select() {
		System.out.println("검색하고 싶은 선수명을 입력해주십시오");
		System.out.print(">>");
		String name = sc.next();
		
		Human h = null;
		h = map.get(name);
		
		if(h == null || h.getName().equals("")) {
			System.out.println("데이터를 찾을 수 없습니다.");
			return; //그다음작업하지않게
		}
		//검색된선수명은 휴먼에 들어가있음
		System.out.println("검색된 선수입니다.");
		h.infomation(); //오버라이딩됨
	}
	
	public void update() {
		System.out.println("수정하고 싶은 선수명을 입력해주십시오");
		System.out.print(">>");
		String name = sc.next();
		
		Human h = null;
		h = map.get(name);
		
		if(h == null || h.getName().equals("")) {
			System.out.println("데이터를 찾을 수 없습니다.");
			return; //못찾고 튀어나감
		}
		System.out.println("수정할 데이터를 입력해주십시오");
		if(h.getNumber()< 2000) { //2000번보다 작으면 투수
			Pitcher p = (Pitcher)h; //변환
			System.out.print("승: ");
			int win = sc.nextInt();
			
			System.out.print("패: ");
			int lose = sc.nextInt();
			
			System.out.print("방어율: ");
			int defence = sc.nextInt();
			
			p.setWin(win);
			p.setLose(lose);
			p.setDefence(defence);
			
		}else {//타자
			Batter b = (Batter)h;
			System.out.print("타수: ");
			int batcount = sc.nextInt();
			
			System.out.print("안타: ");
			int hit = sc.nextInt();
			
			System.out.print("방어율: ");
			double hitAvg = sc.nextDouble();
			
			b.setBatcount(batcount);
			b.setHit(hit);
			b.setHitAvg(hitAvg);
			
		}
		System.out.println("데이터를 수정하였습니다.");
		
	}
	
	public void allprint() {
		Iterator<String> it = map.keySet().iterator();
		
		while(it.hasNext()) {
			String key =it.next();
			Human h = map.get(key); //휴먼데이터가나옴
			System.out.println(h.toString()); //피처건배터건 상속받은부분의 toString이 나옴
		}
	}
	
	public void memberSort() {
		//새로만들어서 사용하는게 좋음(외부데이터에문제생기지 않게, 내부에서 처리)
		HashMap<String, Human> hashMap = new HashMap<String, Human>();
		//hashmap에 키값은 방어율로 줘서 집어넣을려고함
		Iterator<String> it = map.keySet().iterator();		
		//loop형 변수
		int w = 0; //같은 키값이 들어가지 않도록 할 변수
		while(it.hasNext()) {
			String key = it.next();
			Human h = map.get(key); //휴먼데이터를 맵에서 꺼내올려고
			if(h instanceof Pitcher) {
				Pitcher p = (Pitcher)h;
				hashMap.put(p.getDefence()+""+w, p); //에러나는 이유 defence가 더블이라서 +""해주면됨
				w++; //첫번째데이터들어오고 다음데이터들어와도 w카운트 해서 넘어감
			}
		}
		TreeMap<String, Human> tMap = new TreeMap<String, Human>(hashMap);
		
		Iterator<String> updownIt = tMap.keySet().iterator();
									//오름차순, 방어율이 낮은사람이 위로가게
		while (updownIt.hasNext()) {
			String key = updownIt.next();
			System.out.print("key: "+ key+" ");
			Human h = tMap.get(key);
			System.out.println(h.toString());
		}
		}
	
	public void saveData() {
		String arrStr[] = new String[map.size()]; //맵의 크기만큼잡아라
		int w = 0;
		//iterator == 실제값을받아들임, key값이나옴
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			Human h = map.get(key); 
			
			arrStr[w] = h.toString(); //key값 ㅂ뀌면서 휴먼데이터넘어옴
			w++;
		}
		dataCls.writeFile(arrStr);
	}
}
