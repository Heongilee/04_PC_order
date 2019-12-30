package View;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import Controller.I_ToolBar;

public class AdminView extends JPanel implements I_ToolBar {
   // Login_Panel_Component
   protected CardLayout cardLayout;
   protected Container tab;
   JButton cm_btn = new JButton("고객관리");
   JButton pm_btn = new JButton("상품관리");
   private LoginPanel LP = new LoginPanel();
   JLabel title = new JLabel("Server Mode");
   private static Container c;
   JButton Previousbtn = new JButton("< 이전");
   JButton LogOutbtn = new JButton("로그아웃");
   JPanel window;
   

   public AdminView() {

      JLayeredPane layeredpane = new JLayeredPane();
      layeredpane.setBounds(0, 0, 700, 600);
      layeredpane.setLayout(null);

      setLayout(new BorderLayout());

      cm_btn.setBackground(Color.black);
      cm_btn.setFont(new Font("고딕체", Font.BOLD, 19));
      cm_btn.setForeground(Color.WHITE);
      cm_btn.addActionListener(new MyActionListener());

      pm_btn.setBackground(Color.black);
      pm_btn.setFont(new Font("고딕체", Font.BOLD, 19));
      pm_btn.setForeground(Color.WHITE);
      pm_btn.addActionListener(new MyActionListener());

      title.setFont(new Font("고딕체", Font.BOLD, 29));
      title.setForeground(Color.BLACK);

      cm_btn.setBounds(200, 200, 300, 60);
      pm_btn.setBounds(200, 300, 300, 60);
      title.setBounds(270, 100, 300, 60);

      layeredpane.add(cm_btn);
      layeredpane.add(pm_btn);
      layeredpane.add(title);
      // panel.add(layeredpane);
//         tab = new JPanel();
//          cardLayout = new CardLayout();
//          tab.setLayout(cardLayout);
//           cm_btn.addActionListener(new ActionListener(){
//
//               @Override
//               public void actionPerformed(ActionEvent e) {
//                  // TODO Auto-generated method stub
//                  new CusManager();
//                  dispose();
//               }});
//           pm_btn.addActionListener(new ActionListener(){
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//               // TODO Auto-generated method stub
//               new ProdManager();
//               dispose();
//            }});
//          tab.add(layeredpane, "adminView");
//          tab.add(CM, "customerManager");
//       tab.add(PM,"productManager");
//         add(tab);  

//      window = new JPanel();
//      cardLayout = new CardLayout();
//      window.setLayout(cardLayout);
//      loginView = new LoginView();
//      signUpView = new SignUpView();
//      window.add(layeredpane, "present");
//      window.add(loginView, "login");
//      window.add(signUpView, "signUp");

      add(layeredpane);
      setSize(700, 600);
      setVisible(true);
   }

   @Override
   public void previousButton() {}

   @Override
   public void nextButton() {}

   @Override
   public void loginButton() {}

   @Override
   public void separator() {}

   public class LoginPanel extends JPanel {
      public LoginPanel() {
         setLayout(new GridLayout(2, 1, 100, 22));
      }
   }

   private class MyActionListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         // TODO Auto-generated method stub
         JButton btn = (JButton) e.getSource();

         if (btn.getText().equals("고객관리")) {
            new CusManager();
         } else { // 상품관리
            new ProdManager();
         }
      }
   }
   
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      new AdminView();
   }
}
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

import Controller.I_ToolBar;

public class LoginView extends JFrame implements I_ToolBar{
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
   
//   JToolBar bar = new JToolBar();

   @Override
   public void previousButton() {
      // TODO Auto-generated method stub
      bar.add(previousBtn);
   }
   
   @Override
   public void nextButton() {}
   
   @Override
   public void loginButton() {
      bar.add(loginBtn);
   }
   
   @Override
   public void separator() {
      bar.addSeparator(new Dimension(560, 30));
   }

   public static void main(String[] args) {
      new LoginView();
   }

   public LoginView() {
      JFrame f = new JFrame();
      f.setTitle("로그인");
      setSize(700, 600);
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
      // 툴바 interface
      previousButton();
      separator();
      loginButton();
      add(bar, BorderLayout.NORTH);
      
      goup.add(server);
      goup.add(user);
      Container c = getContentPane();

      try {
         // img = ImageIO.read(new File("img/login.jpg"));//img/login.jpg
      } catch (Exception e) {
         e.printStackTrace();
         System.exit(0);
      }

      JLayeredPane layeredpane = new JLayeredPane();
      layeredpane.setBounds(0, 0, 700, 600);
      layeredpane.setLayout(null);

      JPanel panel = new JPanel();
      panel.setBounds(0, 0, 700, 600);

      user.setFont(new Font("고딕체", Font.BOLD, 18));
      user.setForeground(Color.BLACK);
      user.setBounds(200, 50, 200, 30);

      layeredpane.add(user);

      server.setFont(new Font("고딕체", Font.BOLD, 18));
      server.setForeground(Color.BLACK);
      server.setBounds(400, 50, 200, 30);

      layeredpane.add(server);

      idlb = new JLabel("아이디");
      idlb.setFont(new Font("고딕체", Font.BOLD, 18));
      idlb.setForeground(Color.BLACK);
      idlb.setBounds(100, 109, 100, 30);
      loginTextField = new JTextField(15);
      loginTextField.setBounds(200, 109, 320, 30);

      layeredpane.add(idlb);
      layeredpane.add(loginTextField);

      passlb = new JLabel("비밀번호");
      passlb.setFont(new Font("고딕체", Font.BOLD, 18));
      passlb.setForeground(Color.BLACK);
      passlb.setBounds(100, 209, 100, 30);
      passwordField = new JPasswordField(15);
      passwordField.setBounds(200, 209, 320, 30);

      layeredpane.add(passlb);
      layeredpane.add(passwordField);

      loginbt = new JButton("로그인");
      loginbt.setBackground(Color.black);
      loginbt.setFont(new Font("고딕체", Font.BOLD, 18));
      loginbt.setForeground(Color.WHITE);
      loginbt.setBounds(240, 300, 200, 48);

      layeredpane.add(loginbt);

      la = new JLabel("or");
      la.setBackground(Color.BLACK);
      la.setFont(new Font("고딕체", Font.PLAIN, 23));
      la.setForeground(Color.BLACK);
      la.setBounds(330, 350, 200, 48);

      layeredpane.add(la);

      SignUpbtn = new JButton("회원가입");
      SignUpbtn.setBackground(Color.black);
      SignUpbtn.setFont(new Font("고딕체", Font.BOLD, 18));
      SignUpbtn.setForeground(Color.WHITE);
      SignUpbtn.setBounds(240, 400, 200, 48);

      layeredpane.add(SignUpbtn);

      layeredpane.add(panel);

      window = new JPanel();
      cardLayout = new CardLayout();
      window.setLayout(cardLayout);
      adminView = new AdminView();
      signUpView = new SignUpView();
      window.add(layeredpane, "layer");
      window.add(adminView, "admin");
      window.add(signUpView, "signUp");

      loginbt.addActionListener(e -> cardLayout.show(window, "admin"));
      SignUpbtn.addActionListener(e -> cardLayout.show(window, "signUp"));

      previousBtn.addActionListener(e -> cardLayout.show(window, "layer"));
      add(window);
      setLocationRelativeTo(null);
      setVisible(true);
   }
}