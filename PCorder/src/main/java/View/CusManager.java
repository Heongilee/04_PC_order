package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class CusManager {
	public class CusManagerAppMain extends JFrame {
		private Container c;
		JLabel title = new JLabel("°í°´°ü¸®");
		JPanel leftPanel = new JPanel();
		JPanel rightPanel = new JPanel();
		JComboBox<String> chatSeat = new JComboBox<String>();
		JTextArea chatContent = new JTextArea("",12,47);
		JTextField chatInput = new JTextField(10);
		JButton chatSubmit = new JButton("send");
		TitledBorder border = new TitledBorder(new LineBorder(Color.BLACK), "ÁÂ¼®");
		JViewport vp = new JViewport();
		JPanel msgPanel = new JPanel();
		JPanel seatPanel = new JPanel();
		private SeatPanel SP = new SeatPanel();
		private ChatPanel CP = new ChatPanel();
		public CusManagerAppMain() {
			super("°í°´°ü¸®");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			c = getContentPane();
			c.setLayout(new GridLayout(1,2));
			
			leftPanel.setLayout(new FlowLayout(FlowLayout.RIGHT,0,40));
			title.setFont(new Font("±¼¸²", Font.BOLD, 50));
			leftPanel.add(title);
			leftPanel.add(SP);
			c.add(leftPanel);
			
			rightPanel.add(CP);
			c.add(rightPanel);
			setSize(700,452);
			setLocationRelativeTo(null);
			// Å©±â °íÁ¤
	        super.setResizable(false);
			setVisible(true);
		}
		public class SeatPanel extends JPanel {
//			final String[] seatName = {""}
			JButton[] seatBtn = new JButton[12];
			public SeatPanel() {
				setLayout(new GridLayout(3,4,10,10));
				for(int i=0;i<seatBtn.length;i++) {
					
					add(seatBtn[i] = new JButton(Integer.toString(i+1)));
					
					seatBtn[i].setPreferredSize(new Dimension((int)(70), (int)(70)));
					seatBtn[i].setBackground(new Color(255, 255, 255));
					seatBtn[i].setFont(new Font("±¼¸²", Font.BOLD, 16));
					seatBtn[i].setForeground(Color.BLACK);
				}
			}
		}// SeatPanel
		public class ChatPanel extends JPanel {
			
			public ChatPanel() {
				
				setLayout(new BorderLayout());
				setBorder(border);
				setPreferredSize(new Dimension((int)(300), (int)(400)));
				seatPanel.setLayout(new BorderLayout());
				seatPanel.add(BorderLayout.NORTH,chatSeat);
				add(seatPanel,BorderLayout.NORTH);
				
				vp.add(new JScrollPane(chatContent));
				chatContent.setEditable(false);
				add(vp, BorderLayout.CENTER);
				
				msgPanel.setLayout(new BorderLayout());
				msgPanel.add(BorderLayout.CENTER,chatInput);
				msgPanel.add(BorderLayout.EAST,chatSubmit);
				add(msgPanel,BorderLayout.SOUTH);
				}
			}
		}// ChatPanel
}
