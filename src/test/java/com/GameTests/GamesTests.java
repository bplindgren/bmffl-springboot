package com.GameTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.repository.GameRepository;
import com.service.GameService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {GameService.class})
class GamesTests {
	
	@Autowired
	private GameService service;
	
	@MockBean
	private GameRepository gameRepo;
	
	@Test
	void test() {
		GameService gameService = new GameService();
		System.out.println(gameService);
		
		
	}

}
