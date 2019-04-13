package ru.fix.knightstepcounter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ru.fix.knightstepcounter.models.Result;
import ru.fix.knightstepcounter.models.ResultMixIn;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class KnightStepCounterApplicationTests {
    private MockMvc mvc;
    @Autowired
    WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    // rest test with good parameters
    @Test
    public void getResultWithGoodParametersFromRest() throws Exception {
        String url = "/hourse/rest/count/?width=10&height=14&start=B1&end=A3";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(url)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        String content = mvcResult.getResponse().getContentAsString();

        Result result = mapResultFromJson(content);
        assertEquals(1, result.getStepCount());
    }

    // rest test with knight position out of chessboard
    @Test
    public void getResultWithBadWidthParameterFromRest() throws Exception {
        String url = "/hourse/rest/count/?width=1&height=14&start=B1&end=A3";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(url)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        String content = mvcResult.getResponse().getContentAsString();

        Result result = mapResultFromJson(content);
        assertEquals(-1, result.getStepCount());
    }

    // rest test with wrong format of 'start' parameter
    @Test
    public void getResultWithNotFullStartParameterFromRest() throws Exception {
        String url = "/hourse/rest/count/?width=10&height=14&start=x&end=A3";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(url)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(400, status);
    }

    // rest test with wrong format of 'start' parameter
    @Test
    public void getResultWithBadStartParameterFromRest() throws Exception {
        String url = "/hourse/rest/count/?width=10&height=14&start=1x&end=A3";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(url)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(400, status);
    }

    // rest test without required parameter
    @Test
    public void getResultWithOutStartParameterFromRest() throws Exception {
        String url = "/hourse/rest/count/?width=10&height=14&end=A3";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(url)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(400, status);
    }

    // servlet test with good parameters
    @Test
    public void getResultWithGoodParametersFromServlet() throws Exception {
        String url = "/hourse/rest/count/?width=10&height=14&start=B1&end=A3";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(url)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        String content = mvcResult.getResponse().getContentAsString();

        Result result = mapResultFromJson(content);
        assertEquals(1, result.getStepCount());
    }

    // servlet test with knight position out of chessboard
    @Test
    public void getResultWithBadWidthParameterFromServlet() throws Exception {
        String url = "/hourse/rest/count/?width=1&height=14&start=B1&end=A3";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(url)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        String content = mvcResult.getResponse().getContentAsString();

        Result result = mapResultFromJson(content);
        assertEquals(-1, result.getStepCount());
    }

    // servlet test with wrong format of 'start' parameter
    @Test
    public void getResultWithNotFullStartParameterFromServlet() throws Exception {
        String url = "/hourse/rest/count/?width=10&height=14&start=x&end=A3";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(url)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(400, status);
    }

    // servlet test with wrong format of 'start' parameter
    @Test
    public void getResultWithBadStartParameterFromServlet() throws Exception {
        String url = "/hourse/rest/count/?width=10&height=14&start=1x&end=A3";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(url)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(400, status);
    }

    // servlet test without required parameter
    @Test
    public void getResultWithOutStartParameterFromServlet() throws Exception {
        String url = "/hourse/rest/count/?width=10&height=14&end=A3";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(url)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(400, status);
    }

    // method for deserializing JSON into an instance of the Result class
    private Result mapResultFromJson(String content) throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES);
        mapper.addMixIn(Result.class, ResultMixIn.class);

        return mapper.readValue(content, Result.class);
    }
}
