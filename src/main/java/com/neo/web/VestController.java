package com.neo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neo.entity.BaseDataResp;
import com.neo.entity.TModel;
import com.neo.mapper.VestMapper;

@Controller
@RequestMapping("/vest")
public class VestController {
	
	@Autowired
	private VestMapper vestMapper;

	/**
	 * 查询马甲审核状态
	 * @param source
	 * @param marketCode
	 * @return
	 */
	@RequestMapping("/auditing")
	@ResponseBody
	public BaseDataResp findAuditingStatus(String source, String marketCode) {
		BaseDataResp resp = new BaseDataResp();
		String statusInfo = vestMapper.findAuditingStatus(source, marketCode);
		if(statusInfo == null) {
			resp.setCode("0001");
			resp.setMessage("查询错误！");
			return resp;
		}else if("0".equals(statusInfo)) {
			resp.setCode("0002");
			resp.setMessage("审核中");
			BaseDataResp re = showModel(source, marketCode);
			if("0000".equals(re.getCode())) {
				resp.setDate(re.getDate());
			}
		}else {
			resp.setCode("0000");
			resp.setMessage("审核通过");
		}
		resp.setDate(statusInfo);
		return resp;
	}
	
	/**
	 * 状态为审核中，显示模板
	 */
	public BaseDataResp showModel(String source, String marketCode) {
		BaseDataResp resp = new BaseDataResp();
		TModel model = vestMapper.showModel(source, marketCode);
		if(model == null) {
			resp.setCode("0001");
			resp.setMessage("模板不存在");
			return resp;
		}
		resp.setCode("0000");
		resp.setMessage("成功");
		resp.setDate(model);
		return resp;
	}
	
}
