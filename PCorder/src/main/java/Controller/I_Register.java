package Controller;
import java.sql.SQLException;

import javax.swing.JButton;
import View.SignUpView;

public interface I_Register {
	void Valid_Check(int f);	//���̵�, �г���, �̸��� �׸��� �������� ��ȿ�� �˻�
						//(�̹� DB��Ű�� �������� ��ȿ�� �˻縦 �����ϱ� ������  SQLException�� try-catch����� ������ ��)
	void Register_Complete() throws SQLException;	//��ȿ�� �˻縦 �����ϸ� ȸ������ �Ϸ� �޽����� �Բ� CUSTOMERS���̺��� ���ڵ�� ������.
}
