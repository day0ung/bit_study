<%@page import="dto.PdsDto"%>
<%@page import="dao.PdsDao"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="java.io.File"%>
<%@page import="java.io.IOException"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    



<%!
//업로드하는 directory지정해주고, 파일을 새로생성하는 함수
//-- insert delete select update 자료실에서 제일 어려운것은? update임 
//-- 왜? 제목이나 파일 무엇을 바꿀지 모르기 때문.
public String processUploadFile(FileItem fileItem, String dir) throws IOException{
  //-- 두가지를 설정할 수 있는데 > 경로(서버, 클라이언트) + 파일명 이 들어옴.
   String filename = fileItem.getName(); //경로(서버경로, 클라이언트경로) + 파일명으로 들어옴
   long sizeInBytes = fileItem.getSize(); //현재 파일의 크기
   
   //-- 파일이 정상
   if(sizeInBytes > 0){ //-- 파일 올릴때  d:\\tem\\abc.txt  &&  d:/tmp/abc.txt
      
      //-- idx > 인덱스 약자임      		// \\ <- 이위치의 +1 ==abc.txt  
      int idx = filename.lastIndexOf("\\"); //lastindexof 뒤에서붙터 찾아나감 \\의 위치값을 찾아나감
      
      if(idx == -1){ //-- -1 : 못 찾았다는 의미임 
         idx = filename.lastIndexOf("/");
      }
      
      //--** 파일명 갖고오기 (파일명, 확장자) 
      //-- substring 잘라서 갖고오는것. (idx + 1) : 뒤에 다 갖고 오라는 소리임. ; //substring 그 위치부터 다갖고와라
      filename = filename.substring(idx + 1); // 위의 경우 abc.txt 이것을 갖고온다.
      
      //--** 파일을 생성해서 거기에 기입 dir : 우리가 만든 디렉토리에 filename을 생성하라.
      File uploadFile = new File(dir, filename);
      
      try{
        fileItem.write(uploadFile); //-- 실제 업로드 부분
      }catch(Exception e){
         
      }
      
   }
   return filename; //-- 리턴값은 없어도 되지만 확인 하기 위해서 해준다.
   
}


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pdsupload.jsp</title> <!--writeAf와 비슷함 -->
</head>
<body>
<!-- 배포 -->
<%
//tomcat배포(server)
				//application >>내장객체
String fupload = application.getRealPath("/upload"); //upload라는폴더만들어주기

//지정폴더(client)
//String fupload = "d:\\tmp";

System.out.println("업로드 폴더:" + fupload); //임시서버경로

String yourTempDir = fupload;

int yourMaxRequestSize = 100 * 1024 * 1024; //업로드했었을때 최대사이즈 1Mbyte
int yourMaxMemorySize = 100 * 1024; //1Kbyte


//form field의 데이터를 저장할 변수
String id = "";
String title = "";
String content = "";

//file  name변수 
String filename = "";

//multipart로 전송되었는가를 체크
boolean isMultipart = ServletFileUpload.isMultipartContent(request);   

if(isMultipart == true){
		
	DiskFileItemFactory factory = new DiskFileItemFactory(); //file item생성
	
	factory.setSizeThreshold(yourMaxMemorySize); //메모리사이즈 설정 // 한번에 메모리에 저장할 사이즈 설정
	factory.setRepository(new File(yourTempDir)); //파일을 생성해주고 (저장소에 집어넣겟다)
		
	ServletFileUpload upload = new ServletFileUpload(factory);
	upload.setSizeMax(yourMaxRequestSize); //전송할 크기 <순간전송크기>// 파일 업로드 최대 사이즈를 설정
	
	//list 저장 -> id, title, content, file <<dto에서 만든거
	List<FileItem> items = upload.parseRequest(request); //전송되어온 부분을 뽑아내는것 parseRequest  -> 이것들을 list 에 담음 이곳에 id, title, content file.이 있음
	//꺼내주기
	Iterator<FileItem> it = items.iterator();
	
	//구분(formfield와 file)
	while(it.hasNext()){
		FileItem item = it.next();
		if( item.isFormField() ){ //true였을때 id,title, content
			if(item.getFieldName().equals("id")){
				id = item.getString("utf-8");
			}
			else if(item.getFieldName().equals("title")){
				title = item.getString("utf-8");
			}
			else if(item.getFieldName().equals("content")){
				content = item.getString("utf-8");
			}
		}
		else{ //file 정확히 말하면pdswrite.jsp name =fileload의 부분임 
			if(item.getFieldName().equals("fileload")){
					//위에서 만들어준 함수processUploadFile(FileItem fileItem, String dir) 
				filename = processUploadFile(item, fupload);
			}
		}
	}
}else{
	System.out.println("multipart가 아닙니다.");	
}

//DB에 저장
PdsDao dao = PdsDao.getInstance();

boolean isS = dao.writePds(new PdsDto(id, title, content, filename));
if(isS){
%>
	<script type="text/javascript">
	alert("파일업로드 성공!");
	location.href = "pdslist.jsp";
	</script>
<%
}else{ 
%>
	<script type="text/javascript">
	alert("fail");
	location.href = "pdslist.jsp";
	</script>
<%
} 
%>
</body>
</html>