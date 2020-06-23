package la.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import la.bean.MemberBean;

public class MemberDAO {
	private Connection con;

	public MemberDAO() throws DAOException {
		getConnection();
	}

	public MemberBean addMember(String name, String postal, String address, String tel, String email, Date birthday, Date joinDate) throws DAOException {
		if (con == null)
			getConnection();

		PreparedStatement st = null;
		try {
			MemberBean bean = null;
			// SQL文の作成
			String sql = "INSERT INTO member(code, name, postal, address, tel, email, birthday, join_date) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			// PreparedStatementオブジェクトの取得
			int  code = DAOUtility.getNextVal(con, "member_code_seq");
			st = con.prepareStatement(sql);
			st.setInt(1, code);
			st.setString(2, name);
			st.setString(3, postal);
			st.setString(4, address);
			st.setString(5, tel);
			st.setString(6, email);
			st.setDate(7, birthday);
			st.setDate(8, joinDate);
			// SQLの実行
			int cRow = st.executeUpdate();
			if (cRow >0) {
				bean = searchMember(code);
			}
			return bean;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの挿入に失敗しました。");
		} finally {
			try {
				// リソースの開放
				if(st != null) st.close();
				close();
			} catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");
			}
		}
	}
	public MemberBean searchMember(Integer code) throws DAOException {
		if (con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			// SQL文の作成
			String sql = "SELECT * FROM member WHERE code=?";
			// PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			st.setInt(1, code);
			// SQLの実行
			rs = st.executeQuery();
			// 結果の取得および表示
			MemberBean bean = null;
			if (rs.next()) {
				code = rs.getInt("code");
				String name = rs.getString("name");
				String postal = rs.getString("postal");
				String address = rs.getString("address");
				String tel = rs.getString("tel");
				String email = rs.getString("email");
				Date birthday = rs.getDate("birthday");
				Date joinDate=rs.getDate("join_date");
				Date quitDate=rs.getDate("quit_date");
				bean = new MemberBean(code,name,postal,address,tel,email,birthday,joinDate,quitDate);
			}
			// カテゴリ一覧をListとして返す
			return bean;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		} finally {
			try {
				// リソースの開放
				if(rs != null) rs.close();
				if(st != null) st.close();
				close();
			} catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");
			}
		}
}
	public MemberBean updateMember(Integer code, String name, String postal, String address, String tel, String email, Date birthday, Date joinDate, Date quitDate) throws DAOException {
		if (con == null)
			getConnection();

		PreparedStatement st = null;
		try {
			MemberBean bean = null;
			// SQL文の作成
			String sql = "UPDATE member SET name=COALESCE(?, name), postal=COALESCE(?, postal), address=COALESCE(?, address), tel=COALESCE(?, tel), email=COALESCE(?, email), birthday=COALESCE(?, birthday),  join_date=COALESCE(?, join_date), quit_date=COALESCE(?, quit_date) WHERE code=?";
			// PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			st.setString(1, name);
			st.setString(2, postal);
			st.setString(3, address);
			st.setString(4, tel);
			st.setString(5, email);
			st.setDate(6, birthday);
			st.setDate(7, joinDate);
			st.setDate(8, quitDate);
			st.setInt(9, code);
			// SQLの実行
			int cRow = st.executeUpdate();
			if (cRow >0) {
				bean = searchMember(code);
			}
			return bean;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの更新に失敗しました。");
		} finally {
			try {
				// リソースの開放
				if(st != null) st.close();
				close();
			} catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");
			}
		}
	}

	private void getConnection() throws DAOException {
		try {
			// JDBCドライバの登録
			Class.forName("org.postgresql.Driver");
			// URL,ユーザー名、パスワードの設定
			String url = "jdbc:postgresql:library2";
			String user = "postgres";
			String pass = "himitu";
			// データベースへの接続
			con = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			throw new DAOException("接続に失敗しました。");
		}
	}
	private void close() throws SQLException {
		if (con != null) {
			con.close();
			con = null;
		}
	}

	public static void main(String[] args) {

		try {
			MemberDAO dao = new MemberDAO();
			MemberBean bean = null;

			bean = dao.addMember("ogura", "123-3333", "横浜市磯子区", "123-1111", "abc@ssss.com", DAOUtility.createSQLDate("2000-01-01"), DAOUtility.createSQLDate(null));
			System.out.println(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			MemberDAO dao = new MemberDAO();
			MemberBean bean = null;

			bean = dao.updateMember(3, null, null, null, null, "mmm@ssss.com", null, null, null);
			System.out.println(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
}


}
