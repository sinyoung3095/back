package com.example.rebound.mapper;

import com.example.rebound.domain.MemberVO;
import com.example.rebound.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {
 public MemberDTO selectAdmin(MemberDTO memberDTO );
}
