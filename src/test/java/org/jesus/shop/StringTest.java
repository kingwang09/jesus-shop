package org.jesus.shop;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public class StringTest {

    @Test
    public void constainsTest(){
        String value = "312";
        log.debug("result: {}", value.contains("312"));
    }

    @Test
    public void test(){
        long value = 4122734431000L;
        LocalDateTime testTime1 = LocalDateTime.ofInstant(Instant.ofEpochMilli(value), ZoneId.of("Asia/Seoul"));
        LocalDateTime testTime2 = LocalDateTime.ofInstant(Instant.ofEpochMilli(value), ZoneId.of("UTC"));
        log.debug("result: asia/seoul={}, utc={}", testTime1, testTime2);
    }

    @Test
    public void test2(){
        String value = "2100-08-23T20:00:31.000Z";
        LocalDateTime testTime = LocalDateTime.parse(value);
        log.debug("result: {}", testTime);
    }

    @Test
    public void test3(){
        String value = "애옹";
        Set<String> result = findHashTags(value);
        log.debug("result: {}", result);
    }

    private Set<String> findHashTags(String hashTagsForSearch){
        if(hashTagsForSearch == null){
            return new HashSet<>();
        }
        Set<String> results = new HashSet<>();
        String[] hashTags = hashTagsForSearch.split(" ");
        results.addAll(Arrays.stream(hashTags).filter((v)-> StringUtils.isNotBlank(v)).collect(Collectors.toSet()));
        return results;
    }

    @Test
    public void subListTest(){
        List<Integer> values = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13);
        log.debug("result: {}", values.subList(0, 11));
        log.debug("result: {}", values.subList(0, 11).size());
    }
}
