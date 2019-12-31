package Controller;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Model.Customers_DAO;
import View.SignUpView;

public class C_SignUp implements I_Register {
	Customers_DAO dao = Customers_DAO.getInstance();
	
	@Override
	public void Valid_Check(int f) {
		System.out.println("[1] : 진입 : " + f);
		switch(f) {
		case 1:	//아이디 검사
			break;
		case 2:	//닉네임 검사
			
			break;
		case 3:	//이메일 검사
			
			break;
			default:
				break;
		}
	}
	@Override
	public void Register_Complete() {
		// TODO Auto-generated method stub
	}

}
