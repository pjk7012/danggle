package kr.co.todaydaeng.member.model.service;

import kr.co.todaydaeng.member.model.vo.EmailAuthHist;
import kr.co.todaydaeng.member.model.vo.Member;

public interface MemberService {
	//회원가입
	int joinMember(Member member);

	//id 중복 확인
	int memberIdCheck(String userId);
	
	//로그인
	Member loginMember(Member member);
	
	//id찾기 전 회원 여부 확인
	Member memberEmailCheck(String email);
	
	//id찾기 시 이메일 인증 정보 저장
	int insertAuthNo(EmailAuthHist emailAuthHist);
}
