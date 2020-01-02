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
<<<<<<< HEAD
	private static ProdManager PM = new ProdManager();
	LoginView LV = LoginView.getInstance();
	JLabel title = new JLabel("상품관리");
	public JLabel stateText = new JLabel("## 메시지 : ");
=======
	public static ProdManager PM = ProdManager.getInstance();
	LoginView LV = LoginView.getInstance();
	JLabel title = new JLabel("�긽�뭹愿�由�");
	public JLabel stateText = new JLabel("## 硫붿떆吏� : ");
>>>>>>> origin/project1
	JPanel leftPanel = new JPanel();
	JPanel rightPanel = new JPanel();
	JPanel wrapPanel = new JPanel();
	JPanel northPanel = new JPanel();
<<<<<<< HEAD
	String[] prodLabel_str = { "상품 번호", "상품명", "단가", "제조사" };
=======
	String[] prodLabel_str = { "�긽�뭹 踰덊샇", "�긽�뭹紐�", "�떒媛�", "�젣議곗궗" };
>>>>>>> origin/project1
	JLabel[] prodLabel = new JLabel[4];
	public Vector<Model.Product_DTO> v = new Vector<Model.Product_DTO>();
	public JComboBox<String> prodCombo = new JComboBox<String>();
	public JTextField[] prodtf = new JTextField[3];
<<<<<<< HEAD
	String[] List_prodType = {"라면류", "음료류", "간식류", "과자류"};
	public JComboBox<String> prodType = new JComboBox<String>(List_prodType);
	String ta_col = "관리번호\t상품명\t단가\t제조사";
	public JTextArea ta = new JTextArea(ta_col, 27, 30);
	String[] btn_str = {"등록", "조회", "삭제"};
=======
	String[] List_prodType = {"�씪硫대쪟", "�쓬猷뚮쪟", "媛꾩떇瑜�", "怨쇱옄瑜�"};
	public JComboBox<String> prodType = new JComboBox<String>(List_prodType);
	String ta_col = "愿�由щ쾲�샇\t�긽�뭹紐�\t�떒媛�\t�젣議곗궗";
	public JTextArea ta = new JTextArea(ta_col, 27, 30);
	String[] btn_str = { "�벑濡�", "議고쉶", "�궘�젣" };
>>>>>>> origin/project1
	public JButton[] btn = new JButton[3];

	private ProductPanel PP = new ProductPanel();
	private ShowPanel SP = new ShowPanel();

	JToolBar bar = new JToolBar();
