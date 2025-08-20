package com.example.rebound.dto;

import com.example.rebound.util.MemberCriteria;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Getter
@Setter
@ToString
public class MemberCriteriaDTO {

    private List<MemberDTO> members;
    private MemberCriteria memberCriteria;


}
