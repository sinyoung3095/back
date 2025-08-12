package com.example.rebound.config.mybatis.converter;

import com.example.rebound.common.enumeration.Common;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CommonConverter implements Converter<String, Common> {

    @Override
    public Common convert(String source) {return Common.getValueFromCommon(source);}
}
