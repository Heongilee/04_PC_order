package Controller;

public interface I_Login {
	// ������ �ڵ鷯���� ȣ���ų �޼ҵ�
	void Submit();		//������ �ڵ鷯���� JButton �α����� ������ �� ����� ��/������ ��� �̵�.  
	void Register();	//������ �ڵ鷯���� JButton ȸ�������� ������ �� ȸ������ �������� �̵�
	boolean Mode_Check(String id, String pw, int flag);	//������ ������� ����� ������� üũ�ϴ� �Լ�.
}