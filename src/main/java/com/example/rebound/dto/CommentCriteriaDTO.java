package com.example.rebound.dto;

import com.example.rebound.util.PostCriteria;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of="id")
public class CommentCriteriaDTO {
    private List<CommentDTO> comments;
    private PostCriteria criteria;
}