package com.example.rebound.dto;

import com.example.rebound.util.MemberCriteria;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@Setter
@ToString
public class NoticeCriteriaDTO {
    List<NoticeDTO> notices;
    MemberCriteria memberCriteria;
}
