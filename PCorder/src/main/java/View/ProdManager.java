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
	JLabel title = new JLabel("ªÛ«∞∞¸∏Æ");
	public JLabel stateText = new JLabel("## ∏ﬁΩ√¡ˆ : ");
=======
	public static ProdManager PM = ProdManager.getInstance();
	LoginView LV = LoginView.getInstance();
	JLabel title = new JLabel("ÏÉÅÌíàÍ¥ÄÎ¶¨");
	public JLabel stateText = new JLabel("## Î©îÏãúÏßÄ : ");
>>>>>>> origin/project1
	JPanel leftPanel = new JPanel();
	JPanel rightPanel = new JPanel();
	JPanel wrapPanel = new JPanel();
	JPanel northPanel = new JPanel();
<<<<<<< HEAD
	String[] prodLabel_str = { "ªÛ«∞ π¯»£", "ªÛ«∞∏Ì", "¥‹∞°", "¡¶¡∂ªÁ" };
=======
	String[] prodLabel_str = { "ÏÉÅÌíà Î≤àÌò∏", "ÏÉÅÌíàÎ™Ö", "Îã®Í∞Ä", "Ï†úÏ°∞ÏÇ¨" };
>>>>>>> origin/project1
	JLabel[] prodLabel = new JLabel[4];
	public Vector<Model.Product_DTO> v = new Vector<Model.Product_DTO>();
	public JComboBox<String> prodCombo = new JComboBox<String>();
	public JTextField[] prodtf = new JTextField[3];
<<<<<<< HEAD
	String[] List_prodType = {"∂Û∏È∑˘", "¿Ω∑·∑˘", "∞£Ωƒ∑˘", "∞˙¿⁄∑˘"};
	public JComboBox<String> prodType = new JComboBox<String>(List_prodType);
	String ta_col = "∞¸∏Æπ¯»£\tªÛ«∞∏Ì\t¥‹∞°\t¡¶¡∂ªÁ";
	public JTextArea ta = new JTextArea(ta_col, 27, 30);
	String[] btn_str = {"µÓ∑œ", "¡∂»∏", "ªË¡¶"};
=======
	String[] List_prodType = {"ÎùºÎ©¥Î•ò", "ÏùåÎ£åÎ•ò", "Í∞ÑÏãùÎ•ò", "Í≥ºÏûêÎ•ò"};
	public JComboBox<String> prodType = new JComboBox<String>(List_prodType);
	String ta_col = "Í¥ÄÎ¶¨Î≤àÌò∏\tÏÉÅÌíàÎ™Ö\tÎã®Í∞Ä\tÏ†úÏ°∞ÏÇ¨";
	public JTextArea ta = new JTextArea(ta_col, 27, 30);
	String[] btn_str = { "Îì±Î°ù", "Ï°∞Ìöå", "ÏÇ≠Ï†ú" };
>>>>>>> origin/project1
	public JButton[] btn = new JButton[3];

	private ProductPanel PP = new ProductPanel();
	private ShowPanel SP = new ShowPanel();

	JToolBar bar = new JToolBar();
<<<<<<< HEAD
	public JButton previousBtn = new JButton("< ¿Ã¿¸");
	public JButton logoutBtn = new JButton("∑Œ±◊æ∆øÙ");

	private ProdManager() {
		super("ªÛ«∞∞¸∏Æ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		// ≈¯πŸ interface
=======
	public JButton previousBtn = new JButton("< Ïù¥Ï†Ñ");
	public JButton logoutBtn = new JButton("Î°úÍ∑∏ÏïÑÏõÉ");
	
	private ProdManager() {
		super("ÏÉÅÌíàÍ¥ÄÎ¶¨");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		// Ìà¥Î∞î interface
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

		// title ∆˘∆Æ ≈©±‚
		title.setFont(new Font("±º∏≤", Font.BOLD, 45));

		// ø¿∏•¬  ¡§∑ƒ
=======
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		wrapPanel.setLayout(new GridLayout(1, 2));
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

		// title Ìè∞Ìä∏ ÌÅ¨Í∏∞
		title.setFont(new Font("Íµ¥Î¶º", Font.BOLD, 45));
		
		// Ïò§Î•∏Ï™Ω Ï†ïÎ†¨
>>>>>>> origin/project1
		leftPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

		northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
		title.setAlignmentX(CENTER_ALIGNMENT);

		stateText.setAlignmentX(CENTER_ALIGNMENT);
<<<<<<< HEAD
		stateText.setFont(new Font("∞ÌµÒ√º", Font.ITALIC, 14));
		stateText.setForeground(Color.BLACK); // ∏ﬁºº¡ˆ ∂„∂ß∏∂¥Ÿ ª°∞≠¿∏∑Œ ¿¸»Ø«œ±‚
=======
		stateText.setFont(new Font("Í≥†ÎîïÏ≤¥", Font.ITALIC, 14));
		stateText.setForeground(Color.BLACK); // Î©îÏÑ∏ÏßÄ Îú∞ÎïåÎßàÎã§ Îπ®Í∞ïÏúºÎ°ú Ï†ÑÌôòÌïòÍ∏∞
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
		// ≈©±‚ ∞Ì¡§
        //setResizable(false);

=======
		
		add(panel, BorderLayout.CENTER);
		
		setSize(900, 700);
		setLocationRelativeTo(null);
		// ÌÅ¨Í∏∞ Í≥†Ï†ï
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
				prodLabel[i].setFont(new Font("∞ÌµÒ√º", Font.PLAIN, 16));
				add(prodLabel[i]);

				if (i == 0) {
					prodCombo.addItem("¿¸√º");
=======
			setLayout(new GridLayout(4, 2, 10, 30));
			setPreferredSize(new Dimension((int) (400), (int) (300)));

			for (int i = 0; i < 4; i++) {
				prodLabel[i] = new JLabel(prodLabel_str[i]);
				prodLabel[i].setFont(new Font("Í≥†ÎîïÏ≤¥", Font.PLAIN, 16));
				add(prodLabel[i]);

				if (i == 0) {
					prodCombo.addItem("Ï†ÑÏ≤¥");
>>>>>>> origin/project1
					add(prodCombo);
				}
				else {
					prodtf[i - 1] = new JTextField();
					add(prodtf[i - 1]);
				}
			}
<<<<<<< HEAD
			add(new JLabel("ƒ´≈◊∞Ì∏Æ"));
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
	            btn[i].setFont(new Font("∞ÌµÒ√º", Font.PLAIN, 20));
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
				btn[i].setFont(new Font("Í≥†ÎîïÏ≤¥", Font.PLAIN, 20));
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
