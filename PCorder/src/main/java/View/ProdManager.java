package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;

//annotation test
public class ProdManager extends JFrame {
	public static ProdManager PM = ProdManager.getInstance();
	LoginView LV = LoginView.getInstance();
	JLabel title = new JLabel("��ǰ����");
	public JLabel stateText = new JLabel("## �޽��� : ");
	JPanel leftPanel = new JPanel();
	JPanel rightPanel = new JPanel();
	JPanel wrapPanel = new JPanel();
	JPanel northPanel = new JPanel();
	String[] prodLabel_str = { "��ǰ ��ȣ", "��ǰ��", "�ܰ�", "������" };
	JLabel[] prodLabel = new JLabel[4];
	public Vector<Model.Product_DTO> v = new Vector<Model.Product_DTO>();
	public JComboBox<String> prodCombo = new JComboBox<String>();
	JTextField[] prodtf = new JTextField[3];
	String ta_col = "������ȣ\t��ǰ��\t�ܰ�\t������";
	public JTextArea ta = new JTextArea(ta_col, 27, 30);
	String[] btn_str = { "���", "��ȸ", "����" };
	public JButton[] btn = new JButton[3];

	private ProductPanel PP = new ProductPanel();
	private ShowPanel SP = new ShowPanel();

	JToolBar bar = new JToolBar();
	public JButton previousBtn = new JButton("< ����");
	public JButton logoutBtn = new JButton("�α׾ƿ�");
	
	private ProdManager() {
		super("��ǰ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		// ���� interface
		bar.add(previousBtn);
		bar.addSeparator(new Dimension(750, 30));
		bar.add(logoutBtn);
		add(bar, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		wrapPanel.setLayout(new GridLayout(1, 2));
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

		// title ��Ʈ ũ��
		title.setFont(new Font("����", Font.BOLD, 45));
		// ������ ����
		leftPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

		northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
		title.setAlignmentX(CENTER_ALIGNMENT);

		stateText.setAlignmentX(CENTER_ALIGNMENT);
		stateText.setFont(new Font("���ü", Font.ITALIC, 14));
		stateText.setForeground(Color.BLACK); // �޼��� �㶧���� �������� ��ȯ�ϱ�

		northPanel.add(title);
		northPanel.add(stateText);
		panel.add(northPanel, BorderLayout.NORTH);
		leftPanel.add(PP);
		wrapPanel.add(leftPanel);

		rightPanel.add(SP);
		wrapPanel.add(rightPanel);
		panel.add(wrapPanel, BorderLayout.CENTER);
		
		add(panel, BorderLayout.CENTER);
		
		setSize(900, 700);
		setLocationRelativeTo(null);
		// ũ�� ����
        setResizable(false);
        
		setVisible(false);
	}

	public class ProductPanel extends JPanel {
		public ProductPanel() {
			setLayout(new GridLayout(4, 2, 10, 30));
			setPreferredSize(new Dimension((int) (400), (int) (300)));

			for (int i = 0; i < 4; i++) {
				prodLabel[i] = new JLabel(prodLabel_str[i]);
				prodLabel[i].setFont(new Font("���ü", Font.PLAIN, 16));
				add(prodLabel[i]);

				if (i == 0) {
					add(prodCombo);
				}
				else {
					prodtf[i - 1] = new JTextField();
					add(prodtf[i - 1]);
				}
			}
		}
	}// ProductPanel

	public class ShowPanel extends JPanel {

		public ShowPanel() {

			setLayout(new GridLayout(2, 1));
			ta.setEditable(false);
			add(new JScrollPane(ta));
			JPanel pa = new JPanel();
			for (int i = 0; i < 3; i++) {

				btn[i] = new JButton(btn_str[i]);
				btn[i].setBackground(Color.black);
				btn[i].setFont(new Font("���ü", Font.PLAIN, 20));
				btn[i].setForeground(Color.WHITE);

				pa.add(btn[i]);
			}
			add(pa);
		}
	}
	public static ProdManager getInstance() {
		if(PM == null) {
			PM = new ProdManager();
		}
		return PM;
	}
	public void addButtonActionListener(ActionListener listener) {
		previousBtn.addActionListener(listener);
		logoutBtn.addActionListener(listener);
		for(int i=0;i<3;i++)
			btn[i].addActionListener(listener);
	}
}