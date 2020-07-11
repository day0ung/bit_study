package bit.com.a.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import bit.com.a.model.Youtube;

@Component	 // -> autowried 사용할 수 있음 
public class YoutubeParser {
	
	String urls = "https://www.youtube.com/results?search_query=";
	ArrayList<String> htmls = new ArrayList<String>();
	//검색어를 s로 집어넣으면 리스트에 추가하고 리턴해줌,
	public ArrayList<String> search(String s) {
		
		htmls.clear();  //arrraylist소속의 clear함수 >> 지워주는 것
		//bufferedReader에 저장
		BufferedReader br = null;
		
		try {
			String ss = URLEncoder.encode(s, "utf-8");
			System.out.println(ss);
						
			URL url = new URL(urls + ss);
			br = new BufferedReader(new InputStreamReader(url.openStream(), "utf-8"));
			
			String msg = "";
			while((msg = br.readLine()) != null) {
									//이클래스들과 같은때!
				if(msg.trim ().contains("class=\"yt-uix-tile-link yt-ui-ellipsis yt-ui-ellipsis-2 yt-uix-sessionlink")) {
					htmls.add(msg.trim());  //검색된것을 html에다가 집어넣은것임
				}
			}			
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return htmls;
	}
	
	public String toUrl(String msg) {
		String tt = "";
		if(msg.indexOf("&") == -1) { //&가 없는경우
			tt = msg;
		}else {
			tt = msg.substring(0, msg.indexOf("&"));			
		}
		return tt;
	}
	//검색을한 검색어가들어오면 search함수를 이요해라
	public ArrayList<Youtube> getTitles(String key) {
		ArrayList<Youtube> af = new ArrayList<Youtube>();
		int i = 0; //size와 다를수 있기 때문 
		ArrayList<String> asd = search(key);
		
		for(int j = 0;j < asd.size(); j++) {
			try {
				String[] fu = asd.get(i).split("\"");	// asas/as/
				System.out.println("fu"+fu);
				String url = URLDecoder.decode(fu[5], "EUC-KR");
				System.out.println("url"+url);
				String title = URLDecoder.decode(fu[11], "EUC-KR");
				
				Youtube dto = new Youtube(title, toUrl(url), "");
				af.add(dto);
				
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
		}
		return af;		
	}
	

}




