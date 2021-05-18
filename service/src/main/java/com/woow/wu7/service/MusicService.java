package com.woow.wu7.service;

import com.woow.wu7.bean.MusicBean;
import com.woow.wu7.mapper.MusicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService {

    @Autowired
    MusicMapper musicMapper;

    public List<MusicBean> getAllMusics() {
        return musicMapper.allList();
    }

    public List<MusicBean> getMusics(String search, Integer pageSize, Integer current) {
        Integer offset = pageSize * ( current -1);
        return musicMapper.list(search, pageSize, offset);
    }

    public MusicBean getMusic(Integer id) {
        return musicMapper.detail(id);
    }


}
