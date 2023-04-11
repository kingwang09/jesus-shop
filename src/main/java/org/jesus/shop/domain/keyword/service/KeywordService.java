package org.jesus.shop.domain.keyword.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class KeywordService {
    @Value("${test.keywords}")
    private String excludeKeywords;

    public List<String> getExcludeKeywords(){
        if(this.excludeKeywords == null){
            return new ArrayList<>();
        }
        return Arrays.stream(excludeKeywords.split(",")).collect(Collectors.toList());
    }
}
