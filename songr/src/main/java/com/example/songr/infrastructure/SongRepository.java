package com.example.songr.infrastructure;

import com.example.songr.domain.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song,Long> {
    void deleteById(Long id);
}
