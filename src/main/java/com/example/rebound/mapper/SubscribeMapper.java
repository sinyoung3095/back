package com.example.rebound.mapper;

import com.example.rebound.dto.SubscribeDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SubscribeMapper {
    public void insertSubscribe(SubscribeDTO subscribeDTO);
}
