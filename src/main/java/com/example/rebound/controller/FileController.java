package com.example.rebound.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/**")
public class FileController {
    @GetMapping("display")
    public byte[] display(String filePath, String fileName) throws IOException {
        return FileCopyUtils.copyToByteArray(new File("C:/reboundFile"+filePath, ""+ fileName));
    }
}
