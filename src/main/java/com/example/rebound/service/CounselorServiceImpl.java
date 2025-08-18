package com.example.rebound.service;

import com.example.rebound.dto.CounselorDTO;
import com.example.rebound.repository.CounselorDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Primary
public class CounselorServiceImpl implements CounselorService {

    final CounselorDAO counselorDAO;
    @Override
    public void joinCounselor(CounselorDTO counselorDTO) {
        counselorDAO.saveCounselor(counselorDTO);
    }
}
