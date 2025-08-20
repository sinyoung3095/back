package com.example.rebound.repository;

import com.example.rebound.dto.SubscribeDTO;
import com.example.rebound.mapper.SubscribeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SubscribeDAO {
    private final SubscribeMapper subscribeMapper;
    public void insertSubscribe(SubscribeDTO subscribeDTO) {
        subscribeMapper.insertSubscribe(subscribeDTO);
    }
}
