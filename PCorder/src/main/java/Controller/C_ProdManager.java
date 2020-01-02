package Controller;

import Model.Product_DAO;

public class C_ProdManager implements I_ProdManager{
	Product_DAO dao = Product_DAO.getInstance();
	View.ProdManager PM = View.ProdManager.getInstance(); 
	@Override
	public void show() {	//상품 목록 조회
		if(PM.prodCombo.getSelectedIndex() == 0) {	//전체 상품 조회
			dao.SQL_SHOW(true, 0);
			PM.stateText.setText("## 메시지 : 모든 상품 목록을 조회합니다...");
		}
		else {	//특정 상품 조회
			String id = (String) PM.prodCombo.getSelectedItem();
			System.out.println("TEST : "+PM.prodCombo.getSelectedItem());
			dao.SQL_SHOW(false, Integer.valueOf(id));
			
			PM.stateText.setText("## 메시지 : "+ id +"번 상품을 조회합니다...");
		}
		return;
	}
	
	@Override
	public void insertion() {
		if(PM.prodCombo.getSelectedIndex() == 0) { //일반 삽입
			dao.SQL_INSERT(true, 0);
		}
		else { //특정 상품 수정.
			String id = (String) PM.prodCombo.getSelectedItem();
			dao.SQL_INSERT(false, Integer.valueOf(id));
		}
	}
	
	@Override
	public void deletion() {
	}
}
