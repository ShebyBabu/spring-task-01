package com.stackroute.userservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.userservice.MusicServiceApplicationTests;
import com.stackroute.userservice.domain.Music;
import com.stackroute.userservice.exceptions.TrackAlreadyExistException;
import com.stackroute.userservice.exceptions.TrackNotFoundException;
import com.stackroute.userservice.service.MusicService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@WebMvcTest
public class MusicControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private Music music;
    @MockBean
    private MusicService musicService;
    @InjectMocks
    private MusicController musicController;

    private List<Music> list = null;

    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(musicController).build();
        music = new Music();
        music.setTrackId(1);
        music.setTrackName("Worth it");
        music.setComments("Fifth Harmony");
        list = new ArrayList();
        list.add(music);
    }

    @Test
    public void saveMusic() throws Exception {
        when(musicService.addTracks(any())).thenReturn(music);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/music")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(music)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());


    }

    @Test
    public void saveMusicFailure() throws Exception {
        when(musicService.addTracks(any())).thenThrow(TrackAlreadyExistException.class);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/music")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(music)))
                .andExpect(MockMvcResultMatchers.status().isConflict())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getAllMusic() throws Exception {
        when(musicService.getAllMusic()).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/display")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(music)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    public void getAllMusicFailure() throws Exception {
        when(musicService.getAllMusic()).thenThrow(TrackNotFoundException.class);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/display")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(music)))
                .andExpect(MockMvcResultMatchers.status().isConflict())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void updateCommentTest() throws Exception {
        when(musicService.updateComment(any())).thenReturn(music);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/music")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(music)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());


    }

    @Test
    public void updateCommentTestFailure() throws Exception {
        when(musicService.updateComment(any())).thenThrow(TrackNotFoundException.class);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/music")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(music)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());
    }



    @Test
    public void deleteMusic() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/music/{id}",1)
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(music)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }



    @Test
    public void searchByNameTest() throws Exception {
        when(musicService.searchByName(anyString())).thenReturn(list);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/music/{name}","worth it")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(music)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());


    }
    @Test
    public void searchByNameTestFailure() throws Exception {
        when(musicService.searchByName(anyString())).thenThrow(TrackNotFoundException.class);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/music/{name}","worth it")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(music)))
                .andExpect(MockMvcResultMatchers.status().isConflict())
                .andDo(MockMvcResultHandlers.print());
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}












