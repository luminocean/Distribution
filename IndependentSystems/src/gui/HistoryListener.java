package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

import util.Logger;
import util.SideType;

public class HistoryListener implements ActionListener{
	private JTextArea area;

	public void setTextArea(JTextArea area) {
		this.area = area;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if( area == null ){
			Logger.log(SideType.零售商客户端, "历史记录监听器没有获取用于输出的Area！请检查是否正确设置", this);
		}
	}
}
