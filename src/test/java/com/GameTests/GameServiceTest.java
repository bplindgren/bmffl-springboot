package com.GameTests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.entity.Game;
import com.google.gson.Gson;
import com.service.GameService;

@RunWith(SpringRunner.class)
@SpringBootTest
class GameServiceTest {
	
	@Autowired
	private GameService gameService;
	
	@MockBean
	private RestTemplate template;
	
	@Test
	void getGames() throws IOException {
		String filePath = "src/test/java/com/GameTests/games.json";
		
		String gameInfoJson= new String(Files.readAllBytes(Paths.get(filePath)));
		Gson gson = new Gson();  
		Game[] gameInfoArray = gson.fromJson(gameInfoJson, Game[].class);
		
		int numGames = gameInfoArray.length;
		assertEquals(697, numGames);
	}
	
//	@Test
//	void getGamesByGameTypeTest() throws IOException {
//		
//	}
//	
//	@Test
//	void getGamesByTeamIdTest() throws IOException, ParseException {
//		
//        
//	}

}
