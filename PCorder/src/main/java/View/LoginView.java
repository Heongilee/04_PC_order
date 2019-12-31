package View;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;


public class LoginView extends JPanel {
	protected CardLayout cardLayout;
	protected JPanel window;
	SignUpView signUpView;
	AdminView adminView;
	BufferedImage img = null;
	JTextField loginTextField;
	JPasswordField passwordField;
	JButton loginbt, SignUpbtn;
	JLabel idlb;
	JLabel passlb;
	JLabel la;
	
	JRadioButton user = new JRadioButton("user MODE");
	JRadioButton server = new JRadioButton("server MODE");
	ButtonGroup goup = new ButtonGroup();
   
   
	private MainFrame mainf;


  
   public LoginView(MainFrame mainf) {
	   this.mainf = mainf;
     
     // setSize(700, 600);
     
      
    
      
      goup.add(server);
      goup.add(user);
    //  Container c = new Container();

      try {
         // img = ImageIO.read(new File("img/login.jpg"));//img/login.jpg
      } catch (Exception e) {
         e.printStackTrace();
         System.exit(0);
      }

   //   JLayeredPane layeredpane = new JLayeredPane();
   //   layeredpane.setBounds(0, 0, 700, 600);
   //   layeredpane.setLayout(null);

      JPanel panel = new JPanel();
      panel.setBounds(0, 0, 700, 600);
      panel.setLayout(null)      ;
      
      user.setFont(new Font("고딕체", Font.BOLD, 18));
      user.setForeground(Color.BLACK);
      user.setBounds(200, 50, 200, 30);

      add(user);

      server.setFont(new Font("고딕체", Font.BOLD, 18));
      server.setForeground(Color.BLACK);
      server.setBounds(400, 50, 200, 30);

     add(server);

      idlb = new JLabel("아이디");
      idlb.setFont(new Font("고딕체", Font.BOLD, 18));
      idlb.setForeground(Color.BLACK);
      idlb.setBounds(100, 109, 100, 30);
      loginTextField = new JTextField(15);
      loginTextField.setBounds(200, 109, 320, 30);

     add(idlb);
      add(loginTextField);

      passlb = new JLabel("비밀번호");
      passlb.setFont(new Font("고딕체", Font.BOLD, 18));
      passlb.setForeground(Color.BLACK);
      passlb.setBounds(100, 209, 100, 30);
      passwordField = new JPasswordField(15);
      passwordField.setBounds(200, 209, 320, 30);

     add(passlb);
     add(passwordField);

      loginbt = new JButton("로그인");
      loginbt.setBackground(Color.black);
      loginbt.setFont(new Font("고딕체", Font.BOLD, 18));
      loginbt.setForeground(Color.WHITE);
      loginbt.setBounds(240, 300, 200, 48);

      add(loginbt);

      la = new JLabel("or");
      la.setBackground(Color.BLACK);
      la.setFont(new Font("고딕체", Font.PLAIN, 23));
      la.setForeground(Color.BLACK);
      la.setBounds(330, 350, 200, 48);

      add(la);

      SignUpbtn = new JButton("회원가입");
      SignUpbtn.setBackground(Color.black);
      SignUpbtn.setFont(new Font("고딕체", Font.BOLD, 18));
      SignUpbtn.setForeground(Color.WHITE);
      SignUpbtn.setBounds(240, 400, 200, 48);

      add(SignUpbtn);

   add(panel);



     /* window = new JPanel();
      cardLayout = new CardLayout();
      window.setLayout(cardLayout);
      adminView = new AdminView();
    //  signUpView = new SignUpView();
      window.add(layeredpane, "layer");
      window.add(adminView, "admin");
      window.add(signUpView, "signUp");*/
		
 
			
		loginbt.addActionListener(new ActionListener() {  /////***** server 모드 선택하고 로그인 눌렀을떄는 admin card
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub				
			     if (server.isSelected()) {
			    				    	
				mainf.change("ChAmin");
				
			     }
			     // 로그인창 지우기 
			}});

		loginbt.addActionListener(new ActionListener() {  /////***** user 모드 선택하고 로그인 눌렀을떄는 admin card
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			     if (user.isSelected()) {
			  
			
					new GUIView();
					
			     }
			   
			  
			     }});
			
		SignUpbtn.addActionListener(new ActionListener() {  /////***** user 모드 선택하고 로그인 눌렀을떄는 admin card
			@Override
			public void actionPerformed(ActionEvent e) {
				
				mainf.change("ChSign");
				
			}
			});
				

    
  //    add(window);
     //setLocationRelativeTo(null);
     // setVisible(true);
   }
}