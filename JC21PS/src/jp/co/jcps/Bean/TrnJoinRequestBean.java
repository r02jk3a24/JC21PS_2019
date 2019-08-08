package jp.co.jcps.Bean;

import java.io.Serializable;

/**
 * trn_join_requestテーブルのBean
 */
public class TrnJoinRequestBean implements Serializable {

	// 部活ID
	private String clubId;
	// 部活名
	private String clubName;
	// 部活説明
	private String clubDescription;

	/**
	 * コンストラクタ
	 *
	 */
	public TrnJoinRequestBean() {
		this.clubName = "";
		this.clubName = "";
		this.clubDescription = "";

	}

	/**
	 * @return clubId
	 */
	public String getClubId() {
		return clubId;
	}

	/**
	 * @param clubId セットする clubId
	 */
	public void setClubId(String clubId) {
		this.clubId = clubId;
	}

	/**
	 * @return clubName
	 */
	public String getClubName() {
		return clubName;
	}

	/**
	 * @param clubName セットする clubName
	 */
	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	/**
	 * @return clubDescription
	 */
	public String getClubDescription() {
		return clubDescription;
	}

	/**
	 * @param clubDescription セットする clubDescription
	 */
	public void setClubDescription(String clubDescription) {
		this.clubDescription = clubDescription;
	}


}
