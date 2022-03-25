package com.example.songr;

import com.example.songr.domain.Album;
import com.example.songr.web.AlbumController;
import com.example.songr.web.HelloController;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
class SongrApplicationTests {
    Album album ;

	////////////////////////////////// Added : ////////////////////////////////
	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext webapplicationContext;
	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webapplicationContext).build();
	}
	//////////////////////////////////////////////////////////////////////////
	@Test
	public void testHomePage() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/"))
				.andExpect(status().isOk())
				.andExpect(content().contentType("text/html;charset=UTF-8"))
				.andExpect(view().name("Home"))
				.andExpect(content().string(Matchers.containsString("Welcome Songr App")));
	}
	@Test
	public void testHelloPage() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
				.andExpect(status().isOk())
				.andExpect(content().contentType("text/html;charset=UTF-8"))
				.andExpect(view().name("hello"))
				.andExpect(content().string(Matchers.containsString("Hello World")))
				.andExpect(content().string(Matchers.containsString("Welcome")));
	}
	@Test
	public void testHelloNamePage() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hello?name=alaa"))
				.andExpect(status().isOk())
				.andExpect(content().contentType("text/html;charset=UTF-8"))
				.andExpect(view().name("hello"))
				.andExpect(content().string(Matchers.containsString("Hello World")))
				.andExpect(content().string(Matchers.containsString("Welcome alaa")));
	}
	////////////////////////////////////////////////////////////////////////
	@Test
	void contextLoads() {
	}
	@Test void TestAlbumClass(){
		album = new Album("Growth","Kareem Ali",10,10,"https://www.rollingstone.com/wp-content/uploads/2020/12/Kareem-Ali-Growth.jpg?w=1000");
		assertTrue(album.getArtist().equals("Kareem Ali"));
		assertTrue(album.getTitle().equals("Growth"));
		assertTrue(album.getLength() == 10);
		assertTrue(album.getSongCount() == 10);
		assertTrue(album.getImageUrl().equals("https://www.rollingstone.com/wp-content/uploads/2020/12/Kareem-Ali-Growth.jpg?w=1000"));

	}

}
