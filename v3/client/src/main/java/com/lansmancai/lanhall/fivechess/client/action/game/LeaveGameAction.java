package com.lansmancai.lanhall.fivechess.client.action.game;

import com.lansmancai.lanhall.commons.ClientAction;
import com.lansmancai.lanhall.commons.Response;
import com.lansmancai.lanhall.fivechess.client.ui.HallPanel;
import com.lansmancai.lanhall.fivechess.client.ui.UIContext;
import com.lansmancai.lanhall.fivechess.commons.Table;

/**
 * ����뿪��Ϸ��Action
 * 
 */
public class LeaveGameAction implements ClientAction {

	public void execute(Response response) {
		//�õ�������Ϣ, �ĸ�����뿪���ĸ�����
		Integer tableNumber = (Integer)response.getData("tableNumber");
		String side = (String)response.getData("side");
		//�õ�����������Ϣ�Ľ������
		HallPanel hallPanel = (HallPanel)UIContext.modules.get(UIContext.HALL_PANEL);
		Table table = hallPanel.getTable(tableNumber);
		//������λ����ҵĿ�
		table.getSeat(side).getUser().setReady(false);
		table.getSeat(side).setUser(null);
		//ˢ�½���
		hallPanel.repaint();
	}

}
