package com.lansmancai.lanhall.fivechess.client.action;

import com.lansmancai.lanhall.commons.ClientAction;
import com.lansmancai.lanhall.commons.Response;
import com.lansmancai.lanhall.fivechess.client.ui.HallPanel;
import com.lansmancai.lanhall.fivechess.client.ui.UIContext;
import com.lansmancai.lanhall.fivechess.commons.util.FiveChessErrorCode;

/**
 * ����������µ�Action
 * 
 */
public class ReceiveUserSitDownAction implements ClientAction {

	
	public void execute(Response response) {
		//�õ��������
		HallPanel hallPanel = (HallPanel)UIContext.modules.get(UIContext.HALL_PANEL);
		if (response.getErrorCode() != null) {
			String errorCode = (String)response.getErrorCode();
			UIContext.showMessage(FiveChessErrorCode.getMessage(errorCode));
		} else {
			//���µ��������, �������������(������������)ִ��
			int tableNumber = (Integer)response.getData("tableNumber");
			String side = (String)response.getData("side");
			String userId = (String)response.getData("userId");
			hallPanel.newUserSitDown(tableNumber, side, userId);
		}
	}

}
