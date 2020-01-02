package Model;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextArea;

public class PCChatData {
	public JComboBox<String> comboItem;
	public JTextArea msgOut; 
	public void addObjCus(JComponent c) {
		//JTextArea의 데이터를 관리.
		//데이터 변경이 일어나 업데이트할 UI컴포넌트를 등록하는 메소드이다.
		this.msgOut = (JTextArea) c;
	}
	public void addObjGUI(JComponent c) {
		//JTextArea의 데이터를 관리.
		//데이터 변경이 일어나 업데이트할 UI컴포넌트를 등록하는 메소드이다.
		this.msgOut = (JTextArea) c;
	}
	public void refreshData(String msg) {
		//JTextArea창에 텍스트를 추가하는 작업만 한다.
		msgOut.append(msg);
	}
	public void addObjCombo(JComponent c) {
		//JTextComboBox의 데이터를 관리.
		//데이터 변경이 일어나 업데이트할 UI컴포넌트를 등록하는 메소드이다.
		this.comboItem = (JComboBox) c;
	}
	public void comboRefreshData(String item) {
		comboItem.addItem(item);
	}
//	private void comboRefreshData() {
//		ArrayList<Seat> datas = new ArrayList<Product>();
//		ta.setText("");
//		clearField();
//		
//		ta.append("관리번호\t상품명\t\t단가\t제조사\n");
//		
//		try {
//			datas = pd.getAll();
//			p4_cbx.setModel(new DefaultComboBoxModel(pd.getItems()));
//			if(datas != null) {
//				// ArrayList의 전체 데이터를 형식에 맞춰 출력
//				for(Product p : datas) {
//					StringBuffer sb = new StringBuffer();
//					sb.append(p.getId() + "\t");
//					sb.append(p.getName() + "\t\t");
//					sb.append(p.getPrice() + "\t");
//					sb.append(p.getManufacture() + "\n");
//					ta.append(sb.toString());
//				}
//			} else {
//				ta.append("등록된 상품이 없습니다. !!\n상품을 등록해 주세요 !!");
//			}
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//	}
}