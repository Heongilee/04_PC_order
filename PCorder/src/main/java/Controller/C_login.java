package Controller;

import javax.swing.JOptionPane;

public class C_login implements I_Login{

	@Override
	public void Submit() {
		System.out.println("[1] : �α��� ��ư �߻�!!");
	}

	@Override
	public void Register() {
		System.out.println("[2] : ȸ���������� �̵�!!");
	}

	@Override
	public void Mode_Check() {
		System.out.println("[3] : �α��� ����!!");
	}
	
}
