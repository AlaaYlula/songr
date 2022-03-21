package com.example.songr.infrastructure;

import com.example.songr.domain.Album;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends CrudRepository<Album,Integer> {
    void deleteById(Integer id);
    void deleteBytitle(String title);

}
