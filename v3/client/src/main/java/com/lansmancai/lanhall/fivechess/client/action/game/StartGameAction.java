package com.lansmancai.lanhall.fivechess.client.action.game;

import com.lansmancai.lanhall.commons.ClientAction;
import com.lansmancai.lanhall.commons.Response;
import com.lansmancai.lanhall.fivechess.client.ui.UIContext;
import com.lansmancai.lanhall.fivechess.client.ui.game.GamePanel;
import com.lansmancai.lanhall.fivechess.commons.Chess;

/**
 * 服务器告诉客户端开始游戏, 该类用于客户端开开始游戏
 */
public class StartGameAction implements ClientAction {

	
	public void execute(Response response) {
		//创建棋盘
		Chess[][] chessArray = new Chess[Chess.CHESS_BOARD_X_SIZE][Chess.CHESS_BOARD_Y_SYZE];
		for (int i = 0; i < chessArray.length; i++) {
			for (int j = 0; j < chessArray[i].length; j++) {
				int beginX = (GamePanel.CHESS_BOARD_X) - (Chess.IMAGE_WIDTH/2) 
					+ GamePanel.CHESS_BOARD_CELL_WIDTH * i;
				int beginY = (GamePanel.CHESS_BOARD_Y) - (Chess.IMAGE_HEIGHT/2) 
					+ GamePanel.CHESS_BOARD_CELL_HEIGHT * j;
				chessArray[i][j] = new Chess(beginX, beginY, i, j, null);
			}
		}
		GamePanel gamePanel = (GamePanel)UIContext.modules.get(UIContext.GAME_PANEL);
		gamePanel.setChessArray(chessArray);
		gamePanel.startGame();
	}

}
