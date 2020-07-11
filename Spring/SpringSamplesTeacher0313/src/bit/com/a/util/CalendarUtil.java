package bit.com.a.util;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import bit.com.a.model.CalendarDto;

public class CalendarUtil {

	// 1 -> 01
	public static String two(int tt) {
		return (tt + "").length()>1?(tt+""):"0"+ tt;
	}
	
	// 20203 -> 202003
	public static String yyyymm(int year, int month) {
		return "" + year + two(month);
	}
	
	// 202032 -> 20200302
	public static String yyyymmdd(int year, int month, int day) {
		return "" + year + two(month) + two(day);
	}
	
	// 03(String) -> 3(int)
	public static int toOne(String tt) {
		if(tt.charAt(0) == '0') {
			return Integer.parseInt( "" + tt.charAt(1) );			
		}else {
			return Integer.parseInt( tt ); 
		}
	}
	
	public static String callist(int year, int month, int day){
		String str = "";
				
		str += String.format("<a href='%s?year=%d&month=%d&day=%d'title='" + day + "일별일정'>", 
								"callist.do", year, month, day);		
		str += String.format("%2d", day); 	
		str += "</a>";			
		return str;
	}
	
	public static String showPen(int year, int month, int day){
		String str = "";
		
		String image = "<img src='./image/pen.png' width='18px' height='18px' title='일정추가'>";	
		str = String.format("<a href='%s?year=%d&month=%d&day=%d'>%s</a>", 
								"calwrite.do", year, month, day, image);

		return str;
	}
	
	public static String two(String msg){
		return msg.trim().length()<2?"0"+msg.trim():msg.trim();
	}
	
	public static String makeTable(int year, int month, int day, List<CalendarDto> list){
		String str = "";
		
		// 2020 2 5 -> 20200205
		String dates = (year + "") + two(month + "") + two(day + "");
		
		str += "<table>";
		str += "<col width='98'>";
		
		for(CalendarDto dto : list){
			if(dto.getRdate().substring(0, 8).equals(dates)){
				str += "<tr bgcolor='#0000ff'>";
				str += "<td style='border:hidden'>";
				str += "<a href='caldetail.do?seq=" + dto.getSeq() + "'>";
				str += "<font style='font-size:12px;color:white'>";
				str += dot3(dto.getTitle());
				str += "</font>";
				str += "</a>";
				str += "</td>";
				str += "</tr>";
			}		
		}	
		str += "</table>";	
		return str;
	}
	
	public static String dot3(String msg){
		String str = "";
		if(msg.length() >= 6){
			str = msg.substring(0, 6);
			str += "..."; 
		}else{
			str = msg.trim();	
		}
		return str;
	}
	
	
	
	public static String yyyymmddhhmm(int year, int month, int day,
			int hour, int min){
		return yyyymmdd(year,month,day)+two(hour)+two(min);
	}
	
	//-------------vote---------
	//vote에 필요한 함수, 문자열 2020-03-17 -> java.lang.Date형태로 바꾸기 위한
	public static Date toDate(int year, int month, int day) { //date -> sqlDB에 넣을땐 java.sql.Date;로 해야함 이쪽에서 넣어 줄땐, 
																		//문자열로 넘어온것ㅇㄹ sql형태로 바꿔주는 것임 다른 dto의 date는 util소속
		String s = year +"-" + two(month + "") + "-" +two(day +""); //위에 있는 two함수를 이용해서 두자리로 바꿈
		System.out.println(s);  
		Date d = Date.valueOf(s);
		System.out.println(d);
		  
	      return d;
	}
	//달력의 날짜를 20200317형식으로 만들기
	public static String StringCal(Calendar dd) {
		/*String date = dd.get(Calendar.YEAR) + "" 
					+ two( dd.get(Calendar.MONTH) +1 );*/
		String s = "";
		int year = dd.get(Calendar.YEAR);
		int month = dd.get(Calendar.MONTH) +1;
		int day = dd.get(Calendar.DATE);
		s = year + "" + two(month+"") + two(day +"");
		
		return s;
	}
	//연월일 만으로 비교 : 오늘 - 종료일과 비교 했을때 오늘이 더 크면 종료 (오늘 > 종료일 -> 투표마감)
	public static boolean isEnd(java.util.Date d) {
		Calendar c = Calendar.getInstance(); //오늘날짜가 들어옴
		c.setTime(d);
		
		//현재시간 
		Calendar now = Calendar.getInstance();
		
		//오늘날짜가 마감일 보다 큰지?
		boolean b = Integer.parseInt(StringCal(now)) > Integer.parseInt(StringCal(c));
		return b; //true가 나오면 투표를 못함
	}
	
	//투표종료 판별
	public static String pollState(java.util.Date d) {
		String s1 = "<div style='color:RED'>[종료]</div>";
		String s2 = "<div style='color:BLUE'>[진행중]</div>";
		return isEnd(d)?s1:s2;
	}
	
	
	
}






