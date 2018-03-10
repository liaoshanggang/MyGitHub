package com.forward.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.forward.dao.BankCardDao;
import com.forward.util.DatabaseConn;
import com.forward.po.trade.BankCard;

public class BankCardDaoImpl implements BankCardDao {
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	public BankCardDaoImpl() {
		super();
	}

	@Override
	public int addCardInfo(BankCard bankCard) {
		conn = DatabaseConn.getConnection();
		String sql = "INSERT INTO USER_BANKCARD VALUES(user_cardno_seq.nextval,?,?,?,?)";
		int flag = -1;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, bankCard.getAccountNo());
			pst.setInt(2, bankCard.getPassword());
			pst.setString(3, bankCard.getCardType());
			pst.setDouble(4, bankCard.getBalance());
			flag = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseConn.closeConnection(rs, pst, conn);
		}
		return flag;
	}

	@Override
	public boolean queryCardInfoByAcc(String acc_id) {
		conn = DatabaseConn.getConnection();
		String sql = "SELECT user_accountno,user_password,user_cardtype,user_balance FROM USER_BANKCARD where user_accountno = ?";
		boolean flag = false;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, acc_id);
			rs = pst.executeQuery();

			while (rs.next()) {
				String acc = rs.getString(1);
				if (acc.equals(acc_id)) {
					flag = true;
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseConn.closeConnection(rs, pst, conn);
		}

		return flag;
	}

	@Override
	public BankCard getCardInfo(String cardNo, int password) {
		conn = DatabaseConn.getConnection();
		String sql = "SELECT * FROM USER_BANKCARD where user_cardno = ? AND user_password = ?";
		BankCard bankCard = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, cardNo);
			pst.setInt(2, password);
			rs = pst.executeQuery();

			while (rs.next()) {
				String id = rs.getString(1);
				String acc = rs.getString(2);
				int pwd = rs.getInt(3);
				String type = rs.getString(4);
				double ban = rs.getDouble(5);
				bankCard = new BankCard(id, pwd);
				/*bankCard = new BankCard(id, acc, pwd, type, ban);*/
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseConn.closeConnection(rs, pst, conn);
		}

		return bankCard;
	}

	@Override
	public int withDrawMoney(String cardNo, double money) {
		conn = DatabaseConn.getConnection();
		String sql = "UPDATE USER_BANKCARD SET user_balance = user_balance-? WHERE user_cardno = ? and ? <user_balance";
		int index = -1;
		try {
			pst = conn.prepareStatement(sql);
			pst.setDouble(1, money);
			pst.setString(2, cardNo);
			pst.setDouble(3, money);
			index = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DatabaseConn.closeConnection(rs, pst, conn);
		}
		return index;
	}

	@Override
	public List<BankCard> queryALlCardInfo() {
		conn = DatabaseConn.getConnection();
		String sql = "SELECT * FROM USER_BANKCARD";
		BankCard bankCard = null;
		List<BankCard> bCards = new ArrayList<BankCard>();
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				String id = rs.getString(1);
				String acc = rs.getString(2);
				int pwd = rs.getInt(3);
				String type = rs.getString(4);
				double ban = rs.getDouble(5);
				bankCard = new BankCard(id, acc, pwd, type, ban);
				bCards.add(bankCard);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseConn.closeConnection(rs, pst, conn);
		}

		return bCards;
	}

	@Override
	public int depositMoney(String cardNo, double money) {
		conn = DatabaseConn.getConnection();
		String sql = "UPDATE USER_BANKCARD SET user_balance = user_balance+? WHERE user_cardno = ?";
		int index = -1;
		try {
			pst = conn.prepareStatement(sql);
			pst.setDouble(1, money);
			pst.setString(2, cardNo);
			index = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DatabaseConn.closeConnection(rs, pst, conn);
		}
		return index;
	}

	@Override
	public int tranfer(String from, String to, double money) {
		conn = DatabaseConn.getConnection();
		/*String sql1 = "UPDATE USER_BANKCARD SET user_balance = user_balance -? WHERE user_cardno = ?";
		String sql2 = "UPDATE USER_BANKCARD SET user_balance = user_balance +? WHERE user_cardno = ?";*/
		String sql = "UPDATE USER_BANKCARD SET user_balance = user_balance -? WHERE user_cardno = ?;"+
		"UPDATE USER_BANKCARD SET user_balance = user_balance +? WHERE user_cardno = ?";
		int index = -1;
		try {
			pst = conn.prepareStatement(sql);
			pst.setDouble(1, money);
			pst.setString(2, from);
			pst.setDouble(3, money);
			pst.setString(4, to);
			index = pst.executeUpdate();
			/*pst.addBatch(sql1);
			pst.setDouble(1, money);
			pst.setString(2, from);
			pst.addBatch(sql2);
			pst.setDouble(1, money);
			pst.setString(2, to);
			index = pst.executeBatch();*/
			System.out.println(index);
			//index = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DatabaseConn.closeConnection(rs, pst, conn);
		}
		return index;
	}
}
