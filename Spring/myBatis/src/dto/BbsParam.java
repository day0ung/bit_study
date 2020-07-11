package dto;

public class BbsParam {

	private String s_category;	// 제목, 내용, 작성자
	private String keyword;		// 검색어
	
	public BbsParam() {
	}

	public BbsParam(String s_category, String keyword) {
		super();
		this.s_category = s_category;
		this.keyword = keyword;
	}

	public String getS_category() {
		return s_category;
	}

	public void setS_category(String s_category) {
		this.s_category = s_category;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
}
