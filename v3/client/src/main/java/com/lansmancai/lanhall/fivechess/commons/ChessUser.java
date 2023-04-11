package com.lansmancai.lanhall.fivechess.commons;

import com.lansmancai.lanhall.commons.User;

/**
 * ��������Ҷ���
 * 
 */
public class ChessUser extends User {

		
	//�Ƿ��Ѿ�׼����Ϸ
	private boolean ready;

	public boolean isReady() {
		return ready;
	}

	public void setReady(boolean ready) {
		this.ready = ready;
	}
	
	public String toString() {
		return this.getName();
	}
	
	//�ж�����Ƿ�����λ��, �������Ѿ�����λ��, ����true, ���򷵻�false
	public boolean hasSitDown(Table[][] tables) {
		for (int i = 0; i < tables.length; i++) {
			for (int j = 0; j < tables[i].length; j++) {
				Table t = tables[i][j];
				Seat ls = t.getLeftSeat();
				Seat rs = t.getRightSeat();
				if (ls.getUser() != null) {
					if (this.getId().equals(ls.getUser().getId())) return true;
				}
				if (rs.getUser() != null) {
					if (this.getId().equals(rs.getUser().getId())) return true;
				}
			}
		}
		return false;
	}
}
