package View;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;


public class AdminView extends JPanel {
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
  
   JToolBar bar = new JToolBar();
private MainFrame mainf;
  

   public AdminView(MainFrame mainf) {

	   this.mainf = mainf;
	    
	  // Previousbtn.addActionListener(e -> cardLayout.show(window, "layer"));
	   
	   bar.add(Previousbtn);
	      bar.addSeparator(new Dimension(560, 27));
	   bar.add(LogOutbtn );
	   
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
      bar.add(LogOutbtn );

      add(layeredpane);
      setSize(700, 600);
      setVisible(true);
      add(bar, BorderLayout.NORTH);
      
      Previousbtn.addActionListener(new ActionListener() {  /////***** user 모드 선택하고 로그인 눌렀을떄는 admin card
			@Override
			public void actionPerformed(ActionEvent e) {
				
				mainf.change("ChLogin");
				
			}
			});
      LogOutbtn .addActionListener(new ActionListener() {  /////***** user 모드 선택하고 로그인 눌렀을떄는 admin card
			@Override
			public void actionPerformed(ActionEvent e) {
				
				mainf.change("Close");
				
				
			}
			});
			
      
   }

  

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
     // new AdminView();
   }
}