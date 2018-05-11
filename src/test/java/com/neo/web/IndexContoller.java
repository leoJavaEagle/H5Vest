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
import com.neo.mapper.IndexMapper;
import com.neo.mapper.ProblemMapper;

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
	public void showProblemDetails() {
		List<TProblem> list = problemMapper.showProblemDetails("2");
		System.out.println(list.get(0).getTitle());
		System.out.println(list.get(0).getContent());
	}
	
	@Test
	public void vestTest() {
		
	}
	
}
