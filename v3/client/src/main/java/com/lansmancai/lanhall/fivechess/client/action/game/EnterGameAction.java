package com.lansmancai.lanhall.fivechess.client.action.game;

import com.lansmancai.lanhall.commons.*;
import com.lansmancai.lanhall.fivechess.client.ChessClientContext;
import com.lansmancai.lanhall.fivechess.client.ui.HallPanel;
import com.lansmancai.lanhall.fivechess.client.ui.UIContext;
import com.lansmancai.lanhall.fivechess.client.ui.game.ChessFrame;
import com.lansmancai.lanhall.fivechess.commons.*;

/**
 * ������������Ϸ��Action
 * 
 */
public class EnterGameAction implements ClientAction {

	
	public void execute(Response response) {
		HallPanel hallPanel = (HallPanel)UIContext.modules.get(UIContext.HALL_PANEL);
		//�ӷ�������Ӧ�еõ����ӱ��
		Integer tableNumber = (Integer)response.getData("tableNumber");
		String side = (String)response.getData("side");
		//�������ӱ�ŵõ�������Ϣ
		Table table = Table.getTable(tableNumber, hallPanel.getTables());
		//��ʾ����
		ChessFrame cf = new ChessFrame(table, ChessClientContext.chessUser);
		cf.setVisible(true);
		//���߶Է�������Ϸ(����жԷ���ҵĻ�)
		Seat seat = table.getSeat(side);
		//�õ��Է���λ
		Seat otherSeat = table.getAnotherSeat(seat);
		if (otherSeat.getUser() != null) {
			//�ж���, ���������������
			Request request = new Request(
					"com.lansmancai.lanhall.fivechess.server.action.OpponentEnterAction", 
					"com.lansmancai.lanhall.fivechess.client.action.game.OpponentEnterAction");
			//firstUserId�Ƕ��ֵ�ID(��һ��������Ϸ�����)
			request.setParameter("firstUserId", otherSeat.getUser().getId());
			//secondUserId���Լ���ID(�������Ϸ�����)
			request.setParameter("secondUserId", seat.getUser().getId());
			Usocket.ps.println(XStreamUtil.toXML(request));
		}
	}

}
