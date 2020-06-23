package la.mgr;

import java.sql.Date;

import la.bean.MemberBean;
import la.dao.DAOException;
import la.dao.DAOUtility;
import la.dao.MemberDAO;

public class MemberManager {
	public MemberBean registMember(String name, String postal, String address, String tel, String email, Date birthday, Date joinDate) throws DAOException {
		MemberDAO dao = new MemberDAO();
		return dao.addMember(name, postal, address, tel, email, birthday, joinDate);
	}
	public MemberBean searchMember(Integer code) throws DAOException {
		MemberDAO dao = new MemberDAO();
		return dao.searchMember(code);
	}
	public MemberBean updateMember(Integer code, String name, String postal, String address, String tel, String email, Date birthday, Date joinDate, Date quitDate) throws DAOException {
		MemberDAO dao = new MemberDAO();
		return dao.updateMember(code, name, postal, address, tel, email, birthday, joinDate, quitDate);
	}
	public MemberBean withdrawMember(Integer code, Date quitDate) throws DAOException {
		MemberDAO dao = new MemberDAO();

		return dao.updateMember(code, null, null, null, null, null, null, null, quitDate);
	}
	public static void main(String[] args) {
		try {
			MemberManager mgr = new MemberManager();
			MemberBean bean = mgr.registMember("安部晋三", "123-3333", "横浜市磯子区", "123-1111", "abc@ssss.com", DAOUtility.createSQLDate("2000-01-01"), DAOUtility.createSQLDate(null));
			System.out.println(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}


	}




}
