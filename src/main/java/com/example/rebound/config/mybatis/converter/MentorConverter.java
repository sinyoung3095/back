package com.example.rebound.config.mybatis.converter;

import com.example.rebound.common.enumeration.Grade;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MentorConverter implements Converter<String, Grade> {

    @Override
    public Grade convert(String source) {return Grade.getMentorFromValue(source);}
}
