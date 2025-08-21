package com.example.rebound.mapper;

import com.example.rebound.dto.MemberProfileFileDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberProfileFileMapper {
    public void insertMemberProfileFile(MemberProfileFileDTO memberProfileFileDTO);
}
