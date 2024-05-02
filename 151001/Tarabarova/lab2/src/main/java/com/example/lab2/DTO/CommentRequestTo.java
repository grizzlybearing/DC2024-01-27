package com.example.lab2.DTO;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CommentRequestTo {
    int id;
    int storyId;
    @Size(min = 2, max = 2048)
    String content;
}
