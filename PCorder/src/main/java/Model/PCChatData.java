package Model;

import javax.swing.JComponent;
import javax.swing.JTextArea;

public class PCChatData {
	public JTextArea msgOut; 
	public void addObjCus(JComponent c) {
		//JTextArea�� �����͸� ����.
		//������ ������ �Ͼ ������Ʈ�� UI������Ʈ�� ����ϴ� �޼ҵ��̴�.
		this.msgOut = (JTextArea) c;
	}
	public void addObjGUI(JComponent c) {
		//JTextArea�� �����͸� ����.
		//������ ������ �Ͼ ������Ʈ�� UI������Ʈ�� ����ϴ� �޼ҵ��̴�.
		this.msgOut = (JTextArea) c;
	}
	public void refreshData(String msg) {
		//JTextAreaâ�� �ؽ�Ʈ�� �߰��ϴ� �۾��� �Ѵ�.
		msgOut.append(msg);
	}
}