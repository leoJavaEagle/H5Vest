package com.neo.web;



import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.neo.entity.TArticle;
import com.neo.entity.TModel;
import com.neo.entity.UserEntity;
import com.neo.mapper.ArticleMapper;
import com.neo.mapper.LoginMapper;
import com.neo.mapper.VestMapper;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
    
    @Autowired
    VestMapper vestMapper;
    @Autowired
    LoginMapper loginMapper;
    @Autowired
    ArticleMapper articleMapper;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build(); //初始化MockMvc对象
    }

//    @Test
    public void getUsers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/getUsers")
                .accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
    }
    
    @Test
    public void test() {
    	TArticle ta=articleMapper.getOne("1");
    	System.out.println(ta.getContent());
	}
    
    @Test
    public void test1() {
    	TModel model = vestMapper.showModel("ios", "ios");
    	System.out.println(model.getMarketCode());
	}
    
    @Test
    public void test2() {
    	UserEntity user = loginMapper.userLogin("lisi", "123");
    	System.out.println(user.getUserSex());
	}


}