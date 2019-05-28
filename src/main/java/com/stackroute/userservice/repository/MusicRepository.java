package com.stackroute.userservice.repository;

import com.stackroute.userservice.domain.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicRepository extends JpaRepository<Music, Integer> {


    @Query(value = "select * from music where track_name = ?", nativeQuery = true)
    public List<Music> getTrackByName(String name);
}
