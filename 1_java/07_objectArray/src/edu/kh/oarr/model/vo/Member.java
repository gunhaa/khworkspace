package edu.kh.oarr.model.vo;

public class Member {

	//클래스의 구조
	//필드 ( == 멤버 변수)
	private String memberId;
	private String memberPw;
	private String memberName;
	private int memberAge;
	private String region; //지역 (서울, 부산... )

	//생성자
	// 반환형이 없다. 객체를 초기화 시킬때 사용한다
	public Member() { //기본생성자
	}

	public Member(String memberId, String memberPw, String memberName, int memberAge, 
			String region) {

		this.memberId=memberId;
		this.memberPw=memberPw;
		this.memberName=memberName;
		this.memberAge=memberAge;
		this.region=region;

	}

	//메소드
	//getter / setter
	//Getter : 내부의 멤버변수에 저장된 값을 외부로 리턴.

	// 메개변수는 없고, 리턴값만 있는 메서드로 정의한다. 

	// 메서드명은 주로 getXXX() 메서드 형식으로 지정

	// XXX은 해당 멤버변수의 변수명을 사용.

	//Setter : 외부로부터 데이터를 전달받아 멤버변수에 저장.

	//  매개변수만 있고, 리턴값은 없는 메서드로 정의.
	//memberId
	public String getMemberId() {
		return memberId;
		//this.memberId 도 가능하다. 굳이 필요는 없음

	}
	//외부로부터 전달받은 값을 받아서 보여주기 위한것
	public void setMemberId(String memberId) {
		this.memberId = memberId;
		return;
		//모든 메소드는 종료 시 호출한 곳으로 돌아가는 
		//return 구문이 작성되어야만 하지만
		//단 , void일 경우에는 생략이 가능하다.
		// -> why? 생략 시 컴파일러가 자동으로 추가해준다.
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

	public int getMemberAge() {
		return memberAge;
	}

	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}
	
	public String getRegion( ) {
		return region;
	}
	
	public void setRegion(String region) {
		this.region = region;
	}



}
