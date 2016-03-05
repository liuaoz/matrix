package com.matrix.entry.ewedata;

import java.sql.Timestamp;

import com.matrix.entry.BaseEntry;

/**
 * 功能：取数日志表
 *
 * @author matrix
 * @version 1.0
 * @date 2016年3月5日
 */
public class ExtractLogEntry extends BaseEntry {

	/**
	 * 交易流水号
	 */
	private String seqNo;
	/**
	 * 交易时间
	 */
	private Timestamp tradeTime;
	/**
	 * 客户代码
	 */
	private String customerCode;
	/**
	 * 接口编号
	 */
	private String interfaceNo;
	/**
	 * 请求参数
	 */
	private String reqParams;
	/**
	 * 响应吗
	 */
	private String respCode;
	/**
	 * 响应报文
	 */
	private String respContent;
	/**
	 * 是否收费
	 */
	private boolean isCharge;
	/**
	 * 价格
	 */
	private double price;

	public String getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}

	public Timestamp getTradeTime() {
		return tradeTime;
	}

	public void setTradeTime(Timestamp tradeTime) {
		this.tradeTime = tradeTime;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getInterfaceNo() {
		return interfaceNo;
	}

	public void setInterfaceNo(String interfaceNo) {
		this.interfaceNo = interfaceNo;
	}

	public String getReqParams() {
		return reqParams;
	}

	public void setReqParams(String reqParams) {
		this.reqParams = reqParams;
	}

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getRespContent() {
		return respContent;
	}

	public void setRespContent(String respContent) {
		this.respContent = respContent;
	}

	public boolean isCharge() {
		return isCharge;
	}

	public void setCharge(boolean isCharge) {
		this.isCharge = isCharge;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
