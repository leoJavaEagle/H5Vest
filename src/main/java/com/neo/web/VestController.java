package com.neo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neo.entity.BaseDataResp;
import com.neo.entity.TArticle;
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
	public BaseDataResp showModel(@RequestBody Source util) {
		BaseDataResp resp = new BaseDataResp();
		TModel model = vestMapper.showModel(util.getSource(), util.getMarketCode());
		if(model == null) {
			resp.setCode("000001");
			resp.setMessage("模板不存在");
			return resp;
		}
		resp.setCode("000000");
		resp.setMessage("查询成功");
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
//		System.out.println(util.getSource() + ",1  " + util.getMarketCode());
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
	
	/**
	 * 更新全部model
	 * @param ta
	 */
	@ResponseBody
    @RequestMapping(value="/updateModel")
    public BaseDataResp update(TModel model) {
    	BaseDataResp resp = new BaseDataResp();
    	Integer s = vestMapper.update(model);
    	if(s==0){
    		resp.setCode("000001");
			resp.setMessage("更新失败");
			return resp;
    	}else{
			resp.setCode("000000");
			resp.setMessage("更新成功");
		}
    	return resp;
    }
	
	/**
	 * 插入一条model
	 * @param ta
	 */
	@ResponseBody
    @RequestMapping("/addModel")
    public BaseDataResp save(TModel model) {
    	BaseDataResp resp = new BaseDataResp();
    	Integer s = vestMapper.insert(model);
    	if(s==null){
    		resp.setCode("000001");
			resp.setMessage("添加失败");
			return resp;
    	}else{
			resp.setCode("000000");
			resp.setMessage("添加成功");
		}
    	return resp;
    }
	
	@RequestMapping("/getAllModels")
	@ResponseBody
	public BaseDataResp getAllModels() {
		BaseDataResp resp = new BaseDataResp();
		List<TModel> list=vestMapper.getAll();
//		System.out.println(list.get(0).getMarketName());
		if(null == list){
			resp.setCode("000001");
			resp.setMessage("获取失败");
			return resp;
		}else{
			resp.setCode("000000");
			resp.setMessage("获取成功");
			resp.setData(list);
		}
		return resp;
	}
	
	@ResponseBody
    @RequestMapping("/getModel")
    public BaseDataResp getModel(@RequestParam String id) {
    	BaseDataResp resp = new BaseDataResp();
    	TModel tm=vestMapper.getOne(id);
//    	System.out.println(ta.getTitle());
    	if(null == tm){
			resp.setCode("000001");
			resp.setMessage("获取失败");
			return resp;
		}else{
			resp.setCode("000000");
			resp.setMessage("获取成功");
			resp.setData(tm);
		}
		return resp;
	}
	
	 @RequestMapping("/getModelEdit")
	    public String getModelEdit(){
			
			return "model/model_edit";
		}
	
}
