package com.lansmancai.lanhall.fivechess.server.action;

import java.net.Socket;

import com.lansmancai.lanhall.commons.*;
import com.lansmancai.lanhall.fivechess.commons.*;
import com.lansmancai.lanhall.fivechess.server.ChessContext;

/**
 * ����뿪��Ϸʱ������ִ�е�Action
 * 
 */
public class LeaveGameAction implements ServerAction {

	public void execute(Request request, Response response, Socket socket) {
		Integer tableNumber = (Integer)request.getParameter("tableNumber");
		String userId = (String)request.getParameter("userId");
		//�õ��뿪�����
		ChessUser user = ChessContext.users.get(userId);
		user.setReady(false);
		//�õ�����
		Table table = Table.getTable(tableNumber, ChessContext.tables);
		//�õ���ҵ���λ
		Seat seat = table.getUserSeat(user);
		//������λ�����Ϊ��
		seat.setUser(null);
		response.setData("side", seat.getSide());
		//���ͷ�������Ӧ, �����������, ������˳�
		printResponse(response);
		
		//�����˳���ҵĶ���, ���˳���
		Seat otherSeat = table.getAnotherSeat(seat);
		if (otherSeat.getUser() != null) {
			String exitAction = (String)request.getParameter("exitAction");
			response.setActionClass(exitAction);
			//otherSeat.getUser().getPrintStream().println(XStreamUtil.toXML(response));
			StoreSocket.getOutStream(otherSeat.getUser().getId()).println(XStreamUtil.toXML(response));
		}
	}
	
	private void printResponse(Response response) {
		for (String id : ChessContext.users.keySet()) {
			ChessUser u = ChessContext.users.get(id);
			//u.getPrintStream().println(XStreamUtil.toXML(response));
			StoreSocket.getOutStream(u.getId()).println(XStreamUtil.toXML(response));
		}
	}

}
