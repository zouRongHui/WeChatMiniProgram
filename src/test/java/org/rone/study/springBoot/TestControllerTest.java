package org.rone.study.springBoot;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.rone.study.springBoot.controller.TestController;
import org.rone.study.springBoot.model.Result;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by rone on 2018/5/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class TestControllerTest {

    private MockMvc mvc;

    @Before
    public void before() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new TestController()).build();
    }

    @Test
    public void test() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mvc.perform(MockMvcRequestBuilders.get("/test/test") .accept(MediaType.
                APPLICATION_JSON))
        .andExpect(status().isOk())
                .andExpect(content().string(equalTo(mapper.writeValueAsString(Result.success()))));
    }

}
