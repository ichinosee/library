package la.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.time.LocalDate;


public class DAOUtility {
	public static Date createSQLDate(String date) throws ParseException {
		return date != null ? Date.valueOf(date) : Date.valueOf(LocalDate.now());
	}
	public static Date createSQLDate(String date, Integer interval) throws ParseException {
		return new Date(createSQLDate(date).getTime() + 1000L * 60 * 60 * 24 * interval);
	}
	public static int getNextVal(Connection con, String seq) throws DAOException {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			int bookID = 0;
			// SQL文の作成
			String sql = "SELECT nextval(?)";
			// PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			st.setString(1, seq);
			// SQLの実行
			rs = st.executeQuery();
			if (rs.next()) {
				bookID = rs.getInt(1);
			}
			return bookID;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		} finally {
			try {
				// リソースの開放
				if(rs != null) rs.close();
				if(st != null) st.close();
			} catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");
			}
		}
	}
	public static void main(String[] args) {
		try {
			System.out.println(DAOUtility.createSQLDate("2001-01-01"));
			System.out.println(DAOUtility.createSQLDate("2001-01-01", 100));
			System.out.println(DAOUtility.createSQLDate(null));
			System.out.println(DAOUtility.createSQLDate(null, 100));
		} catch (Exception e) {
			e.getStackTrace();
		}
	}


}
