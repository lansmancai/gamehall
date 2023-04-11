package com.lansmancai.lanhall.fivechess.client.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.lansmancai.lanhall.commons.ClientAction;
import com.lansmancai.lanhall.commons.Request;
import com.lansmancai.lanhall.commons.Response;
import com.lansmancai.lanhall.commons.User;
import com.lansmancai.lanhall.fivechess.client.ChessClientContext;
import com.lansmancai.lanhall.fivechess.client.object.GameHallInfo;
import com.lansmancai.lanhall.fivechess.client.ui.GameHallFrame;
import com.lansmancai.lanhall.fivechess.commons.ChessUser;
import com.lansmancai.lanhall.fivechess.commons.Table;

/**
 * �������ÿͻ���������Ϸ����
 */
public class ClientInAction implements ClientAction {

	
	public void execute(Response response) {
		//�ӷ������еõ�������Ϣ����װ��һ��GameHallInfo����
		GameHallInfo hallInfo = getGameHallInfo(response);
		//�õ�ȫ����ҵ���Ϣ
		List<ChessUser> users = getUsers(response);
		//�õ�������Ϸ�������Ϣ
		ChessUser cu = ChessClientContext.chessUser;
		//��������GameHallFrame
		GameHallFrame mainFrame = new GameHallFrame(hallInfo, cu, users);
		mainFrame.sendUserIn();
	}
	
	//��Response�еõ�������ҵ���Ϣ, ��ת����List(�������б�������ݽṹ��Map)
	private List<ChessUser> getUsers(Response response) {
		Map<String, User> users = (Map<String, User>)response.getData("users");
		List<ChessUser> result = new ArrayList<ChessUser>();
		for (String id : users.keySet()) {
			ChessUser cu = (ChessUser)users.get(id);
			result.add(cu);
		}
		return result;
	}
	
	private GameHallInfo getGameHallInfo(Response response) {
		//�õ�������������
		int tableColumnSize = (Integer)response.getData("tableColumnSize");
		//�õ�������������
		int tableRowSize = (Integer)response.getData("tableRowSize");
		//�õ�������Ϣ
		Table[][] tables = (Table[][])response.getData("tables");
		GameHallInfo info = new GameHallInfo(tables, tableColumnSize, tableRowSize);
		return info;
	}

}
