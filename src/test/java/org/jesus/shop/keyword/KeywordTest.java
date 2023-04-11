package org.jesus.shop.keyword;

import lombok.extern.slf4j.Slf4j;
import org.jesus.shop.domain.keyword.service.KeywordService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class KeywordTest {

    @Autowired
    private KeywordService keywordService;

    @Test
    public void test(){
        List<String> excludeKeywords = keywordService.getExcludeKeywords();
        log.debug("exclude keywords: {}", excludeKeywords);

        final String value = "효능";
        final String value2 = "test";
        Assertions.assertEquals(true, excludeKeywords.contains(value));
        Assertions.assertEquals(false, excludeKeywords.contains(value2));
    }
}
