package com.example.rebound.config.mybatis.converter;

import com.example.rebound.common.enumeration.Mentor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MentorConverter implements Converter<String, Mentor> {

    @Override
    public Mentor convert(String source) {return Mentor.getMentorFromValue(source);}
}
