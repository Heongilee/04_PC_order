package Controller;

import Model.Product_DAO;

public class C_ProdManager implements I_ProdManager{
	Product_DAO dao = Product_DAO.getInstance();
	View.ProdManager PM = View.ProdManager.getInstance(); 
	@Override
	public void show() {	//��� ��ǰ ��� ��ȸ
		dao.SQL_SHOW();
		PM.stateText.setText("## �޽��� : ��� ��ǰ ����� ��ȸ�մϴ�...");
		
		return;
	}
	
	@Override
	public void insertion() {
	}
	
	@Override
	public void deletion() {
	}

}
