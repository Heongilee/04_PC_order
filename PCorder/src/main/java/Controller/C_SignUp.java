package Controller;

import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Model.Customer_DTO;
import Model.Customers_DAO;
import View.LoginView;
import View.SignUpView;

public class C_SignUp implements I_Register {
	Customers_DAO dao = Customers_DAO.getInstance();
	
	@Override
	public void Valid_Check(int f) {
		switch(f) {
			case 0:	//���̵� �ߺ� üũ
				try {
					if(dao.Idselect(LoginView.getInstance().signUpView.IdField.getText())) {
						
						JOptionPane.showMessageDialog(null, "�ٸ� ���̵� �Է����ּ���");
					}
					else {
						JOptionPane.showMessageDialog(null, "�� ���̵�� ��� �����մϴ�.");
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				break;
			case 1:	//�г��� �ߺ� üũ
				try {
					if(dao.Nickselect(LoginView.getInstance().signUpView.NameField.getText())) {
						
						JOptionPane.showMessageDialog(null, "�ٸ� �г����� �Է����ּ���");
					}
					else {
						JOptionPane.showMessageDialog(null, "�� �г����� ����� �����մϴ�.");
						
					}
						
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				break;
			case 2:	//�̸��� �ߺ� üũ
				try {
					if(dao.Emailselect(LoginView.getInstance().signUpView.EmailField.getText())) {
						
						JOptionPane.showMessageDialog(null, "�ٸ� �̸����� �Է����ּ���");
					}
					else {
						JOptionPane.showMessageDialog(null, "�� �̸����� ��� �����մϴ�.");
					}
						
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				break;
			default:
				break;
		}
	}
	@Override
	public void Register_Complete() throws SQLException {
		Customer_DTO dto = new Customer_DTO(LoginView.getInstance().signUpView.IdField.getText(),
				LoginView.getInstance().signUpView.PassField.getText(),
				LoginView.getInstance().signUpView.NameField.getText(),
				LoginView.getInstance().signUpView.EmailField.getText());
		
		System.out.println("[1] : "+dto.toString());
		
		dao.CUSTOMERS_FUNC1(dto);
		dao.Renewal_cID();		//���̺� ������ȣ �����ϴ� �Լ�.
	}
}
