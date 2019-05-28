//package com.stackroute.userservice.config;
//
//import com.stackroute.userservice.domain.Music;
//import com.stackroute.userservice.service.MusicService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//
//@Component
//public class StartupApplicationRunner{
//
//    private Music musicData = new Music();
//
//    @Value("${song.total}")
//    private int totalSongs;
//    @Value("${song.1.id}")
//    private int id1;
//    @Value("${song.1.name}")
//    private String name1;
//    @Value("${song.1.comment}")
//    private String comment1;
//    @Value("${song.2.id}")
//    private int id2;
//    @Value("${song.2.name}")
//    private String name2;
//    @Value("${song.2.comment}")
//    private String comment2;
//    @Value("${song.3.id}")
//    private int id3;
//    @Value("${song.3.name}")
//    private String name3;
//    @Value("${song.3.comment}")
//    private String comment3;
//
//    @Autowired
//    private MusicService musicService;
//
//    @Bean
//    public StartupApplicationRunner(MusicService musicService) {
//        this.musicService = musicService;
//    }
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        musicData.setTrackId(id1);
//        musicData.setTrackName(name1);
//        musicData.setComments(comment1);
//        musicService.addTracks(musicData);
//
//        musicData.setTrackId(id2);
//        musicData.setTrackName(name2);
//        musicData.setComments(comment2);
//        musicService.addTracks(musicData);
//
//        musicData.setTrackId(id3);
//        musicData.setTrackName(name3);
//        musicData.setComments(comment3);
//        musicService.addTracks(musicData);
//
//
//
//
//    }
//}
//
