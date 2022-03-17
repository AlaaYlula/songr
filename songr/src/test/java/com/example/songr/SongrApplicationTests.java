package com.example.songr;

import com.example.songr.domain.Album;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SongrApplicationTests {
    Album album ;
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
