package com.lansmancai.lanhall.fivechess.client.object;

import com.lansmancai.lanhall.fivechess.commons.Table;

/**
 * 游戏大厅信息对象, 该对象由服务器的响应创建
 */
public class GameHallInfo {

	//桌子信息
	private Table[][] tables;
	
	private int tableColumnSize;
	
	private int tableRowSize;
	
	public GameHallInfo() {
		
	}

	public GameHallInfo(Table[][] tables, int tableColumnSize, int tableRowSize) {
		this.tables = tables;
		this.tableColumnSize = tableColumnSize;
		this.tableRowSize = tableRowSize;
	}

	public Table[][] getTables() {
		return tables;
	}

	public void setTables(Table[][] tables) {
		this.tables = tables;
	}

	public int getTableColumnSize() {
		return tableColumnSize;
	}

	public void setTableColumnSize(int tableColumnSize) {
		this.tableColumnSize = tableColumnSize;
	}

	public int getTableRowSize() {
		return tableRowSize;
	}

	public void setTableRowSize(int tableRowSize) {
		this.tableRowSize = tableRowSize;
	}
	
	
}
