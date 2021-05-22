package com.woow.wu7.mapper;

import com.woow.wu7.bean.MusicBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

// 这里一定要注意是一个 interface 好多次了，都是这里写成了class导致报错
// 还有一个地方是，在controller上返回数据而不是页面时，需要使用 @RestController
@Mapper
public interface MusicMapper {

    @Select("SELECT * from music")
    public List<MusicBean> allList();


    // offer = pageSize * (current - 1) // limit offset,pageSize
    @Select(
            "SELECT * from music where"
                    + " name like CONCAT('%',#{search},'%') or "
                    + " album like CONCAT('%',#{search},'%') or "
                    + " singer like CONCAT('%',#{search},'%')"
                    + " limit #{offset},#{pageSize}"
    )
    List<MusicBean> list(String search, Integer pageSize, Integer offset);


    @Select("select * from music where id = #{musicId}")
    MusicBean detail(Integer musicId);


    @Insert("insert into music (name, album, singer, startTime, endTime) values" +
            " (#{name}, #{album}, #{singer}, #{startTime}, #{endTime})")
    Integer insert(MusicBean musicBean);


    @Delete("delete from music where" +
            " id=#{id}")
    Integer delete(Integer id);

    @Update("update music set " +
            " name=#{musicBean.name}, album=#{musicBean.album}, singer=#{musicBean.singer}, startTime=#{musicBean.startTime}, endTime=#{musicBean.endTime} where " +
            " id=#{id}")
    Integer update(@Param("id") Integer id, @Param("musicBean") MusicBean musicBean);
}
