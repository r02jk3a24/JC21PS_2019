package jp.co.jcps.A05;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.jcps.Bean.MessageBean;
import jp.co.jcps.Common.CommonCheck;
import jp.co.jcps.Common.DBConnection;

/**
 * 部員登録申請画面の登録処理
 */
@WebServlet("/JoinRequestSave")
public class JoinRequestSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * コンストラクタ
	 */
	public JoinRequestSaveServlet() {
		super();
	}

	/**
	 * POSTでリクエストされた場合
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 共通チェック
		if (!CommonCheck.existSession(request)) {
			// セッションが切れてる場合はログイン画面に遷移
			request.getRequestDispatcher("/Login").forward(request, response);
		}
		//リクエストのエンコードを指定
		request.setCharacterEncoding("UTF-8");

		// SQLを宣言
		String sql = "INSERT INTO trn_join_request (user_id,club_id) VALUES (?,?);";

		// SQLに埋め込むパラメータリストを定義
		List<String> paramList = new ArrayList<String>();
		paramList.add((String) request.getSession().getAttribute("userId"));
		paramList.add(request.getParameter("registClubId"));

		// SQLを実行し結果を取得
		DBConnection db = new DBConnection();
		db.executeInsertUpdateQuery(sql, paramList);

		// msgに登録完了メッセージをセット
		MessageBean msg = new MessageBean();
		msg.addMessageList("部員登録申請をしました。");
		request.setAttribute("messageBean", msg);

		// TOP画面の呼び出し
		request.getRequestDispatcher("/TopController").forward(request, response);
	}
}
