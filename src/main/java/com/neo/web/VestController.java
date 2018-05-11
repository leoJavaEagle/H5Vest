package com.neo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neo.entity.BaseDataResp;
import com.neo.entity.TModel;
import com.neo.mapper.VestMapper;
import com.neo.req.Source;

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
	public BaseDataResp findAuditingStatus(@RequestBody Source util) {
		System.out.println(util.getSource() + ",  " + util.getMarketCode());
		BaseDataResp resp = new BaseDataResp();
		String statusInfo = vestMapper.findAuditingStatus(util.getSource(), util.getMarketCode());
		if(statusInfo == null) {
			resp.setCode("000002");
			resp.setMessage("查询错误！");
			return resp;
		}else if("0".equals(statusInfo)) {
			resp.setCode("000001");
			resp.setMessage("审核中");
		}else {
			resp.setCode("000000");
			resp.setMessage("审核结束");
		}
		resp.setData(statusInfo);
		return resp;
	}
	
	/**
	 * 状态为审核中，显示模块
	 * @param source
	 * @param marketCode
	 * @return
	 */
	@RequestMapping("/showModel")
	@ResponseBody
	public BaseDataResp showModel(String source, String marketCode) {
		BaseDataResp resp = new BaseDataResp();
		TModel model = vestMapper.showModel(source, marketCode);
		if(model == null) {
			resp.setCode("000001");
			resp.setMessage("模板不存在");
			return resp;
		}
		resp.setCode("000000");
		resp.setMessage("成功");
		resp.setData(model);
		return resp;
	}
	
	/**
	 * 查询模块和状态
	 * @param source
	 * @param marketCode
	 * @return
	 */
	@RequestMapping("/showModelAndStatus")
	@ResponseBody
	public BaseDataResp showModelAndStatus(@RequestBody Source util) {
		System.out.println(util.getSource() + ",1  " + util.getMarketCode());
		BaseDataResp resp = new BaseDataResp();
		TModel model = vestMapper.showModelAndStatus(util.getSource(), util.getMarketCode());
		if(model == null) {
			resp.setCode("000002");
			resp.setMessage("模板不存在");
			return resp;
		}else if("0".equals(model.getStatus())){
			resp.setCode("000001");
			resp.setMessage("审核中");
			resp.setData(model);
		}else{
			resp.setCode("000000");
			resp.setMessage("审核结束");
		}
		return resp;
	}
	
}
