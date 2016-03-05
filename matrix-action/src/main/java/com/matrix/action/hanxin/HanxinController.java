package com.matrix.action.hanxin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.matrix.biz.extract.hanxin.impl.HxNameCidCheckBizImpl;

/**
 * 功能：翰鑫接口控制器
 *
 * @author matrix
 * @version 1.0
 * @date 2016年3月5日
 */
@Controller
public class HanxinController {

	@Resource(name = "hxNameCidCheckBizImpl")
	private HxNameCidCheckBizImpl checkBizImpl;

	@RequestMapping("name_cid_check")
	@ResponseBody
	public Object checkNameCid() {
		return checkBizImpl.getNameCidEntryByCid();
	}

}
