package com.example.Metier;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ScriptException;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;

import com.example.Entities.Client;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GesTransferArgntTest0 {
	
	@Autowired
	private JdbcTemplate jdbc;
	private static final String CREATE_CLIENT="scripte/create/testCreate.sql";
	private static final String DROP_CLIENT="script/drop/drop.sql";

	@Before
	public void before() throws ScriptException, SQLException {
		ScriptUtils.executeSqlScript(jdbc.getDataSource().getConnection(), new ClassPathResource(CREATE_CLIENT));
	}
	@After
	public void after() throws ScriptException, SQLException {
		ScriptUtils.executeSqlScript(jdbc.getDataSource().getConnection(), new ClassPathResource(DROP_CLIENT));
	}
	
	@Autowired
	private IBanqueMetier iBanqueMetier;
	
	@Test
	public void ajoutClientTest() {
		String nomClient="client1";
		
		Client client= new Client();
		client.setNom(nomClient);
		assertEquals(0, JdbcTestUtils.countRowsInTableWhere(jdbc, "clientTest", "name ='"+nomClient+"'"));
		iBanqueMetier.addClient(client);
		assertEquals(1, JdbcTestUtils.countRowsInTableWhere(jdbc, "clientTest", "name ='"+nomClient+"'"));
		
	}
	
	
	
	
	
	
}
