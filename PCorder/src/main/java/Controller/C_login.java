package Controller;

import javax.swing.JOptionPane;

import Model.Customers_DAO;

public class C_login implements I_Login{
	Customers_DAO dao = Customers_DAO.getInstance();
	
	@Override
	public void Submit() {
		System.out.println("[1] : 로그인 버튼 발생!!");
	}

	@Override
	public void Register() {
		System.out.println("[2] : 회원가입으로 이동!!");
	}

	@Override
	public boolean Mode_Check(String id, String pw, int flag) {
		boolean RET = false;
		if(dao.Try_Login(id, pw, flag)) { //
			RET = true;
			
			switch(flag) 
			{
				case 0:	//(관리자 cMODE : 0)
					System.out.println("[1] : C_login()\\(관리자 cMODE : 0)");
					break;
				case 1:	//(사용자 cMODE : 1) -> 클라이언트 ArrayList에 추가...
					System.out.println("[1] : C_login()\\(사용자 cMODE : 1)");
					break;
					default:
						break;
			}
		}
		else {
			RET = false;
		}
		
		return RET;
	}
}
