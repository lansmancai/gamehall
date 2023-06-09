package com.lansmancai.lanhall.client;

import java.awt.Component;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 * 头像下拉渲染类
 * 
 */
public class HeadComboBoxRenderer extends JLabel implements ListCellRenderer {

	private Map<String, ImageIcon> heads;
	
	public HeadComboBoxRenderer(Map<String, ImageIcon> heads) {
		this.heads = heads;
		setOpaque(true);
        setHorizontalAlignment(CENTER);
        setVerticalAlignment(CENTER);
	}
	
    public Component getListCellRendererComponent(JList list, Object value, 
    		int index, boolean isSelected, boolean cellHasFocus) {
        String selectValue = (String)value;
        //设置背景颜色
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        //从头像的Map中得到当前选择的头像图片
        Icon icon = this.heads.get(selectValue);
        setIcon(icon);
        if (icon != null) setFont(list.getFont());
        return this;
    }


}
