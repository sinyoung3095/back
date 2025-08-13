package com.example.rebound.mapper;

import com.example.rebound.dto.PostDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class PostMapperTests {
    @Autowired
    private PostMapper postMapper;

//    @Test
//    public void testSelectAll(){
//        postMapper.selectAll().stream().map(PostDTO::toString).forEach(log::info);
//    }

}
