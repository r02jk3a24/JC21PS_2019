package jp.co.jcps.DisplayBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jp.co.jcps.Bean.TrnJoinRequestBean;

/**
 * 部員登録申請画面のBean
 */
public class JoinRequestBean implements Serializable {

	// 参加登録リスト
	private List<TrnJoinRequestBean> joinRequestList;

	/**
	 * コンストラクタ
	 *
	 */
	public JoinRequestBean() {
		this.joinRequestList = new ArrayList<>();
	}

	/**
	 * @return joinRequestList
	 */
	public List<TrnJoinRequestBean> getJoinRequestList() {
		return joinRequestList;
	}

	/**
	 * @param joinRequestList セットする joinRequestList
	 */
	public void setJoinRequestList(List<TrnJoinRequestBean> joinRequestList) {
		this.joinRequestList = joinRequestList;
	}

	/**
	 * @param TrnJoinRequestBean リストに追加する
	 */
	public void addJoinRequestList(TrnJoinRequestBean joinRequest) {
		this.joinRequestList.add(joinRequest);
	}
}
