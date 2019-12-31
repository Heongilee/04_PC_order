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
			case 0:	//아이디 중복 체크
				try {
					if(dao.Idselect(LoginView.getInstance().signUpView.IdField.getText())) {
						
						JOptionPane.showMessageDialog(null, "다른 아이디를 입력해주세요");
					}
					else {
						JOptionPane.showMessageDialog(null, "이 아이디는 사용 가능합니다.");
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				break;
			case 1:	//닉네임 중복 체크
				try {
					if(dao.Nickselect(LoginView.getInstance().signUpView.NameField.getText())) {
						
						JOptionPane.showMessageDialog(null, "다른 닉네임을 입력해주세요");
					}
					else {
						JOptionPane.showMessageDialog(null, "이 닉네임은 사용이 가능합니다.");
						
					}
						
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				break;
			case 2:	//이메일 중복 체크
				try {
					if(dao.Emailselect(LoginView.getInstance().signUpView.EmailField.getText())) {
						
						JOptionPane.showMessageDialog(null, "다른 이메일을 입력해주세요");
					}
					else {
						JOptionPane.showMessageDialog(null, "이 이메일은 사용 가능합니다.");
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
		dao.Renewal_cID();		//테이블 관리번호 갱신하는 함수.
	}
}
