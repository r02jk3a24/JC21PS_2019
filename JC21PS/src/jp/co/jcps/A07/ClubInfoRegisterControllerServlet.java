package jp.co.jcps.A07;

import java.io.IOException;
import java.sql.ResultSet;
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
 * 部活情報登録画面のコントローラー
 */
@WebServlet("/ClubInfoRegisterController")
public class ClubInfoRegisterControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * コンストラクタ
	 */
	public ClubInfoRegisterControllerServlet() {
		super();
	}

	/**
	 * GETメソッドでリクエストされた場合の処理
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 共通チェック
		if (!CommonCheck.existSession(request)) {
			// セッションが切れてる場合はログイン画面に遷移
			request.getRequestDispatcher("/Login").forward(request, response);
		}

		// セッションからログイン中のユーザーの部長クラブIDを取得する
		String leaderClubId = (String) request.getSession().getAttribute("leaderClubId");

		// SQLに埋め込むパラメータリストを定義
		List<String> paramList = new ArrayList<String>();
		/* TODO
		 * SQLに埋め込む値をparamListに設定しなさい。
		 * ヒント①
		 * paramListはaddメソッドで要素を追加できる。
		 * ヒント②
		 * ログインユーザーが部長を務める部活への登録申請を表示する画面。
		 */



		// TODO : データベースから必要な情報を取得するためのSQL文を完成させなさい。
		String sql = "SELECT ";

		// SQLを実行し結果を取得
		DBConnection db = new DBConnection();

		// 部活情報登録画面のBeanを初期化
		ClubInfoRegisterBean bean = new ClubInfoRegisterBean();

		try {
			ResultSet rs = db.executeSelectQuery(sql, paramList);
			// beanにDBから取得した値をセット
			while (rs.next()) {
				bean.setClubName(rs.getString("club_name"));
				bean.setClubDescription(rs.getString("club_description"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			request.getRequestDispatcher("ERROR/Error.jsp").forward(request, response);
		} finally {
			try {
				db.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		// beanをリクエストにセット
		request.setAttribute("bean", bean);

		// 部活情報登録画面を表示
		request.getRequestDispatcher("A07/ClubInfoRegister.jsp").forward(request, response);
	}

}
