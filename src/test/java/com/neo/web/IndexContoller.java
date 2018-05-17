package com.neo.web;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.neo.entity.TProblem;
import com.neo.entity.TProduct;
import com.neo.entity.User;
import com.neo.mapper.IndexMapper;
import com.neo.mapper.LoginMapper;
import com.neo.mapper.ProblemMapper;
import com.neo.mapper.VestMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IndexContoller {

	@Autowired
    private WebApplicationContext wac;
	private MockMvc mockMvc;
	
	@Autowired
	private IndexMapper indexMapper;
	
	@Autowired
	private ProblemMapper problemMapper;
	
	@Autowired
	private VestMapper vestMapper;
	
	@Autowired
	private LoginMapper loginMapper;

    @Before
    public void setUp() throws Exception {
    	mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

	@Test
	public void showIndex() {
		List<TProduct> list = indexMapper.showIndex();
		for(TProduct product : list) {
			System.out.println(product.getProductName());
		}
	}
	
	@Test
	public void showProblem() {
		List<TProblem> list = problemMapper.showProblem();
		for(TProblem problem : list) {
			System.out.println(problem.getTitle());
		}
	}
	
	
	@Test
	public void vestTest() {
		String status = vestMapper.findAuditingStatus("ios", "ios");
		System.out.println("审核状态 : " + status);
	}
	
	@Test
	public void checkLogin() {
		User user = loginMapper.userLogin("lisi", "123");
		System.out.println(user.getUsername());
	}
	
}
