package com.gxz.autodev.config;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PersonMapper {

    @Select("select * from person")
    List<Person> getPerson();
}
