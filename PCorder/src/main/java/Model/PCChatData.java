package Model;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextArea;

public class PCChatData {
	public JComboBox<String> comboItem;
	public JTextArea msgOut; 
	public void addObjCus(JComponent c) {
		//JTextArea�� �����͸� ����.
		//������ ������ �Ͼ ������Ʈ�� UI������Ʈ�� ����ϴ� �޼ҵ��̴�.
		this.msgOut = (JTextArea) c;
	}
	public void addObjGUI(JComponent c) {
		//JTextArea�� �����͸� ����.
		//������ ������ �Ͼ ������Ʈ�� UI������Ʈ�� ����ϴ� �޼ҵ��̴�.
		this.msgOut = (JTextArea) c;
	}
	public void refreshData(String msg) {
		//JTextAreaâ�� �ؽ�Ʈ�� �߰��ϴ� �۾��� �Ѵ�.
		msgOut.append(msg);
	}
	public void addObjCombo(JComponent c) {
		//JTextComboBox�� �����͸� ����.
		//������ ������ �Ͼ ������Ʈ�� UI������Ʈ�� ����ϴ� �޼ҵ��̴�.
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
//		ta.append("������ȣ\t��ǰ��\t\t�ܰ�\t������\n");
//		
//		try {
//			datas = pd.getAll();
//			p4_cbx.setModel(new DefaultComboBoxModel(pd.getItems()));
//			if(datas != null) {
//				// ArrayList�� ��ü �����͸� ���Ŀ� ���� ���
//				for(Product p : datas) {
//					StringBuffer sb = new StringBuffer();
//					sb.append(p.getId() + "\t");
//					sb.append(p.getName() + "\t\t");
//					sb.append(p.getPrice() + "\t");
//					sb.append(p.getManufacture() + "\n");
//					ta.append(sb.toString());
//				}
//			} else {
//				ta.append("��ϵ� ��ǰ�� �����ϴ�. !!\n��ǰ�� ����� �ּ��� !!");
//			}
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//	}
}