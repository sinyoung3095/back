package com.example.rebound.service;

import com.example.rebound.dto.LikeDTO;
import com.example.rebound.repository.LikeDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {
    private final LikeDAO likeDAO;

    @Override
    public void like(LikeDTO likeDTO) {
        likeDAO.save(toLikeVO(likeDTO));
    }
}
