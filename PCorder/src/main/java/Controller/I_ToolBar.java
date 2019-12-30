package Controller;

import javax.swing.JButton;
import javax.swing.JToolBar;

public interface I_ToolBar {
	JToolBar bar = new JToolBar();
	JButton previousBtn = new JButton("< 이전");
	JButton nextBtn = new JButton("> 앞으로");
	JButton loginBtn = new JButton("로그인");
	JButton logoutBtn = new JButton("로그아웃");
	void previousButton();
	void nextButton();
	void loginButton();
	void separator();
}
