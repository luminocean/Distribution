package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class ConfirmListener implements ActionListener{
	private JTextField confirm;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(confirm.getText());
	}

	public void setInputFields(JTextField confirm) {
		this.confirm = confirm;
	}
}
