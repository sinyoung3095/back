package com.example.rebound.mapper;

import com.example.rebound.dto.PostCriteriaDTO;
import com.example.rebound.dto.PostDTO;
import com.example.rebound.util.PostCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

//    수정
    public void updateCommunityPost(PostDTO postDTO);

//    삭제
    public void deleteCommunityPost(Long id);

//    게시글 조회 수 정렬
    public List<PostDTO> selectAllByViews();
//    keyword로 조회
    public List<PostDTO> selectAllByKeyword(String keyword);
//    keyword로 수 조회
    public int selectCountAllByKeyword(String keyword);

    public int selectCountPostByYear(String year);

    public int selectCountPostByMonth(String month);
}
