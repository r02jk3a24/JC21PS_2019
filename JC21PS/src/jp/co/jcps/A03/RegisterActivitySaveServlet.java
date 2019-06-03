package jp.co.jcps.A03;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.jcps.Bean.MessageBean;
import jp.co.jcps.Bean.RegisterActivityBean;
import jp.co.jcps.Common.CommonCheck;
import jp.co.jcps.Common.DBConnection;
import jp.co.jcps.Common.Validation;

/**
 * 活動登録画面のコントローラー
 */
@WebServlet("/RegisterActivitySave")
public class RegisterActivitySaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * コンストラクタ
	 */
	public RegisterActivitySaveServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 共通チェック
		if(!CommonCheck.existSession(request)) {
		// セッションが切れてる場合はログイン画面に遷移
			request.getRequestDispatcher("/Login").forward(request, response);
		}

		// リクエストパラメータをBeanに詰め替える
		RegisterActivityBean bean = new RegisterActivityBean();
		bean.setClubName((String) request.getAttribute("registerClubName"));
		if((String) request.getAttribute("registerActivityName") != null) {
			bean.setActivityName((String) request.getAttribute("registerActivityName"));
		}




		// 入力値チェック
		MessageBean msg = checkValid(request);
		if(msg.getMessageList().size() != 0) {

		}

		String sql = ""; // TODO SQLの生成

		// SQLに埋め込むパラメータリストを定義
		List<String> paramList = new ArrayList<String>();
		// paramList.add(leaderClubId); TODO insertクエリに埋め込むパラメータをセット


		// SQLを実行し結果を取得
		DBConnection db = new DBConnection();
		db.executeInsertUpdateQuery(sql, paramList);

		// msgに登録完了メッセージをセット
		msg.addMessageList("登録しました。");

		// TOP画面の呼び出し
		request.getRequestDispatcher("/TopController").forward(request, response);


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

		// セッションからログイン中のユーザーIDを取得する
		String userId = (String) request.getSession().getAttribute("userId");
		String leaderClubId = (String)request.getSession().getAttribute("leaderClubId");

		// SQLに埋め込むパラメータリストを定義
		List<String> paramList = new ArrayList<String>();
		paramList.add(leaderClubId);

		// SQLを設定
		String sql = "SELECT club_name FROM mst_club WHERE club_id = ?;";

		// SQLを実行し結果を取得
		DBConnection db = new DBConnection();
		ResultSet rs = db.executeSelectQuery(sql, paramList);

		// 活動登録画面のBeanを初期化
		RegisterActivityBean bean = new RegisterActivityBean();

		try {
			// beanに部活名をセット
			while(rs.next()) {
				bean.setClubName(rs.getString("club_name"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new ServletException(e);
		} finally {
			try {
				db.close();
			} catch (Exception e) {
			}
		}

		// beanをリクエストにセット
		request.setAttribute("bean", bean);


		// 履修講義一覧画面を表示
		request.getRequestDispatcher("A03/RegisterActivity.jsp").forward(request, response);
	}


	/**
	 * 活動登録画面の入力値チェック
	 *
	 * @param msg
	 * @param request
	 * @return
	 */
	private MessageBean checkValid(HttpServletRequest request) {
		// 返却用MessageBeanを初期化
		MessageBean msg = new MessageBean();

		// 必須チェック
		Validation.checkRequired(request.getParameter("registerActivityName"), "活動名", msg);
		Validation.checkRequired(request.getParameter("registerActivityDate"), "活動日", msg);
		Validation.checkRequired(request.getParameter("registerActivityStartTime"), "活動時間(自）", msg);
		Validation.checkRequired(request.getParameter("registerActivityEndTime"), "活動時間(至）", msg);


		// 桁数チェック
		Validation.checkLegalLengthString(request.getParameter("registerActivityName"), 30, "活動名", msg);
		Validation.checkLegalLengthString(request.getParameter("registerActivityDate"), 10, "活動日", msg);
		if(request.getParameter("registerActivityDescription") != null) {
			Validation.checkLegalLengthString(request.getParameter("registerActivityDescription"), 400, "活動説明", msg);
		}

		// 型チェック
		if(request.getParameter("registerMaxParticipant") != null) {
			Validation.checkCorrectRangeNumber(request.getParameter("registerMaxParticipant"), 1, 99, "募集人数", msg);
		}







		return msg;
	}

}
