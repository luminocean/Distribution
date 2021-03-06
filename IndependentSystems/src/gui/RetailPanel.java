package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RetailPanel extends JPanel {
	private JTabbedPane tp = new JTabbedPane();

	public RetailPanel() {
		super(new GridLayout(1, 1));

		addPublishPanel();
		addConfirmPanel();
		addHistoryPanel();

		add(tp);
		tp.setPreferredSize(new Dimension(500, 200));
		tp.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tp.setTabPlacement(JTabbedPane.LEFT);
		tp.setFont(new Font("微软雅黑", Font.PLAIN, 20));
	}

	private void addHistoryPanel() {
		JPanel historyPanel = new JPanel();
		historyPanel.setLayout(new BorderLayout());
		tp.add("转账记录", historyPanel);

		JButton historyButton = new JButton("获取转账记录");
		historyButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		historyPanel.add(historyButton, BorderLayout.SOUTH);
		
		JTextArea area = new JTextArea();
		area.setEditable(false);
		historyPanel.add(area);
		
		HistoryListener listener = new HistoryListener();
		listener.setTextArea(area);
		historyButton.addActionListener(listener);
	}

	private void addConfirmPanel() {
		JPanel confirmPanel = new JPanel();
		confirmPanel.setLayout(new GridLayout(4, 2, 30, 30));
		tp.add("团购确认", confirmPanel);

		holdPlace(confirmPanel, 2);

		JTextField code = addInputFields("确认码", confirmPanel);

		ConfirmListener listener = new ConfirmListener();
		listener.setInputFields(code);

		holdPlace(confirmPanel, 1);

		JButton confirmButton = new JButton("确认");
		confirmButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		confirmButton.addActionListener(listener);
		confirmPanel.add(confirmButton);

		holdPlace(confirmPanel, 2);
	}

	/**
	 * 填充占位符
	 * 
	 * @param panel
	 * @param num
	 */
	private void holdPlace(JPanel panel, int num) {
		for (int i = 0; i < num; i++) {
			panel.add(new JLabel(""));
		}
	}

	private void addPublishPanel() {
		JPanel publishPanel = new JPanel();
		publishPanel.setLayout(new GridLayout(5, 2, 60, 10));
		tp.add("团购发布", publishPanel);

		JTextField name = addInputFields("商品名称", publishPanel);
		JTextField intro = addInputFields("介绍", publishPanel);
		JTextField price = addInputFields("价格", publishPanel);
		JTextField limit = addInputFields("数量上限", publishPanel);
		
		//输入预设
		name.setText("摩托车");
		intro.setText("已报废");
		price.setText("50");
		limit.setText("2");

		PublishListener listener = new PublishListener();
		listener.setInputFields(name, intro, price, limit);

		publishPanel.add(new JLabel(""));

		JButton publishButton = new JButton("发布");
		publishButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		publishButton.addActionListener(listener);
		publishPanel.add(publishButton);
	}

	private JTextField addInputFields(String title, JPanel publishPanel) {
		JLabel name = new JLabel(title);
		name.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		publishPanel.add(name);
		JTextField text = new JTextField();
		publishPanel.add(text);

		return text;
	}

}
