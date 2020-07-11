package bit.com.a.util;

public class BbsArrow {
	private int depth = 0;
	private String arrow;
	
	//setter 들어오는 곳
	public void setDepth(int depth) {
		this.depth = depth;
	}

	public String getArrow(){
		   String rs = "<img src='./image/arrow.png' width='20px' height='20px'/>";
		   String nbsp = "&nbsp;&nbsp;&nbsp;&nbsp;";
		   
		   String ts = ""; // 빈문자열 준비 왜..? 저걸 리턴해준다고 하심
		   for(int i = 0; i<depth; i++){
		      // depth 개수에 떄라서 여백이 결정
		      ts += nbsp; 
		   }
		   return depth==0?"":ts + rs; // 여백이 들어가면서 이미지가 들어가짐.
		}
	//나가는곳은 이곳
}