<<<<<<< HEAD
	public JButton previousBtn = new JButton("< 이전");
	public JButton logoutBtn = new JButton("로그아웃");

	private ProdManager() {
		super("상품관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		// 툴바 interface
=======
	public JButton previousBtn = new JButton("< �씠�쟾");
	public JButton logoutBtn = new JButton("濡쒓렇�븘�썐");
	
	private ProdManager() {
		super("�긽�뭹愿�由�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		// �댋諛� interface
>>>>>>> origin/project1
		bar.add(previousBtn);
		bar.addSeparator(new Dimension(750, 30));
		bar.add(logoutBtn);
		add(bar, BorderLayout.NORTH);
<<<<<<< HEAD

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());


		wrapPanel.setLayout(new GridLayout(1,2));
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

		// title 폰트 크기
		title.setFont(new Font("굴림", Font.BOLD, 45));

		// 오른쪽 정렬
=======
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		wrapPanel.setLayout(new GridLayout(1, 2));
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

		// title �룿�듃 �겕湲�
		title.setFont(new Font("援대┝", Font.BOLD, 45));
		
		// �삤瑜몄そ �젙�젹
>>>>>>> origin/project1
		leftPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

		northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
		title.setAlignmentX(CENTER_ALIGNMENT);

		stateText.setAlignmentX(CENTER_ALIGNMENT);
<<<<<<< HEAD
		stateText.setFont(new Font("고딕체", Font.ITALIC, 14));
		stateText.setForeground(Color.BLACK); // 메세지 뜰때마다 빨강으로 전환하기
=======
		stateText.setFont(new Font("怨좊뵓泥�", Font.ITALIC, 14));
		stateText.setForeground(Color.BLACK); // 硫붿꽭吏� �쑑�븣留덈떎 鍮④컯�쑝濡� �쟾�솚�븯湲�
>>>>>>> origin/project1

		northPanel.add(title);
		northPanel.add(stateText);
		panel.add(northPanel, BorderLayout.NORTH);
		leftPanel.add(PP);
		wrapPanel.add(leftPanel);

		rightPanel.add(SP);
		wrapPanel.add(rightPanel);
		panel.add(wrapPanel, BorderLayout.CENTER);
<<<<<<< HEAD

		add(panel, BorderLayout.CENTER);

		setSize(900, 700);
		setLocationRelativeTo(null);
		// 크기 고정
        //setResizable(false);

=======
		
		add(panel, BorderLayout.CENTER);
		
		setSize(900, 700);
		setLocationRelativeTo(null);
		// �겕湲� 怨좎젙
        setResizable(false);
        
>>>>>>> origin/project1
		setVisible(false);
	}

	public class ProductPanel extends JPanel {
		public ProductPanel() {
<<<<<<< HEAD
			setLayout(new GridLayout(5, 2, 10, 40));
			setPreferredSize(new Dimension((int) (400), (int) (400)));

			for (int i = 0; i < 4; i++) {
				prodLabel[i] = new JLabel(prodLabel_str[i]);
				prodLabel[i].setFont(new Font("고딕체", Font.PLAIN, 16));
				add(prodLabel[i]);

				if (i == 0) {
					prodCombo.addItem("전체");
=======
			setLayout(new GridLayout(4, 2, 10, 30));
			setPreferredSize(new Dimension((int) (400), (int) (300)));

			for (int i = 0; i < 4; i++) {
				prodLabel[i] = new JLabel(prodLabel_str[i]);
				prodLabel[i].setFont(new Font("怨좊뵓泥�", Font.PLAIN, 16));
				add(prodLabel[i]);

				if (i == 0) {
					prodCombo.addItem("�쟾泥�");
>>>>>>> origin/project1
					add(prodCombo);
				}
				else {
					prodtf[i - 1] = new JTextField();
					add(prodtf[i - 1]);
				}
			}
<<<<<<< HEAD
			add(new JLabel("카테고리"));
=======
>>>>>>> origin/project1
			add(prodType);
		}
	}// ProductPanel

	public class ShowPanel extends JPanel {
<<<<<<< HEAD

	      public ShowPanel() {

	         setLayout(new GridLayout(2, 1));
	         ta.setEditable(false);
	         add(new JScrollPane(ta));
	         JPanel pa = new JPanel();
	         for (int i = 0; i < 3; i++) {

	            btn[i] = new JButton(btn_str[i]);
	            btn[i].setBackground(Color.black);
	            btn[i].setFont(new Font("고딕체", Font.PLAIN, 20));
	            btn[i].setForeground(Color.WHITE);

	            pa.add(btn[i]);
	         }
	         add(pa);
	      }

	   }
	public static ProdManager getInstance() {
=======
		
		public ShowPanel() {
			setLayout(new GridLayout(2, 1));
			ta.setEditable(false);
			add(new JScrollPane(ta));
			JPanel pa = new JPanel();
			for (int i = 0; i < 3; i++) {

				btn[i] = new JButton(btn_str[i]);
				btn[i].setBackground(Color.black);
				btn[i].setFont(new Font("怨좊뵓泥�", Font.PLAIN, 20));
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
>>>>>>> origin/project1
		return PM;
	}
	public void addButtonActionListener(ActionListener listener) {
		previousBtn.addActionListener(listener);
		logoutBtn.addActionListener(listener);
		for(int i=0;i<3;i++)
			btn[i].addActionListener(listener);
		prodCombo.addActionListener(listener);
	}
<<<<<<< HEAD
}
=======
}
>>>>>>> origin/project1
