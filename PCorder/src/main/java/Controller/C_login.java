package Controller;

import javax.swing.JOptionPane;

public class C_login implements I_Login{

	@Override
	public void Submit() {
		System.out.println("[1] : 로그인 버튼 발생!!");
	}

	@Override
	public void Register() {
		System.out.println("[2] : 회원가입으로 이동!!");
	}

	@Override
	public void Mode_Check() {
		System.out.println("[3] : 로그인 성공!!");
	}
	
}
