package com.woow.wu7.service;

import com.woow.wu7.bean.MusicBean;
import com.woow.wu7.mapper.MusicMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class MusicService {

    @Autowired
    MusicMapper musicMapper;

    public List<MusicBean> getAllMusics() {
        return musicMapper.allList();
    }

    public List<MusicBean> getMusics(String search, Integer pageSize, Integer offset) {
        return musicMapper.list(search, pageSize, offset);
    }

    public MusicBean getMusic(Integer id) {
        return musicMapper.detail(id);
    }


    public Integer addMusic(MusicBean musicBean) {
        Timestamp startTime = musicBean.getStartTime();
        Timestamp endTime = musicBean.getEndTime();
        long time = new Date().getTime();
        Timestamp timestamp = new Timestamp(time);
        log.info("startTime{}", startTime);
        if (startTime == null) {
            musicBean.setStartTime(timestamp);
        }
        if (endTime == null) {
            musicBean.setEndTime(timestamp);
        }
        log.info("musicBean{}", musicBean);
        return musicMapper.insert(musicBean);
    }

    public Integer deleteMusic(Integer id) {
        return musicMapper.delete(id);
    }

    public Integer editMusic(Integer id, MusicBean musicBean) {
        Timestamp startTime = musicBean.getStartTime();
        Timestamp endTime = musicBean.getEndTime();
        long time = new Date().getTime();
        Timestamp timestamp = new Timestamp(time);
        log.info("startTime1111{}", startTime);
        log.info("startTime1111{}", endTime);
        if (startTime == null) {
            musicBean.setStartTime(timestamp);
        }
        if (endTime == null) {
            musicBean.setEndTime(timestamp);
        }
        log.info("id{}", id);
        log.info("startTime2222{}", startTime);
        log.info("startTime2222{}", endTime);
        return musicMapper.update(id, musicBean);
    }
}
