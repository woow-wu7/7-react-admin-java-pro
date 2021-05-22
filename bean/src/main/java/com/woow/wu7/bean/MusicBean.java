package com.woow.wu7.bean;

import com.fasterxml.jackson.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
@ApiModel(description = "返回响应的数据") // swagger
@JsonPropertyOrder(value = {"singer", "album"}) // jackson
public class MusicBean {
    @ApiModelProperty(value = "歌曲名") // swagger
    String name;

    @NotBlank(message = "album不能为空") // spring-boot-starter-validation => @NotBlank只能用于字符串，trim后长度必须大于0
    String album;

    @NotNull(message = "singer不能为空") // spring-boot-starter-validation => @NotNull不能为为null，但可以是空字符串
    String singer;

    @JsonProperty(value = "startTimes") // jackson
    @JsonInclude(JsonInclude.Include.NON_NULL) // jackson 属性为null则不返回
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss", timezone = "GMT+8") // jackson
    Timestamp startTime;


    @JsonIgnore // jackson 返回值中忽略该属性
    Timestamp endTime;
}
