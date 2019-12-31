package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JViewport;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;


public class CusManager extends JFrame {
	private static CusManager CM = new CusManager();
	private static Container c;
	JLabel title = new JLabel("°í°´°ü¸®");
	JPanel leftPanel = new JPanel();
	JPanel rightPanel = new JPanel();
	JComboBox<String> chatSeat = new JComboBox<String>();
	JTextArea chatContent = new JTextArea("", 12, 50);
	JTextField chatInput = new JTextField(10);
	JButton chatSubmit = new JButton("send");
	JLabel order[];
	TitledBorder border = new TitledBorder(new LineBorder(Color.BLACK), "ÁÂ¼®");
	JViewport vp = new JViewport();
	JPanel msgPanel = new JPanel();
	JPanel seatPanel = new JPanel();
	LoginView LV = LoginView.getInstance();
	private SeatPanel SP = new SeatPanel();
	private ChatPanel CP = new ChatPanel();

	JToolBar bar = new JToolBar();
	JButton previousBtn = new JButton("< ÀÌÀü");
	JButton logoutBtn = new JButton("·Î±×¾Æ¿ô");
	private CusManager() {
		super("°í°´°ü¸®");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Åø¹Ù interface
		bar.add(previousBtn);
		bar.addSeparator(new Dimension(750, 30));
		bar.add(logoutBtn);
		add(bar, BorderLayout.NORTH);
		
		JLayeredPane layeredpane = new JLayeredPane();
		layeredpane.setBounds(0, 0, 700, 600);
		layeredpane.setLayout(null);

		layeredpane.setLayout(new GridLayout(1, 2));

		leftPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 40));
		title.setFont(new Font("°íµñÃ¼", Font.BOLD, 38));
		leftPanel.add(title);
		leftPanel.add(SP);
		layeredpane.add(leftPanel);

		rightPanel.add(CP);
		layeredpane.add(rightPanel);
		add(layeredpane);
		setSize(900, 700);
		setLocationRelativeTo(null);
		// Å©±â °íÁ¤
		super.setResizable(false);
		
		setVisible(false);
		previousBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				LV.getInstance().setVisible(true);
				
			}
		});
		logoutBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				LV.getInstance().setVisible(true);
				LV.getInstance().cardLayout.show(LV.getInstance().window, "layer");
			}
		});
		chatInput.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				chatInput.getText();
				chatContent.setText(chatContent.getText() + chatInput.getText() + "\n");
				chatInput.setText("");
			}
		});
	}

	public static CusManager getInstance() {
		return CM;
	}
	public class SeatPanel extends JPanel {
		JButton[] seatBtn = new JButton[12];

		public SeatPanel() {
			setLayout(new GridLayout(3, 4, 10, 10));
			for (int i = 0; i < seatBtn.length; i++) {

				add(seatBtn[i] = new JButton(""));

				seatBtn[i].setPreferredSize(new Dimension((int) (100), (int) (120))); //
				seatBtn[i].setBackground(new Color(255, 255, 255));
				seatBtn[i].setFont(new Font("°íµñÃ¼", Font.BOLD, 16));
				seatBtn[i].setForeground(Color.BLACK);

			}
		}
	}// SeatPanel

	public class ChatPanel extends JPanel {

		public ChatPanel() {

			setLayout(new BorderLayout());
			setBorder(border);
			setPreferredSize(new Dimension((int) (350), (int) (600))); // Ã¤ÆÃÃ¢
			seatPanel.setLayout(new BorderLayout());

			seatPanel.add(BorderLayout.NORTH, chatSeat);
			add(seatPanel, BorderLayout.NORTH);

			vp.add(new JScrollPane(chatContent));
			chatContent.setEditable(false);
			add(vp, BorderLayout.CENTER);

			msgPanel.setLayout(new BorderLayout());
			msgPanel.add(BorderLayout.CENTER, chatInput);

			chatSubmit.setBackground(Color.black);
			chatSubmit.setFont(new Font("°íµñÃ¼", Font.PLAIN, 15));
			chatSubmit.setForeground(Color.WHITE);
			msgPanel.add(BorderLayout.EAST, chatSubmit);
			add(msgPanel, BorderLayout.SOUTH);
		}
	}// ChatPanel
}