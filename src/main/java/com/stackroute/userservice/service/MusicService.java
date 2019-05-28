package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.Music;
import com.stackroute.userservice.exceptions.TrackAlreadyExistException;
import com.stackroute.userservice.exceptions.TrackNotFoundException;

import java.util.List;

public interface MusicService {

    public List<Music> getAllMusic() throws TrackNotFoundException;
    public Music addTracks(Music music) throws TrackAlreadyExistException;
    public Music updateComment(Music music) throws TrackNotFoundException;
    public List<Music> deleteMusic(int id);
public List<Music> searchByName(String name) throws TrackNotFoundException;
public void seedData(Music music);
}

