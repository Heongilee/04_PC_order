package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.AdminView;
import View.CusManager;
import View.LoginView;
import View.ProdManager;

public class PCController {
	private final LoginView LV;
	private final CusManager CM;
	private final ProdManager PM;
	private final AdminView AV;
	private final C_login cl;
	
	public PCController(LoginView LV, CusManager CM, ProdManager PM, AdminView AV, C_login cl) {
		this.LV = LV;
		this.CM = CM;
		this.PM = PM;
		this.AV = AV;
		this.cl = cl;
	}
	public void appMain() {
		LV.addButtonActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if (obj == LV.loginbt) {
					if (LV.server.isSelected()) {
						 LV.cardLayout.show(LV.window, "admin");
						 System.out.println("Server");
						 cl.Mode_Check();
					 } else if (LV.user.isSelected()) {
						 LV.setVisible(false);
						 LV.GV.getInstance().setVisible(true);
						 System.out.println("User");
						 cl.Mode_Check();
					 } else {
						 
					 }
				 } else if (obj == LV.SignUpbtn) {
					 LV.cardLayout.show(LV.window, "signUp");
					 cl.Mode_Check();
				 } else if (obj == LV.previousBtn){
					 LV.cardLayout.show(LV.window, "layer");
					 cl.Mode_Check();
				 } else {
					 
				 }
			}
		});
		LV.adminView.addButtonActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if (obj == LV.adminView.cm_btn) {
					CM.getInstance().setVisible(true);
					LV.getInstance().setVisible(false);
					cl.Mode_Check();
				} else if (obj == LV.adminView.pm_btn) {
					PM.getInstance().setVisible(true);
					LV.getInstance().setVisible(false);
					cl.Mode_Check();
				}
			}
		});
		CM.addButtonActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if (obj == CM.chatInput) {
					CM.chatInput.getText();
					CM.chatContent.setText(CM.chatContent.getText() + CM.chatInput.getText() + "\n");
					CM.chatInput.setText("");
				 } else if (obj == CM.previousBtn) {
					 CM.setVisible(false);
					 LV.getInstance().setVisible(true);
				 } else if (obj == CM.logoutBtn){
					 CM.setVisible(false);
					 LV.getInstance().setVisible(true);
					 LV.getInstance().cardLayout.show(LV.getInstance().window, "layer");
				 } else {
					 
				 }
			}
		});
		PM.addButtonActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				 if (obj == PM.previousBtn) {
					 PM.setVisible(false);
					 LV.getInstance().setVisible(true);
				 } else if (obj == PM.logoutBtn){
					 PM.setVisible(false);
					 LV.getInstance().setVisible(true);
					 LV.getInstance().cardLayout.show(LV.getInstance().window, "layer");
				 } else {
					 
				 }
			}
		});
	}
	public static void main(String[] args) {
		PCController app = new PCController(LoginView.getInstance(), CusManager.getInstance(), ProdManager.getInstance(), new AdminView(), new C_login()); 
		app.appMain();
	}

}
