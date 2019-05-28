//package com.stackroute.userservice.config;
//
//import com.stackroute.userservice.domain.Music;
//import com.stackroute.userservice.service.MusicService;
//import lombok.Data;
////import org.hibernate.cfg.Environment;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.core.env.Environment;
//import org.springframework.stereotype.Component;
//
//@Component
////@Configuration
////@PropertySource("classpath:application.properties")
//public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
//
//    MusicService musicService;
//    Music musicData=new Music();
//
//    public StartupApplicationListener(MusicService musicService) {
//        this.musicService = musicService;
//    }
//
//        @Value("${song.total}")
//    private int totalSongs;
//    @Value("${song.1.id}")
//    private int id1;
//    @Value("${song.1.name}")
//    private String name1;
//    @Value("${song.1.comment}")
//    private String comment1;
//
//    @Value("${song.2.id}")
//    private int id2;
//    @Value("${song.2.name}")
//    private String name2;
//    @Value("${song.2.comment}")
//    private String comment2;
//
//    @Value("${song.3.id}")
//    private int id3;
//    @Value("${song.3.name}")
//    private String name3;
//    @Value("${song.3.comment}")
//    private String comment3;
//
////   Environment environment;
////
////    public StartupApplicationListener(Environment environment) {
////        this.environment = environment;
////    }
//
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//        musicData.setTrackId(id1);
//        musicData.setTrackName(name1);
//        musicData.setComments(comment1);
//        musicService.seedData(musicData);
//
//        musicData.setTrackId(id2);
//        musicData.setTrackName(name2);
//        musicData.setComments(comment2);
//        musicService.seedData(musicData);
//
//        musicData.setTrackId(id3);
//        musicData.setTrackName(name3);
//        musicData.setComments(comment3);
//        musicService.seedData(musicData);
//
//
//    }
//}
//
