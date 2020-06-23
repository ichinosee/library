package servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.MemberBean;
import la.dao.DAOUtility;
import la.mgr.MemberManager;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");

		try {
			if (action.equals("regist")) {
				String name = checkNull(request.getParameter("name"));
				String postal = checkNull(request.getParameter("postal"));
				String address = checkNull(request.getParameter("address"));
				String tel = checkNull(request.getParameter("tel"));
				String email = checkNull(request.getParameter("email"));
				String strBirthday = checkNull(request.getParameter("birthday"));
				Date birthday = strBirthday == null ? null : DAOUtility.createSQLDate(strBirthday);
				String strJoinDate = checkNull(request.getParameter("joinDate"));
				Date joinDate = strJoinDate == null ? null : DAOUtility.createSQLDate(strJoinDate);

				MemberManager mgr = new MemberManager();
				MemberBean bean = mgr.registMember(name, postal, address, tel, email, birthday, joinDate);
				request.setAttribute("memberPH", bean);
				gotoPage(request, response, "/C101.jsp");
			}
			else if (action.equals("update")) {
				int code = Integer.parseInt(request.getParameter("code"));
				String name = checkNull(request.getParameter("name"));
				String postal = checkNull(request.getParameter("postal"));
				String address = checkNull(request.getParameter("address"));
				String tel = checkNull(request.getParameter("tel"));
				String email = checkNull(request.getParameter("email"));
				String strBirthday = checkNull(request.getParameter("birthday"));
				Date birthday = strBirthday == null ? null : DAOUtility.createSQLDate(strBirthday);
				String strJoinDate = checkNull(request.getParameter("joinDate"));
				Date joinDate = strJoinDate == null ? null : DAOUtility.createSQLDate(strJoinDate);

				MemberManager mgr = new MemberManager();
				MemberBean bean = mgr.updateMember(code, name, postal, address, tel, email, birthday, joinDate, null);
				request.setAttribute("memberPH", bean);
				gotoPage(request, response, "/C101.jsp");
			}
			else if (action.equals("search")) {
				int code = Integer.parseInt(request.getParameter("code"));

				MemberManager mgr = new MemberManager();
				MemberBean bean = mgr.searchMember(code);
				request.setAttribute("member", bean);
				request.setAttribute("memberPH", bean);
				gotoPage(request, response, "/C101.jsp");			}
			else if (action.equals("withdraw")) {
				int code = Integer.parseInt(request.getParameter("code"));
				MemberManager mgr = new MemberManager();
				Date quitDate = DAOUtility.createSQLDate(null);
				MemberBean bean = mgr.withdrawMember(code, quitDate);
				request.setAttribute("memberPH", bean);
				System.out.println(bean);
				gotoPage(request, response, "/C101.jsp");
			}
			else if (action.equals("input")) {
				MemberBean bean = new MemberBean();
				bean.setJoinDate(DAOUtility.createSQLDate(null));
				request.setAttribute("member", bean);
				System.out.println(bean);
				gotoPage(request, response, "/C101.jsp");
			}
			else {

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void gotoPage(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}
	private String checkNull(String s) {
		return s.equals("") ? null : s;
	}


}
