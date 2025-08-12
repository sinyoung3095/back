package com.example.rebound.config.mybatis.converter;

import com.example.rebound.common.enumeration.ApprovalStatus;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ApprovalStatusConverter implements Converter<String, ApprovalStatus> {
    @Override
    public ApprovalStatus convert(String source) {
        return ApprovalStatus.valueOf(source);
    }
}
