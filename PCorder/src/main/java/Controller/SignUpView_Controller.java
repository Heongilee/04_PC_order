package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import View.LoginView;

public class SignUpView_Controller implements I_Register{
	private final LoginView v = new LoginView();
	@Override
	public void Valid_Check() {
		System.out.println("로그인 성공!!");
	}
	@Override
	public void Register_Complete() {
	}
	
	public SignUpView_Controller() {
		v.addButtonActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton btn = (JButton)e.getSource();
				if(btn.getText().equals("로그인")) {
					Valid_Check();
				}
			}
		});
	}
}
