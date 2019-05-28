package com.stackroute.userservice.domain;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class Music {

    @Id
    @ApiModelProperty(value="id of each track")
    private int trackId;
    @ApiModelProperty(value = "name of each track")
    private String trackName;
    @ApiModelProperty(value="comments of each track")
    private String comments;

//    public Music(int trackId, String trackName, String comments) {
//        this.trackId = trackId;
//        this.trackName = trackName;
//        this.comments = comments;
//    }
//
//    public Music() {
//    }
//
//    public int getTrackId() {
//        return trackId;
//    }
//
//    public void setTrackId(int trackId) {
//        this.trackId = trackId;
//    }
//
//    public String getTrackName() {
//        return trackName;
//    }
//
//    public void setTrackName(String trackName) {
//        this.trackName = trackName;
//    }
//
//    public String getComments() {
//        return comments;
//    }
//
//    public void setComments(String comments) {
//        this.comments = comments;
//    }
//
//    @Override
//    public String toString() {
//        return "Music{" +
//                "trackId=" + trackId +
//                ", trackName='" + trackName + '\'' +
//                ", comments='" + comments + '\'' +
//                '}';
//    }
}
