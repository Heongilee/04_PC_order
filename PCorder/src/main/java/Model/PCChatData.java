package Model;

<<<<<<< HEAD
import javax.swing.JComboBox;
=======
>>>>>>> origin/project1
import javax.swing.JComponent;
import javax.swing.JTextArea;

public class PCChatData {
<<<<<<< HEAD
	public JComboBox<String> comboItem;
	public JTextArea msgOut; 
	public void addObjCus(JComponent c) {
		//JTextAreaÀÇ µ¥ÀÌÅÍ¸¦ °ü¸®.
		//µ¥ÀÌÅÍ º¯°æÀÌ ÀÏ¾î³ª ¾÷µ¥ÀÌÆ®ÇÒ UIÄÄÆ÷³ÍÆ®¸¦ µî·ÏÇÏ´Â ¸Ş¼ÒµåÀÌ´Ù.
		this.msgOut = (JTextArea) c;
	}
	public void addObjGUI(JComponent c) {
		//JTextAreaÀÇ µ¥ÀÌÅÍ¸¦ °ü¸®.
		//µ¥ÀÌÅÍ º¯°æÀÌ ÀÏ¾î³ª ¾÷µ¥ÀÌÆ®ÇÒ UIÄÄÆ÷³ÍÆ®¸¦ µî·ÏÇÏ´Â ¸Ş¼ÒµåÀÌ´Ù.
		this.msgOut = (JTextArea) c;
	}
	public void refreshData(String msg) {
		//JTextAreaÃ¢¿¡ ÅØ½ºÆ®¸¦ Ãß°¡ÇÏ´Â ÀÛ¾÷¸¸ ÇÑ´Ù.
		msgOut.append(msg);
	}
	public void addObjCombo(JComponent c) {
		//JTextComboBoxÀÇ µ¥ÀÌÅÍ¸¦ °ü¸®.
		//µ¥ÀÌÅÍ º¯°æÀÌ ÀÏ¾î³ª ¾÷µ¥ÀÌÆ®ÇÒ UIÄÄÆ÷³ÍÆ®¸¦ µî·ÏÇÏ´Â ¸Ş¼ÒµåÀÌ´Ù.
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
//		ta.append("°ü¸®¹øÈ£\t»óÇ°¸í\t\t´Ü°¡\tÁ¦Á¶»ç\n");
//		
//		try {
//			datas = pd.getAll();
//			p4_cbx.setModel(new DefaultComboBoxModel(pd.getItems()));
//			if(datas != null) {
//				// ArrayListÀÇ ÀüÃ¼ µ¥ÀÌÅÍ¸¦ Çü½Ä¿¡ ¸ÂÃç Ãâ·Â
//				for(Product p : datas) {
//					StringBuffer sb = new StringBuffer();
//					sb.append(p.getId() + "\t");
//					sb.append(p.getName() + "\t\t");
//					sb.append(p.getPrice() + "\t");
//					sb.append(p.getManufacture() + "\n");
//					ta.append(sb.toString());
//				}
//			} else {
//				ta.append("µî·ÏµÈ »óÇ°ÀÌ ¾ø½À´Ï´Ù. !!\n»óÇ°À» µî·ÏÇØ ÁÖ¼¼¿ä !!");
//			}
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//	}
=======
	public JTextArea msgOut;
	
	public void addObjCus(JComponent c) {
		//JTextAreaì˜ ë°ì´í„°ë¥¼ ê´€ë¦¬.
		//ë°ì´í„° ë³€ê²½ì´ ì¼ì–´ë‚˜ ì—…ë°ì´íŠ¸í•  UIì»´í¬ë„ŒíŠ¸ë¥¼ ë“±ë¡í•˜ëŠ” ë©”ì†Œë“œì´ë‹¤.
		this.msgOut = (JTextArea) c;
	}
	public void addObjGUI(JComponent c) {
		//JTextAreaì˜ ë°ì´í„°ë¥¼ ê´€ë¦¬.
		//ë°ì´í„° ë³€ê²½ì´ ì¼ì–´ë‚˜ ì—…ë°ì´íŠ¸í•  UIì»´í¬ë„ŒíŠ¸ë¥¼ ë“±ë¡í•˜ëŠ” ë©”ì†Œë“œì´ë‹¤.
		this.msgOut = (JTextArea) c;
	}
	public void refreshData(String msg) {
		//JTextAreaì°½ì— í…ìŠ¤íŠ¸ë¥¼ ì¶”ê°€í•˜ëŠ” ì‘ì—…ë§Œ í•œë‹¤.
		msgOut.append(msg);
	}
>>>>>>> origin/project1
}