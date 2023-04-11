package com.lansmancai.lanhall.fivechess.server.action;

import java.net.Socket;

import com.lansmancai.lanhall.commons.*;
import com.lansmancai.lanhall.fivechess.commons.*;
import com.lansmancai.lanhall.fivechess.commons.Table;
import com.lansmancai.lanhall.fivechess.server.ChessContext;

/**
 * ���׼����Ϸ
 * 
 */
public class ReadyAction implements ServerAction {
	
	public void execute(Request request, Response response, Socket socket) {
		//�õ�׼����Ϸ�����
		String userId = (String)request.getParameter("userId");
		//�õ����ӱ��
		Integer tableNumber = (Integer)request.getParameter("tableNumber");
		//�õ����
		ChessUser user = ChessContext.users.get(userId);
		user.setReady(true);
		//�ж϶Է��Ƿ��Ѿ�׼����Ϸ
		//�õ����Ӷ���
		Table table = Table.getTable(tableNumber, ChessContext.tables);
		Seat seat = table.getUserSeat(user);
		//�õ�����
		ChessUser opponent = table.getAnotherSeat(seat).getUser();
		if (opponent != null) {
			//������λ����, ���ж϶����Ƿ��Ѿ�׼������
			if (opponent.isReady()) {
				//������������
				createChessArray(table);
				//��˫����ҷ�����Ӧ, ��Ϸ��ʼ
				StoreSocket.getOutStream(opponent.getId()).println(XStreamUtil.toXML(response));
				StoreSocket.getOutStream(user.getId()).println(XStreamUtil.toXML(response));
				//user.getPrintStream().println(XStreamUtil.toXML(response));
			}
			//���߶���, �Լ�׼������, ʹ�ý���׼���Ŀͻ��˴����࣬�ô������ɶ���ִ��
			String opponentAction = (String)request.getParameter("opponentAction");
			response.setActionClass(opponentAction);
			response.setData("userId", userId);
			//opponent.getPrintStream().println(XStreamUtil.toXML(response));
			StoreSocket.getOutStream(opponent.getId()).println(XStreamUtil.toXML(response));
		}
	}
	
	private void createChessArray(Table table) {
		//�����Ѿ�׼������, �ڷ������д���������
		Chess[][] newChess = new Chess[Chess.CHESS_BOARD_X_SIZE][Chess.CHESS_BOARD_Y_SYZE];
		for (int i = 0; i < newChess.length; i++) {
			for (int j = 0; j < newChess[i].length; j++) {
				Chess c = new Chess(i, j, null);
				newChess[i][j] = c;
			}
		}
		//����������������ŵ�����������������
		ChessContext.tableChesses.put(table.getTableNumber(), newChess);
	}

}
