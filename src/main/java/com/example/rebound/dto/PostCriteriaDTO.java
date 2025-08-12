package com.example.rebound.dto;

import com.example.rebound.util.PostCriteria;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@Setter
@ToString
public class PostCriteriaDTO {
    private List<PostDTO> posts;
    private PostCriteria postCriteria;
}
