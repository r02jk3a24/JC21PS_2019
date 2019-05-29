package jp.co.jcps.A02;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import jp.co.jcps.Common.CommonCheck;

/**
 * トップ画面のコントローラ
 */
@WebServlet("/TopControllerServlet")
public class TopControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * コンストラクタ
	 */
	public TopControllerServlet() {
		super();
	}

	/**
	 * GETメソッドでリクエストされた場合の処理
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 共通チェック
		if(!CommonCheck.existSession(request)) {
			// セッションが切れてる場合はログイン画面に遷移
			request.getRequestDispatcher("/Login").forward(request, response);
		}

		// セッションからログイン中の学生の学生IDを取得する
		String userId = (String) request.getSession().getAttribute("userId");

		// DB接続
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// データソースの取得
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/jc21ps");

			// データベースへ接続
			con = ds.getConnection();

			String sql = "";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, studentId);
			rs = pstmt.executeQuery();

			// リストにDBから取得した値をセット
			while(rs.next()) {
				bean.addLectureNmList(rs.getString("lecture_nm"));
				bean.addYoubiList(Utils.convertIntToYoubi(Integer.parseInt(rs.getString("youbi"))));
				bean.addPeriodList(rs.getString("period"));
				bean.addTeacherNmList(rs.getString("family_nm"));
				bean.addKaisaiDateList(rs.getString("kaisai_date"));
				bean.addLectureScheduleIdList(rs.getString("lecture_schedule_id"));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new ServletException(e);
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e) {
			}
		}

		// リクエストにセット
		//request.setAttribute("bean", bean);


		// 履修講義一覧画面を表示
		request.getRequestDispatcher("A02/Top.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
