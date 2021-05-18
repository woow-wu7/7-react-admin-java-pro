package com.woow.wu7.controller;

import com.woow.wu7.bean.MusicBean;
import com.woow.wu7.service.MusicService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
//@Api(tags = "歌曲crud")
public class MusicController {

    @Autowired
    MusicBean musicBean;

    @Autowired
    MusicService musicService;

    @GetMapping("/all-music")
    @ApiOperation(value = "查询所有歌曲", notes = "查询所有歌曲-备注")
    public List<MusicBean> getAllMusics() {
        return musicService.getAllMusics();
    }

    @GetMapping("musics")
    @ApiOperation(value = "分页条件查询歌曲", notes = "分页条件查询歌曲-备注")
    public List<MusicBean> getMusics(
            @RequestParam(name = "pageSize", defaultValue = "8") Integer pageSize,
            @RequestParam(name = "current", defaultValue = "1") Integer current,
            @RequestParam(name = "search", required = false) String search
    ) {
        log.info("search{}", search);
        if (search != null) {
            return musicService.getMusics(search, pageSize, current);
        } else {
            return musicService.getAllMusics();
        }
    }


    @GetMapping("/music/{id}")
    @ApiOperation(value = "查询歌曲详情", notes = "查询歌曲详情-备注")
    public MusicBean getMusic(
            @PathVariable Integer id
    ) {
        return musicService.getMusic(id);
    }
}
