package Controller;

public interface I_Register {
	void Valid_Check();	//���̵�, �г���, �̸��� �׸��� �������� ��ȿ�� �˻�
						//(�̹� DB��Ű�� �������� ��ȿ�� �˻縦 �����ϱ� ������  SQLException�� try-catch����� ������ ��)
	void Register_Complete();	//��ȿ�� �˻縦 �����ϸ� ȸ������ �Ϸ� �޽����� �Բ� CUSTOMERS���̺��� ���ڵ�� ������.
}
