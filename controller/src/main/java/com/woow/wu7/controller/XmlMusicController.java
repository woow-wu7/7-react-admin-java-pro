package com.woow.wu7.controller;

import com.woow.wu7.bean.MusicBean;
import com.woow.wu7.service.XmlMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class XmlMusicController {

    @Autowired
    XmlMusicService xmlMusicService;

    @GetMapping("/xml-all-music")
    public List<MusicBean> getAllMusic() {
        return xmlMusicService.getAllMusic();
    }
}
