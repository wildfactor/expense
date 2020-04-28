package com.poc.expense.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poc.expense.dto.AddExpenseDto;
import com.poc.expense.entity.Expense;
import com.poc.expense.service.ExpenseService;
import com.sun.mail.iap.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExpenseControllerTest {

    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext context;

    @MockBean
    ExpenseService expenseService;

    private List<Expense> expenses = new ArrayList<>();

    private AddExpenseDto addExpenseDto;

    private ObjectMapper objectMapper = new ObjectMapper();

    String baseUri = "/api/expenses";

    @Before
    public void setUp() {
        Expense expense = new Expense(1, "sept2020", 200.0, "stationary", "9876");
        expenses.add(expense);
        addExpenseDto = new AddExpenseDto(expenses);
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void addExpenseTest() throws Exception {
        String request = objectMapper.writeValueAsString(addExpenseDto);
        Mockito.when(expenseService.saveExpense(addExpenseDto)).thenReturn(expenses);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(baseUri).accept(MediaType.APPLICATION_JSON)
                .content(request);
        MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isCreated()).andReturn();
//        MvcResult result = mockMvc.perform(post(baseUri).content(request).contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isCreated()).andReturn();

        String resultContent = result.getResponse().getContentAsString();
        Response response = objectMapper.readValue(resultContent, Response.class);
        assertEquals(201, response.isOK());
        assertNotNull(response);
    }

    @Test
    public void getAllExpensesTest() throws Exception {
        Mockito.when(expenseService.getAllExpense()).thenReturn(expenses);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(baseUri);
        MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();

        String resultContent = result.getResponse().getContentAsString();
        Response response = objectMapper.readValue(resultContent, Response.class);
        assertEquals(200, response.isOK());
    }

    @Test
    public void getExpensesByUserTest() throws Exception {
        Mockito.when(expenseService.findByUserId("9876")).thenReturn(expenses);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(baseUri+"/{userId}", 9876);
        MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();

        String resultContent = result.getResponse().getContentAsString();
        Response response = objectMapper.readValue(resultContent, Response.class);
        assertEquals(200, response.isOK());
    }
}
