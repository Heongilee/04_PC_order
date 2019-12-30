package View;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	public LoginView ChangeLogin = null;
	public SignUpView ChangeSign = null;
	public AdminView ChangeAdmin = null;
	public CardLayout cardLayout;
	public JPanel window;

	public void change(String PN) {// PN = 패널 이름
		// window = new JPanel();

		// cardLayout = new CardLayout();

		// window.setLayout(cardLayout);

		// window.add(ChangeSign, "NAME_signUp");
		// window.add(ChangeLogin, "NAME_Longin");

		if (PN.equals("ChLogin")) // mainf.change("ChLogin");<- 이렇게 불러오면 됨
		{
			// window.add(ChangeLogin, "NAME_Longin");
			getContentPane().removeAll();
			getContentPane().add(ChangeLogin);
			revalidate();
			repaint();
		} else if (PN.equals("ChSign"))

		{

			getContentPane().removeAll();

			// cardLayout.show(window, "NAME_signUp");
			// add(window);
			getContentPane().add(ChangeSign);

			revalidate();
			repaint();

		} else if (PN.equals("ChAmin"))

		{

			getContentPane().removeAll();

			// cardLayout.show(window, "NAME_signUp");
			// add(window);
			getContentPane().add(ChangeAdmin);

			revalidate();
			repaint();
		} else if (PN.equals("Close"))

		{

			dispose();

		}

	}

	public static void main(String[] args) {
		MainFrame mainf = new MainFrame();

		mainf.setTitle("4조 임당 ~ ");

		mainf.ChangeLogin = new LoginView(mainf);
		mainf.ChangeSign = new SignUpView(mainf);
		mainf.ChangeAdmin = new AdminView(mainf);

		mainf.add(mainf.ChangeLogin);
		mainf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainf.setSize(700, 600);
		mainf.setVisible(true);
	}

}
