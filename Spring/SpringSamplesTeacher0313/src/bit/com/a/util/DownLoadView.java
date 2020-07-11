package bit.com.a.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class DownLoadView extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("다운로드뷰안에 renderMergedOutputModel");
		
		File file = (File)model.get("downloadFile"); //getattribute와 동일함  controller에서 넘겨준 String fileDownLoad에 있는 downloadFile
		System.out.println(file);
		response.setContentType(this.getContentType()); // 타입을 받겟다
		response.setContentLength((int)file.length()); //지금넘어온 파일의 길이값을 구함
		
		//IE/chrome 인터넷익스플로어인지 크롬인지 분간
		String userAgent = request.getHeader("user-Agent"); //ie
		
		boolean ie = userAgent.indexOf("MSIE") > -1; //chrome
		
		String filename= null;
		
		if(ie) {
			filename= URLEncoder.encode(file.getName(), "utf-8");
		}else {
			filename = new String ( file.getName().getBytes("utf-8"), "iso-8859-1");
		}
		
		//다운로드 창
		response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary;");
		response.setHeader("Content-Length", "" + file.length());
		response.setHeader("Pragma", "no-cache;"); //저장을하겟느냐 no-cache 저장안하겠다.
		response.setHeader("Expires", "-1;"); //저장된 기한
		
		OutputStream out = response.getOutputStream();
		FileInputStream fi = null;
		
		fi = new FileInputStream(file);
		FileCopyUtils.copy(fi, out); //넘어온파일포인트를 밖으로 넘겨주겟다 복새를해서, 실제로 파일 다운
		
		//download count 증가시키는 부분 DB에서 
		
		//다운로드가 끝나면 반드시 해주어야하는것
		if(fi != null) {
			fi.close();
		}
		
	}

}
