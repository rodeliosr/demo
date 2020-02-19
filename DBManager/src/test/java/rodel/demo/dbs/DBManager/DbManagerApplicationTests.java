package rodel.demo.dbs.DBManager;

import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import rodel.demo.dbs.DBManager.entity.CartProduct;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.validation.constraints.AssertTrue;

@SpringBootTest
class DbManagerApplicationTests {


	@Autowired
	MessagePublisher messagePublisher;

	@Autowired
	StoreRepository storeRepository;

	@Test
	void contextLoads() {

	}

	@Test
	public void testAMQconnectivity(){
		String json = "{\"recid\":0,\"cartid\":1,\"itemno\":1001,\"details\":\"TEST 1001\",\"qty\":10,\"amount\":100.0}" ;
		System.out.println("Testing AMQ Connection!");
		assertTrue(messagePublisher.sendMessage(json));
	}

	@Test
	public void testDatabase() {

	}


}
