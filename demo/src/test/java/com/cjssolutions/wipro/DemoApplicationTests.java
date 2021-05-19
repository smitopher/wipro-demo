package com.cjssolutions.wipro;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cjssolutions.wipro.rest.DemoControler;
import com.cjssolutions.wipro.service.WiproService;

@SpringBootTest
class DemoApplicationTests {
	
	@Autowired
	DemoControler controler;

	@Test
	void test_01() {
		
		Map<String, Long> initialLoad = controler.getAll().getBody();
		for (WiproService.InitialClusters cluster : WiproService.InitialClusters.values()) {
			assertEquals(cluster.getCount(), initialLoad.get(cluster.name()));
		}
		
		var result = controler.addServer(WiproService.InitialClusters.Amazon.name()).getBody();
		assertEquals(WiproService.InitialClusters.Amazon.getCount() + 1, result.getServerCount());
		
		result = controler.removeServer(WiproService.InitialClusters.Amazon.name()).getBody();
		assertEquals(WiproService.InitialClusters.Amazon.getCount(), result.getServerCount());
		
	}

}
