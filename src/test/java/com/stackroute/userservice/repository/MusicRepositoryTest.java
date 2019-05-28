package com.stackroute.userservice.repository;

import com.stackroute.userservice.domain.Music;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;



@RunWith(SpringRunner.class)
//@DataJpaTest
@SpringBootTest
public class MusicRepositoryTest {


        @Autowired
        private MusicRepository musicRepository;
        private Music music;
        private Music music1;

        @Before
        public void setUp()
        {
            music = new Music();
            music.setTrackId(1);
            music.setTrackName("Worth it");
            music.setComments("Fifth Harmony");

            music1=new Music();
            music1.setTrackId(2);
            music1.setTrackName("gehra");
            music1.setComments("jjdaj");

        }

        @After
        public void tearDown(){

            musicRepository.deleteAll();
        }


        @Test
        public void testSaveMusic(){
            musicRepository.save(music);
            Music fetchMusic = musicRepository.findById(music.getTrackId()).get();
            Assert.assertEquals(1,fetchMusic.getTrackId());

        }

        @Test
        public void testSaveMusicFailure(){
            Music testMusic = new Music(2,"gehra ishq","hindi");
            musicRepository.save(music);
            Music fetchMusic= musicRepository.findById(music.getTrackId()).get();
            Assert.assertNotSame(testMusic,music);
        }

        @Test
        public void testGetAllMusic(){
            Music m = new Music(1,"worth it","fifth harmony");
            Music m1 = new Music(2,"gehra ishq","hindi");
            musicRepository.save(m);
            musicRepository.save(m1);

            List<Music> list = musicRepository.findAll();
            Assert.assertEquals("worth it",list.get(0).getTrackName());

        }

    @Test
    public void testGetAllMusicFailure(){
        Music m = new Music(1,"worth it","fifth harmony");
        Music m1 = new Music(2,"gehra ishq","hindi");
        musicRepository.save(m);
        musicRepository.save(m1);
        List<Music> list = musicRepository.findAll();
        Assert.assertNotSame(m,music);
        Assert.assertNotSame(m1,music);
    }

    @Test
    public void updateComment(){
        Music m1=new Music(26,"rAJ","MALYA");
        musicRepository.save(m1);

    }

    @Test
public void deleteMusic(){
            Music m1=new Music(1,"hello","adele");
            musicRepository.delete(m1);
    }


    }

