package Controller;

import javax.swing.JOptionPane;

import Model.Customers_DAO;

public class C_login implements I_Login{
	Customers_DAO dao = Customers_DAO.getInstance();
	
	@Override
	public void Submit() {
		System.out.println("[1] : �α��� ��ư �߻�!!");
	}

	@Override
	public void Register() {
		System.out.println("[2] : ȸ���������� �̵�!!");
	}

	@Override
	public boolean Mode_Check(String id, String pw, int flag) {
		boolean RET = false;
		if(dao.Try_Login(id, pw, flag)) { //
			RET = true;
			
			switch(flag) 
			{
				case 0:	//(������ cMODE : 0)
					System.out.println("[1] : C_login()\\(������ cMODE : 0)");
					break;
				case 1:	//(����� cMODE : 1) -> Ŭ���̾�Ʈ ArrayList�� �߰�...
					System.out.println("[1] : C_login()\\(����� cMODE : 1)");
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
