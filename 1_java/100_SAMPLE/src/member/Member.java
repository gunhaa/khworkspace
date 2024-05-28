package member;

public class Member {

	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberAge;
	
	public Member() {
		memberId = "11";
		memberPw = "11";
		memberName = "11";
		memberAge = "11";
	}
	
	public Member(String memberId , String memberPw , String memberName, String memberAge) {
		
		this.memberId=memberId;
		this.memberPw=memberPw;
		this.memberName=memberName;
		this.memberAge=memberAge;
		
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberAge() {
		return memberAge;
	}

	public void setMemberAge(String memberAge) {
		this.memberAge = memberAge;
	}
	
	
	
}
