package com.lansmancai.lanhall.fivechess.client.action.game;

import com.lansmancai.lanhall.commons.ClientAction;
import com.lansmancai.lanhall.commons.Response;
import com.lansmancai.lanhall.fivechess.client.ui.HallPanel;
import com.lansmancai.lanhall.fivechess.client.ui.UIContext;
import com.lansmancai.lanhall.fivechess.commons.Table;

/**
 * 玩家离开游戏的Action
 * 
 */
public class LeaveGameAction implements ClientAction {

	public void execute(Response response) {
		//得到所有信息, 哪个玩家离开了哪个桌子
		Integer tableNumber = (Integer)response.getData("tableNumber");
		String side = (String)response.getData("side");
		//得到保存桌子信息的界面组件
		HallPanel hallPanel = (HallPanel)UIContext.modules.get(UIContext.HALL_PANEL);
		Table table = hallPanel.getTable(tableNumber);
		//设置座位的玩家的空
		table.getSeat(side).getUser().setReady(false);
		table.getSeat(side).setUser(null);
		//刷新界面
		hallPanel.repaint();
	}

}
