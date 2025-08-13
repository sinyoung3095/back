package com.example.rebound.mapper;

import com.example.rebound.dto.MemberDTO;
import com.example.rebound.repository.MemberDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class Test {
    @Autowired
    private MemberDAO memberDAO;
    @Autowired
    private MemberDTO memberDTO;

    @org.junit.jupiter.api.Test
    public void testDAO() {
        MemberDTO  memberDTO = new MemberDTO();
        memberDTO.setMemberCommon("admin");
        memberDTO.setMemberName("admin");
        log.info(memberDAO.isExistAdmin(memberDTO).toString());
    }
}
