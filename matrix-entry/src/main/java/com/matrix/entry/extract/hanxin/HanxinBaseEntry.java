package com.matrix.entry.extract.hanxin;

import com.matrix.entry.BaseEntry;

/**
 * 功能：翰鑫实体父类
 *
 * @author matrix
 * @version 1.0
 * @date 2016年3月5日
 */
public class HanxinBaseEntry extends BaseEntry {

	/**
	 * 响应码
	 */
	private String respCode;

	/**
	 * 响应描述信息
	 */
	private String respDesc;
	
	/**
	 * 流水号
	 */
	private String seqNo;
	
	/**
	 * 接口编号
	 */
	private String interfaceNo;

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getRespDesc() {
		return respDesc;
	}

	public void setRespDesc(String respDesc) {
		this.respDesc = respDesc;
	}

	public String getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}

	public String getInterfaceNo() {
		return interfaceNo;
	}

	public void setInterfaceNo(String interfaceNo) {
		this.interfaceNo = interfaceNo;
	}

}
