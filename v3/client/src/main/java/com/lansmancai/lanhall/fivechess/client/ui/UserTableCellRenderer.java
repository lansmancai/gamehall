package com.lansmancai.lanhall.fivechess.client.ui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.Icon;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * ����б���Ⱦ��
 * 
 */
public class UserTableCellRenderer extends DefaultTableCellRenderer {

	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		setHorizontalAlignment(SwingConstants.CENTER);
		//������ʾͼƬ
		if (value instanceof Icon) this.setIcon((Icon)value);
		else this.setText(value.toString());
		//���õ�Ԫ��ı�����ɫ
		if (isSelected) this.setBackground(Color.YELLOW); 
		else this.setBackground(Color.WHITE);
		return this;
	}

}
