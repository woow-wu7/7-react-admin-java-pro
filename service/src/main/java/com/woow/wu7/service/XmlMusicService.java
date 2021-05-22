package com.woow.wu7.service;

import com.woow.wu7.bean.MusicBean;
import com.woow.wu7.mapper.XmlMusicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XmlMusicService {

    @Autowired
    XmlMusicMapper xmlMusiceMapper;

    public List<MusicBean> getAllMusic() {
        return xmlMusiceMapper.allList();
    }
}
