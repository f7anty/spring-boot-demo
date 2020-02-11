package com.example.demo;

import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface BaseMapper<T> extends com.baomidou.mybatisplus.core.mapper.BaseMapper<T> {

    //List<Integer> selectIdByPage(RowBounds rowBounds, @Param("cm" ) Map<String, Object> params);

}
