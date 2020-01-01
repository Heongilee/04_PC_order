package Controller;

import Model.Product_DAO;

public class C_ProdManager implements I_ProdManager{
	Product_DAO dao = Product_DAO.getInstance();
	View.ProdManager PM = View.ProdManager.getInstance(); 
	@Override
	public void show() {	//모든 상품 목록 조회
		dao.SQL_SHOW();
		PM.stateText.setText("## 메시지 : 모든 상품 목록을 조회합니다...");
		
		return;
	}
	
	@Override
	public void insertion() {
	}
	
	@Override
	public void deletion() {
	}

}
