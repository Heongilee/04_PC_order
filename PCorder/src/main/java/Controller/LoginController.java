package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Model.Customer_DTO;
import View.LoginView;

public class LoginController{
	private static LoginView v;
	private static C_login cl;
	
	void appMain() {
		v.addButtonActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton btn = (JButton)e.getSource();
				if(btn.getText().equals("·Î±×ÀÎ")) {
					cl.Mode_Check();
				}
				else {
					
				}
			}
		});
		
		return;
	}
	
	public LoginController(LoginView v) {
		this.v = v;
	}
	
	public LoginController(LoginView v, C_login cl) {
		this.v = v;
		this.cl = cl;
	}
	public static void main(String[] args) {
		LoginController app = new LoginController(LoginView.getInstance(), new C_login());
		app.appMain();
	}
}
