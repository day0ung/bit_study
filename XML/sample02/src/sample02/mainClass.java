package sample02;

import java.io.FileReader;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class mainClass {
	public static void main(String[] args)throws Exception {
		//client.xml java parsing
		Document xml = null;
		
		InputSource is = new InputSource(new FileReader("d:\\tmp\\client.xml"));
		xml = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);
		
		//root element취득
		Element element = xml.getDocumentElement();
		//System.out.println(element.getTagName());
		
		//child node들을 취득 <위에 elemet취득된 부분의 노드리스트가 넘어옴
		NodeList list = element.getChildNodes();
		System.out.println(list.getLength()); //출력결과  7[길이값이 7이다] 데이터는 3개 넣어놨음
		
		
		if(list.getLength() > 0 ) { //childnode 가 1개 이상
			for (int i = 0; i < list.getLength(); i++) {
							//고객들 > 고객의 값을 구함
				NodeList childlist = list.item(i).getChildNodes();
				
				if(childlist.getLength() > 0) {
					for (int j = 0; j < childlist.getLength(); j++) {
						
						//data 있는 것만 가져오기 위한 조건문 <값이 없을때는 #text가 들어감>
						if(childlist.item(j).getNodeName().equals("#text") == false) {
						System.out.println("xml 태그명: " + childlist.item(j).getNodeName()
								+ " xml 값: " + childlist.item(j).getTextContent() ); 
						}
					}
				}
			}		
			
		}
	}
}
