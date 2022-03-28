package com.example.songr.infrastructure;

import com.example.songr.domain.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SongRepository extends JpaRepository<Song,Long> {
    void deleteById(Long id);
    List<Song> findByAlbumId(Long id);
}
