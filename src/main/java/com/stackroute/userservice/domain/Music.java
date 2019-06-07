package com.stackroute.userservice.domain;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;


//domain class for the track application - inserting the id, name and comments

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class Music {

    @Id
    @ApiModelProperty(value = "id of each track")
    private int trackId;
    @ApiModelProperty(value = "name of each track")
    private String trackName;
    @ApiModelProperty(value = "comments of each track")
    private String comments;

}
