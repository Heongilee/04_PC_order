package View;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

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
	public JComboBox<String> chatComboBox = new JComboBox<String>();
	public JTextArea chatContent = new JTextArea("", 12, 50);
	public JTextField chatInput = new JTextField();
	JButton chatSubmit = new JButton("send");
	JLabel order[];
	TitledBorder border = new TitledBorder(new LineBorder(Color.BLACK), "ÁÂ¼®");
	JViewport vp = new JViewport();
	JPanel msgPanel = new JPanel();
	public JPanel seatPanel = new JPanel();
	LoginView LV = LoginView.getInstance();
	private SeatPanel SP = new SeatPanel();
	public ChatPanel CP = new ChatPanel();
	
	JToolBar bar = new JToolBar();
	public JButton previousBtn = new JButton("< ÀÌÀü");
	public JButton logoutBtn = new JButton("·Î±×¾Æ¿ô");
	
	public boolean loginFlag = false;
	
	public JPanel chatBang = new JPanel();
	
	public String id = "°ü¸®ÀÚ";
	
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

			seatPanel.add(BorderLayout.NORTH, chatComboBox);
			add(seatPanel, BorderLayout.NORTH);

			vp.add(new JScrollPane(chatContent));
			chatContent.setEditable(false);
			add(vp, BorderLayout.CENTER);
			
//			JViewport jp = new JViewport();
//			JPanel panel = new JPanel();
//			CardLayout card = new CardLayout();
//			panel.setLayout(card);
//			panel.add(vp, "hoit");
//			panel.add(jp, "hosss");
//			
//			add(panel, BorderLayout.CENTER);
//			card.show(panel, "hoit");
			
			msgPanel.setLayout(new BorderLayout());
			msgPanel.add(BorderLayout.CENTER, chatInput);

			chatSubmit.setBackground(Color.black);
			chatSubmit.setFont(new Font("°íµñÃ¼", Font.PLAIN, 15));
			chatSubmit.setForeground(Color.WHITE);
			msgPanel.add(BorderLayout.EAST, chatSubmit);
			add(msgPanel, BorderLayout.SOUTH);
		}
	}// ChatPanel
	
	public class ChatSeatContent {
		private String seat;
		public String getSeat() {
			return seat;
		}
		public void setSeat(String seat){
			this.seat = seat;
		}
//		public String toString() {
//			return this.id+"\t"+this.name+"\t\t\t"+this.price+"\t"+this.manufacture;
//		}
	}
	public void addButtonActionListener(ActionListener listener) {
		chatInput.addActionListener(listener);
		previousBtn.addActionListener(listener);
		logoutBtn.addActionListener(listener);
		chatComboBox.addActionListener(listener);
	}
}