package com.example.rebound.mapper;

import com.example.rebound.dto.PostDTO;
import com.example.rebound.util.PostCriteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CommunityListMapper {

    //    추가
    public void insertCommunityPost(PostDTO postDTO);

    //    조회
    public Optional<PostDTO> selectCommunityPostWriter(Long id);

    //    조회수 증가
    public void updatePostReadCount(Long id);

    //    목록
    public List<PostDTO> selectAll(PostCriteria postCriteria);

    //    전체 개수
    public int selectCountAll();

}
