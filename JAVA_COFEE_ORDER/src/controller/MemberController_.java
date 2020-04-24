package controller;

import java.util.List;

import javax.swing.JOptionPane;

import dto.MemberDto;
import service.MemberService;
import service.impl.MemberServiceImpl;
import singleton.Singleton;
import view.accountView;
import view.loginView;


public class MemberController_ {
	//MemberController - > MemberService - > MemberDao
	//Service와 대화
	MemberService memberServ = new MemberServiceImpl();
	
	public void login() {
		new loginView();
	}
	
	public void regi() {
		new accountView();
	}
	
	public void logout() {
		Singleton s = Singleton.getInstance();
		s.setLoginID("");
		login();
	}
	
	//registerAfter
	public void regiAf(String id, String pwd, String name, String email) {
		boolean b = memberServ.addMember(new MemberDto(id, pwd, name, email, 3)); // 사용자 3번
		if(b) {
			JOptionPane.showMessageDialog(null, "회원가입 성공");
			login();
		}else {
			JOptionPane.showMessageDialog(null, "회원가입 실패");
			regi();
		}
	}
	
	
	public void loginAf(String id, String pwd) {
		MemberDto dto = memberServ.login(id, pwd);
		if(dto == null) {
			JOptionPane.showMessageDialog(null, "id나 password가 틀렸습니다");
			login();
		}else {
			JOptionPane.showMessageDialog(null, dto.getId() + "님 환영합니다");
			//id 저장 -> session
			Singleton s = Singleton.getInstance();
			s.setLoginID(dto.getId());
			
			// bbs controller bbs list로 이동
//			s.bbsCtrl.getBbsList();
			s.orderCtrl.getOrderView();
			
		}
	}
	
	public boolean idCheck(String id) {
		return memberServ.getId(id);
	}
	
	
	
}











