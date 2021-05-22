package com.woow.wu7.controller;

import com.woow.wu7.bean.MusicBean;
import com.woow.wu7.service.MusicService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
//@Api(tags = "歌曲crud") // swagger
public class MusicController {

    @Autowired
    MusicBean musicBean;

    @Autowired
    MusicService musicService;

    // 查
    @GetMapping("/all-music")
    @ApiOperation(value = "查询所有歌曲", notes = "查询所有歌曲-备注") // swagger
    public List<MusicBean> getAllMusics() {
        return musicService.getAllMusics();
    }

    // 查
    @GetMapping("musics")
    @ApiOperation(value = "分页条件查询歌曲", notes = "分页条件查询歌曲-备注") // swagger
    @ApiImplicitParams({
            @ApiImplicitParam(name = "search", value = "查询字段"),
            @ApiImplicitParam(name = "current", value = "当前页", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页的数量", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 400, message = "客户端错误"),
            @ApiResponse(code = 200, message = "请求成功")
    })
    public List<MusicBean> getMusics(
            @RequestParam(name = "pageSize", defaultValue = "8") Integer pageSize,
            @RequestParam(name = "current", defaultValue = "1") Integer current,
            @RequestParam(name = "search", required = false) String search
    ) {
        Integer offset = pageSize * (current - 1);
        // 如果前端不传search字段，则这里search的值是null
        if (search != null) {
            return musicService.getMusics(search, pageSize, offset);
        } else {
            return musicService.getAllMusics();
        }
    }

    // 查详情
    @GetMapping("/music/{id}")
    @ApiOperation(value = "查询歌曲详情", notes = "查询歌曲详情-备注") // swagger
    public MusicBean getMusic(
            @PathVariable Integer id
    ) {
        return musicService.getMusic(id);
    }


    // 增
    @PostMapping("/music")
    public Object addMusic(
            // @Validated // spring-boot-starter-validation 验证插件，然后在music实体中添加具体的验证规则
            @Valid // spring-boot-starter-validation
            @RequestBody MusicBean music,
            BindingResult br, // spring-boot-starter-validation
            HttpServletResponse resp // spring-boot-starter-validation
    ) {
        if (br.hasErrors()) {
            resp.setStatus(412); // 412 一个或者多个请求头字段在当前请求中报错
            log.info(br.getFieldError().getDefaultMessage());
            return br.getFieldError().getDefaultMessage();
        }
        return musicService.addMusic(music);
    }

    // 删
    @DeleteMapping("/music/{id}")
    public Integer deleteMusic(
            @PathVariable Integer id
    ) {
        return musicService.deleteMusic(id);
    }

    // 改
    @PutMapping("/music/{id}")
    public Integer editMusic(
            @PathVariable Integer id,
            @RequestBody MusicBean musicBean
    ) {
        return musicService.editMusic(id, musicBean);
    }
}
