package com.example.rebound.mapper;

import com.example.rebound.domain.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MemberMapperTests {
    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void insertMemberTest(){
        MemberVO member=MemberVO.builder().memberName("테스트")
                .memberEmail("test@gmail.com")
                .memberPassword("123456")
                .memberPhoneNumber(01012345678L)
                .build();

        memberMapper.insertMember(member);
    }
}