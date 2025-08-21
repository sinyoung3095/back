package com.example.rebound.mapper;


import com.example.rebound.common.enumeration.Mentor;
import com.example.rebound.dto.MemberDTO;
import com.example.rebound.repository.MemberDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class AdminTest {
    @Autowired
    private MemberDAO memberDAO;
    @Autowired
    private MemberDTO memberDTO;

    @org.junit.jupiter.api.Test
    public void testDAO() {
        MemberDTO  memberDTO = new MemberDTO();
        memberDTO.setMemberEmail("rebound@gmail.com");
        memberDTO.setMemberPassword("1234");

    }
    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void insertMemberTest(){
        for (int i=15;i<100;i++) {
            MemberDTO memberDTO = new MemberDTO();
            memberDTO.setMemberName("멘토회원테스트");
            memberDTO.setMemberEmail("test1"+i+"@gmail.com");
            memberDTO.setMemberPassword("123456");
            memberDTO.setMentor("subscribe");
            memberDTO.setMemberPhoneNumber("0101"+i+"234"+i);

            memberMapper.insertMember(memberDTO);
        }
    }
}
