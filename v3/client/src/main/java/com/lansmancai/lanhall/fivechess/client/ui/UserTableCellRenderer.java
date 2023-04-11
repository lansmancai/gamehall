package com.lansmancai.lanhall.fivechess.client.ui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.Icon;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * 玩家列表渲染类
 * 
 */
public class UserTableCellRenderer extends DefaultTableCellRenderer {

	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		setHorizontalAlignment(SwingConstants.CENTER);
		//设置显示图片
		if (value instanceof Icon) this.setIcon((Icon)value);
		else this.setText(value.toString());
		//设置单元格的北景颜色
		if (isSelected) this.setBackground(Color.YELLOW); 
		else this.setBackground(Color.WHITE);
		return this;
	}

}
