package com.woow.wu7.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public class MusicBean {
    String name;
    String album;
    String singer;
    Timestamp startTime;
    Timestamp endTime;
}
