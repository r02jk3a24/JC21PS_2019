package jp.co.jcps.A06;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.jcps.Common.CommonCheck;
import jp.co.jcps.Common.DBConnection;

/**
 * 部員登録承認の登録処理
 */
@WebServlet("/JoinApprovalSave")
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

		// リクエストが情報を取得する
		String registUserId = request.getParameter("userId");
		boolean approval = request.getParameter("approval").equals("true");
		// セッションからログイン中のユーザーの部長クラブIDを取得する
		String leaderClubId = (String) request.getSession().getAttribute("leaderClubId");
		try {
			// 承認する場合
			if (approval) {
				// 部員テーブルに登録する
				saveClubMember(leaderClubId, registUserId);
			}

			//承認する場合はも否認する場合も登録申請テーブルのデータを削除する
			deleteJoinApproval(leaderClubId, registUserId);
		}catch(Exception e) {
			request.getRequestDispatcher("ERROR/Error.jsp").forward(request, response);
		}

		// TOP画面の呼び出し
		request.getRequestDispatcher("/JoinApprovalController").forward(request, response);
	}

	private void saveClubMember(String registClubId, String registUserId) throws Exception {

		//SQLを宣言
		String sql = "INSERT INTO trn_club_member (club_id,user_id,leader_flg) VALUES (?,?,0);";
		// SQLに埋め込むパラメータリストを定義
		List<String> paramList = new ArrayList<String>();
		paramList.add(registClubId);
		paramList.add(registUserId);

		// SQLを実行し結果を取得
		DBConnection db = new DBConnection();
		db.executeInsertUpdateQuery(sql, paramList);
	}

	private void deleteJoinApproval(String registClubId, String registUserId) throws Exception {

		//SQLを宣言
		String sql = "DELETE FROM trn_join_request WHERE club_id = ? AND user_id = ?;";
		// SQLに埋め込むパラメータリストを定義
		List<String> paramList = new ArrayList<String>();
		paramList.add(registClubId);
		paramList.add(registUserId);

		// SQLを実行し結果を取得
		DBConnection db = new DBConnection();
		db.executeInsertUpdateQuery(sql, paramList);
	}
}
