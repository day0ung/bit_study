package filedown;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBClose;
import db.DBConnection;
import dto.PdsDto;

public class FileDownLoader extends HttpServlet {
	//<pdsupload.jsp배포부분의 >getRealPath를 얻어오려면 config가 필요하다
	ServletConfig mConfig = null;
	
	//down로드를 받기위해서는 받운받겟다는 용량이 필요하다.
	static final int BUFFER_SIZE = 8192; //8Kbyte의 잠깐동안의 저장공간
	@Override
	public void init(ServletConfig config) throws ServletException {
		//upload폴더 경로를 취득하기 위해서 config에 접근한다.
		super.init(config);
		mConfig = config;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("FileDownLoader doGet");
		String filename = req.getParameter("filename");
		String sseq = req.getParameter("seq");
		
		//download 횟수 증가 (DB)(readcount와 똑같음)
		int seq = Integer.parseInt(sseq);
		downcount(seq);
	
		//data를 날려주면 받아주는 부분
		BufferedOutputStream out = new BufferedOutputStream(resp.getOutputStream());
		
		String filePath = "";
		
		//download 경로
		//tomcat(server)
				//경로얻기,  pdsupload의 getrealpath와같음
		filePath = mConfig.getServletContext().getRealPath("/upload");
		
		//폴더(client)
//		filePath = "d:\\tmp";
		filePath = filePath + "\\" + filename;
		System.out.println("다운로드: "+filePath);
		
		//file pointer
		File f = new File(filePath); //파일이 생성되는것은아님
		//파일이 있는지 확인
		if(f.exists() && f.canRead()) {
			System.out.println("파일이 맞고 존재합니다.");
			//다운로드창 윈도우로뜨게하기
			resp.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\";");
			resp.setHeader("Content-Transfer-Encoding", "binary;");
			resp.setHeader("Content-Length", "" + f.length());
			resp.setHeader("Pragma", "no-cache;"); //저장을하겟느냐 no-cache 저장안하겠다.
			resp.setHeader("Expires", "-1;"); //저장된 기한
			
			//파일생성, 기입
			BufferedInputStream fileInput = new BufferedInputStream(new FileInputStream(f));
			byte buffer[] = new byte[BUFFER_SIZE];
			
			int read = 0;
			while( (read = fileInput.read(buffer) ) != -1) {
				out.write(buffer, 0, read); //실제 다운로드
			}
			fileInput.close();
			out.flush();
		}
	}
	
	public void downcount(int seq) {
		String sql = " UPDATE PDS "
				+ " SET DOWNCOUNT=DOWNCOUNT+1 "
				+ " WHERE SEQ=? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
	
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 downcount success");
			
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seq);
			System.out.println("2/6 downcount success");
			
			psmt.executeUpdate();
			System.out.println("3/6 downcount success");
		} catch (SQLException e) {
			System.out.println("3/6 downcount fail");
			e.printStackTrace();
		}finally {
			DBClose.close(psmt, conn, null);
		}
		
	}
	

	
}
