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
		System.out.println("[1] : ���� : " + f);
		switch(f) {
		case 1:	//���̵� �˻�
			break;
		case 2:	//�г��� �˻�
			
			break;
		case 3:	//�̸��� �˻�
			
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
