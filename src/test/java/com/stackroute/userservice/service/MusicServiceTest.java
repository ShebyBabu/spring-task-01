package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.Music;
import com.stackroute.userservice.exceptions.TrackAlreadyExistException;
import com.stackroute.userservice.exceptions.TrackNotFoundException;
import com.stackroute.userservice.repository.MusicRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.sound.midi.Track;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class MusicServiceTest {


    private Music music;

    //Create a mock for UserRepository
    @Mock
    private MusicRepository musicRepository;

    //Inject the mocks as dependencies into UserServiceImpl
    @InjectMocks
    private MusicServiceImpl musicService;
    List<Music> list = null;


    @Before
    public void setUp() {
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        music = new Music();
        music.setTrackId(1);
        music.setTrackName("Worth it");
        music.setComments("Fifth Harmony");
        list = new ArrayList<>();
        list.add(music);


    }

    @Test
    public void saveMusicTestSuccess() throws TrackAlreadyExistException {
        when(musicRepository.save((Music) any())).thenReturn(music);
        Music savedMusic = musicService.addTracks(music);
        Assert.assertEquals(music, savedMusic);

        //verify here verifies that userRepository save method is only called once
        verify(musicRepository, times(1)).save(music);

    }

    @Test(expected = TrackAlreadyExistException.class)
    public void saveMusicTestFailure() throws TrackAlreadyExistException {
        when(musicRepository.save((Music) any())).thenReturn(null);
        Music savedMusic = musicService.addTracks(music);
        System.out.println("savedMusic" + savedMusic);
        Assert.assertEquals(music, savedMusic);

       /*doThrow(new UserAlreadyExistException()).when(userRepository).findById(eq(101));
       userService.saveUser(user);*/


    }

    @Test
    public void getAllMusic() throws TrackNotFoundException {

        musicRepository.save(music);
        //stubbing the mock to return specific data
        when(musicRepository.findAll()).thenReturn(list);
        List<Music> userlist = musicService.getAllMusic();
        Assert.assertEquals(list, userlist);
    }

    @Test
    public void getAllMusicTestFailure() throws TrackNotFoundException {
        musicRepository.save(music);
        when(musicRepository.findAll()).thenReturn(list);
        List<Music> userlist=musicService.getAllMusic();
        Assert.assertEquals(list, userlist);


    }



    @Test
    public void updateComment() throws TrackNotFoundException{

        when(musicRepository.save((Music) any())).thenReturn(music);
            Music updateMusic = musicService.updateComment(music);
            Assert.assertEquals(music,updateMusic);
        //verify here verifies that userRepository save method is only called once
        verify(musicRepository,times(1)).save(music);

    }

    @Test
    public void updateMusicTestFailure() throws TrackNotFoundException {
        when(musicRepository.save((Music) any())).thenReturn(null);
        Music updateMusic = musicService.updateComment(music);
        Assert.assertEquals(music, updateMusic);
    }


    @Test
    public void deleteMusic() throws TrackNotFoundException {
        musicRepository.save(music);
        when(musicRepository.findAll()).thenReturn(list);
        musicService.deleteMusic(1);
        List<Music> userList=musicService.getAllMusic();
Assert.assertEquals(list,userList);

    }



    @Test
    public void searchByNameTest() throws TrackNotFoundException    {
       // musicRepository.save(music);
        when(musicRepository.getTrackByName(anyString())).thenReturn(list);
        musicService.searchByName(music.getTrackName());

    }

    @Test
    public void searchByNameTestFailure() throws TrackNotFoundException    {
        // musicRepository.save(music);
        when(musicRepository.getTrackByName(anyString())).thenReturn(null);
        musicService.searchByName(music.getTrackName());

    }



}
