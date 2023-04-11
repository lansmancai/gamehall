package com.lansmancai.lanhall.chatroom.client.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.lansmancai.lanhall.chatroom.client.ClientContext;
import com.lansmancai.lanhall.chatroom.client.ui.MainFrame;
import com.lansmancai.lanhall.commons.*;

/**
 * 用户登录后启动聊天室
 * 
 */
public class StartAction implements ClientAction {

	public void execute(Response response) {
		Map<String, User> usersMap = (Map<String, User>)response.getData("users");
		List<User> users = getUser(usersMap);
		MainFrame mainFrame = new MainFrame(ClientContext.user, users);
		ClientContext.mainFrame = mainFrame;
	}
	
	/**
	 * 将Map转换成List
	 * @param usersMap
	 * @return
	 */
	private List<User> getUser(Map<String, User> usersMap) {
		List<User> result = new ArrayList<User>();
		for (String key : usersMap.keySet()) {
			User user = usersMap.get(key);
			result.add(user);
		}
		return result;
	}

}
