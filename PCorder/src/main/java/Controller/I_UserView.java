package Controller;

public interface I_UserView {
	void Load_FoodCategory(int type);	
	//JButton{BEST3, ����, �����, ���ķ�, ���ڷ�}�� �ش��ϴ� ��ư�� 
	//Ŭ���ϸ� PRODUCTS ���̺��� pTYPE(��ǰ_ī�װ� �Ӽ�)�� �ش��ϴ� ���ڵ带
	//�����´�.
	
	// �Ʒ� ������ ������ �ȴ�.
	//sql = "SELECT * FROM WHERE pTYPE = ?";
	//PrepareStatement pstmt = new PrepareStatement(
	//pstmt.setInt(id)
	//executeQuery ...
	
	void Add_Orderlog();	
	// �ش� ��ǰ�� Ŭ���ϸ� �ֹ� ������ �߰��ȴ�.
	// �׸��� �߰��� �� ���� �հ� JTextField�� �߰��� �׸� �ش��ϴ� ������ å��
	// �ǵ��� �Ѵ�.
	
	void Submit_Order();
	// �ֹ� ������ ��ǰ���� ORDERS���̺� ���ڵ忡 �߰���Ű��
	// ���� �Ϸ� �޽����� ����Ѵ�.
	// Exception1. 	CUSTOMERS���̺��� �ش� ���� cBALANCE(�ܾ�)�� �˻���
	// 				���� �ݾ׺��� �ܾ��� �����ϸ� ���� ���� �޽����� ����Ѵ�.
	// Exception2.	�հ谡 0(�ֹ� ��Ͽ� �߰� ��ų �� ���� �հ谡 ���ϱ� ����)�̸� 
	// ���� ����
	
}
