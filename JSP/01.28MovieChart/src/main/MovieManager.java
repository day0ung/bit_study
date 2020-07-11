package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MovieManager {
	//cgv페이지 좋아요와 영화제목 불러오기
	public static List<MovieVo> getCGVdata(){
		
		//---데이터 수집하는 과정
		Document doc;
		
		//list생성
		List<MovieVo> list = new ArrayList<MovieVo>();
		
		//---시각화
		
		try {
								//cgv url넣어주기
			doc = Jsoup.connect("http://www.cgv.co.kr/movies/").get();
			
			//영화제목 
			Elements titles = doc.select("div.box-contents strong.title");
			//div클래스 box contents안의 strong 클래스안의 title
			
			/*
			 cgv-source코드
			 <div class="box-contents">
                        <a href="/movies/detail-view/?midx=82999">
                            <strong class="title">남산의 부장들</strong>
                        </a>   
			    
			 */
			
			
			//좋아요수
			Elements likes = doc.select("div.box-contents span.count strong i");
			//큰테두리 div안의 span클래스count안의 strong안의 i
			/*
			  <span class="count"> 
                     <strong><i>6,673</i><span>명이 선택</span></strong> 
			 */
			for (int i = 0; i < 7; i++) {
				Element eTtile = titles.get(i); //하나씩받는거라 element ! s붙으면안됌
				String title = eTtile.text();
				System.out.print(title + " ");
				
				Element eLike = likes.get(i);
				String slike = eLike.text().replace(",", ""); //replace(",", ""); 좋아요 숫자의 , 없애기
				System.out.println(slike);
				
				
				//data담기
				int like = Integer.parseInt(slike);
				
				MovieVo vo = new MovieVo();
				vo.setTitle(title);
				vo.setLike(like);
				
				//list에 추가하기
				 list.add(vo);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return list;
		
	}
}
