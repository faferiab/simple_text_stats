package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Statistics;
import com.example.demo.bean.TextData;
import com.example.demo.bl.TextStatistics;
import com.example.demo.bl.TextStatistics2;

@RestController
@RequestMapping("/api/text")
public class TextService {

    @Autowired
    TextStatistics procesor;
    @Autowired
    TextStatistics2 procesor2;
    
    @PostMapping
    public Statistics processText(@RequestBody TextData data) {
        return procesor.processText(data.getText());
    }
    
    @PostMapping("/v2")
    public Statistics processText2(@RequestBody TextData data) {
        return procesor2.processText(data.getText());
    }
    
    @GetMapping
    public String ping() {
        return "ping";
    }
}
