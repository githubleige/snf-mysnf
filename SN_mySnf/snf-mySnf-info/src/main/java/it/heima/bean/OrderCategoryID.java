package it.heima.bean;

import javax.persistence.Column;
import java.io.Serializable;

public class OrderCategoryID implements Serializable {

    private static final long serialVersionUID = -8760566371482273008L;

	public final static String OMS_CATEGORY_ID_STR = "omsCategoryID";

    /** The shard id. */
	public String shardId;

	/** The table id. */
	public String tableId;

	/** The dbNo id. */
	public String dbNo;

	@Column(insertable = false, updatable = false)
	public String getShardId() {
		return shardId;
	}

	public void setShardId(String shardId) {
		this.shardId = shardId;
	}


	@Column(insertable = false, updatable = false)
	public String getTableId() {
		return tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	@Column(insertable = false, updatable = false)
	public String getDbNo() {
		return dbNo;
	}

	public void setDbNo(String dbNo) {
		this.dbNo = dbNo;
	}

	/**
	 * 库号
	 */
	private transient String omsCategoryID;

	/**
	 * 表号
	 */
	private transient String omsTableID;

	@Column
	public String getOmsCategoryID() {
		return omsCategoryID;
	}

	public void setOmsCategoryID(String omsCategoryID) {
		this.omsCategoryID = omsCategoryID;
	}

	public String getOmsTableID() {
		return omsTableID;
	}

	public void setOmsTableID(String omsTableID) {
		this.omsTableID = omsTableID;
	}


}
