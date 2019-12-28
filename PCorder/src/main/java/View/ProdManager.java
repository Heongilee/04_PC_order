package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
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

public class ProdManager {
	public class ProdManagerAppMain extends JFrame {
		private Container c;
		JLabel title = new JLabel("��ǰ����");
		JLabel stateText = new JLabel("##");
		JPanel leftPanel = new JPanel();
		JPanel rightPanel = new JPanel();
		JPanel wrapPanel = new JPanel();
		JPanel northPanel = new JPanel();
		String[] prodLabel_str = {"��ǰ ��ȣ", "��ǰ��", "�ܰ�", "������"};
		JLabel[] prodLabel = new JLabel[4];
		JComboBox<String> prodCombo = new JComboBox<String>();
		JTextField[] prodtf = new JTextField[3];
		String ta_col = "������ȣ\t��ǰ��\t�ܰ�\t������";
		JTextArea ta = new JTextArea(ta_col, 15, 30);
		String[] btn_str = {"���", "��ȸ", "����"};
		JButton[] btn = new JButton[3];
		private ProductPanel PP = new ProductPanel();
		private ShowPanel SP = new ShowPanel();
		public ProdManagerAppMain() {
			super("��ǰ����");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			c = getContentPane();
			c.setLayout(new BorderLayout());
			wrapPanel.setLayout(new GridLayout(1,2));
			leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
			
			//title ��Ʈ ũ��
			title.setFont(new Font("����", Font.BOLD, 50));
			//������ ����
			leftPanel.setLayout(new FlowLayout( FlowLayout.RIGHT ));
			
			northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
			title.setAlignmentX(CENTER_ALIGNMENT);
			stateText.setAlignmentX(CENTER_ALIGNMENT);
			northPanel.add(title);
			northPanel.add(stateText);
			c.add(northPanel, BorderLayout.NORTH);
			leftPanel.add(PP);
			wrapPanel.add(leftPanel);
			
			rightPanel.add(SP);
			wrapPanel.add(rightPanel);
			c.add(wrapPanel, BorderLayout.CENTER);
			setSize(700,452);
			setLocationRelativeTo(null);
			// ũ�� ����
//	        super.setResizable(false);
			setVisible(true);
		}
		public class ProductPanel extends JPanel {
//			final String[] seatName = {""}
			
			public ProductPanel() {
				setLayout(new GridLayout(4,2,10,30));
				setPreferredSize(new Dimension((int)(300), (int)(250)));
				for(int i=0;i<4;i++)
				{
					prodLabel[i] = new JLabel(prodLabel_str[i]);
					add(prodLabel[i]);
					
					if(i == 0) add(prodCombo);
					else {
						prodtf[i - 1] = new JTextField();
						add(prodtf[i - 1]);
					}
				}
			}
		}// ProductPanel
		public class ShowPanel extends JPanel {
			
			public ShowPanel() {
				
				setLayout(new GridLayout(2,1));
				ta.setEditable(false);
				add(new JScrollPane(ta));
				JPanel pa = new JPanel();
				for(int i=0;i<3;i++) 
				{
					btn[i] = new JButton(btn_str[i]);
					pa.add(btn[i]);
				}
				add(pa);
			}
		}// ShowPanel
	}
}
