package Controller;

import javax.swing.JButton;
import javax.swing.JToolBar;

public interface I_ToolBar {
	JToolBar bar = new JToolBar();
	JButton previousBtn = new JButton("< ����");
	JButton nextBtn = new JButton("> ������");
	JButton loginBtn = new JButton("�α���");
	JButton logoutBtn = new JButton("�α׾ƿ�");
	void previousButton();
	void nextButton();
	void loginButton();
	void separator();
}
