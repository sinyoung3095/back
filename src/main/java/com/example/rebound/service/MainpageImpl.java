package com.example.rebound.service;

import com.example.rebound.dto.PostDTO;
import com.example.rebound.repository.MainpageDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MainpageImpl implements MainpageService {
    private final MainpageDAO mainpageDAO;

    @Override
    public List<PostDTO> getLists() {
        return mainpageDAO.findTitleAndContent();
    }
}
