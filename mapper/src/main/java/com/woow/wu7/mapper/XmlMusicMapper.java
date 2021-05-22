package com.woow.wu7.mapper;

import com.woow.wu7.bean.MusicBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface XmlMusicMapper {
    List<MusicBean> allList();
}
