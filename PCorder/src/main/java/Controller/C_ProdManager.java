package Controller;

import Model.Product_DAO;

public class C_ProdManager implements I_ProdManager{
	Product_DAO dao = Product_DAO.getInstance();
	View.ProdManager PM = View.ProdManager.getInstance(); 
	@Override
	public void show() {	//��ǰ ��� ��ȸ
		if(PM.prodCombo.getSelectedIndex() == 0) {	//��ü ��ǰ ��ȸ
			dao.SQL_SHOW(true, 0);
			PM.stateText.setText("## �޽��� : ��� ��ǰ ����� ��ȸ�մϴ�...");
		}
		else {	//Ư�� ��ǰ ��ȸ
			String id = (String) PM.prodCombo.getSelectedItem();
			System.out.println("TEST : "+PM.prodCombo.getSelectedItem());
			dao.SQL_SHOW(false, Integer.valueOf(id));
			
			PM.stateText.setText("## �޽��� : "+ id +"�� ��ǰ�� ��ȸ�մϴ�...");
		}
		return;
	}
	
	@Override
	public void insertion() {
		if(PM.prodCombo.getSelectedIndex() == 0) { //�Ϲ� ����
			dao.SQL_INSERT(true, 0);
		}
		else { //Ư�� ��ǰ ����.
			String id = (String) PM.prodCombo.getSelectedItem();
			dao.SQL_INSERT(false, Integer.valueOf(id));
		}
	}
	
	@Override
	public void deletion() {
	}
}
