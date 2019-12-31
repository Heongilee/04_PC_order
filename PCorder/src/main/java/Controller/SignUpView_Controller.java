package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import View.LoginView;

public class SignUpView_Controller implements I_Register{
	private final LoginView v = new LoginView();
	@Override
	public void Valid_Check() {
		System.out.println("�α��� ����!!");
	}
	@Override
	public void Register_Complete() {
	}
	
	public SignUpView_Controller() {
		v.addButtonActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton btn = (JButton)e.getSource();
				if(btn.getText().equals("�α���")) {
					Valid_Check();
				}
			}
		});
	}
}
