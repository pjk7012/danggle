package kr.co.todaydaeng.common;

import java.util.HashMap;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyPageAOP {

	@Autowired
	private SHA256Util enc;
	
	@Pointcut("execution (kr.co.todaydaeng.member.model.vo.Member kr.co.todaydaeng.myPage.model.service.MyPageServiceImpl.selectPwdCheck(..))")
	public void selectPwdCheckPointCut() {}
	
	@Before("selectPwdCheckPointCut()")
	public void selectPwdCheckPointEncryption(JoinPoint jp) throws Exception {
		HashMap<String, String>map =(HashMap<String, String>)jp.getArgs()[0];
		
		String memberId=map.get("memberId");
		String memberPwd=map.get("memberPwd");
		
		String encryptPwd = enc.encryptionData(memberPwd, memberId);
		map.put("memberPwd", encryptPwd);
		
	}
	
	
	
	
}
