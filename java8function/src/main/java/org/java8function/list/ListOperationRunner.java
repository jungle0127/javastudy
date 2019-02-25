package org.java8function.list;

import org.apache.commons.lang.StringUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

//@Component
public class ListOperationRunner implements CommandLineRunner {
    private List<String> processDuplicationUserIds(List<String> validUserIdList){
        List<String> distinctValidUserIdList = validUserIdList.stream().distinct().collect(Collectors.toList());
        if(distinctValidUserIdList.size() < validUserIdList.size()){
            List<String> differenceUserIdSet = this.getDuplicateElements(validUserIdList);
            System.out.println("duplication userIds:" + StringUtils.join(differenceUserIdSet.toArray(),","));
        }
        return distinctValidUserIdList;
    }
    private <E> List<E> getDuplicateElements(List<E> list) {
        return list.stream() // list 对应的 Stream
                .collect(Collectors.toMap(e -> e, e -> 1, (a, b) -> a + b)) // 获得元素出现频率的 Map，键为元素，值为元素出现的次数
                .entrySet().stream() // 所有 entry 对应的 Stream
                .filter(entry -> entry.getValue() > 1) // 过滤出元素出现次数大于 1 的 entry
                .map(entry -> entry.getKey()) // 获得 entry 的键（重复元素）对应的 Stream
                .collect(Collectors.toList());  // 转化为 List
    }
    @Override
    public void run(String... args) throws Exception {
        List<String> validUserIdList = new LinkedList<>();
        validUserIdList.add("1");
        validUserIdList.add("1");
        validUserIdList.add("2");
        validUserIdList.add("3");
        List<String> distinctUserIdList = this.processDuplicationUserIds(validUserIdList);
        System.out.println(StringUtils.join(distinctUserIdList.toArray(),","));
//        System.out.println(String.format("Original data:%s", StringUtils.join(validUserIdList.toArray(),",")));
//
//        List<String> distinctValidUserIdList = validUserIdList.stream().distinct().collect(Collectors.toList());
//        System.out.println(String.format("deduplicate operation done data:%s", StringUtils.join(validUserIdList.toArray(),",")));
//        System.out.println(String.format("distinct data:%s", StringUtils.join(distinctValidUserIdList.toArray(),",")));
//        if(distinctValidUserIdList.size() < validUserIdList.size()){
//            List<String> duplicatedUserIdList = this.getDuplicateElements(validUserIdList);
//            System.out.println(String.format("duplication data:%s",StringUtils.join(duplicatedUserIdList.toArray(),",")));
//            validUserIdList = distinctValidUserIdList;
//            System.out.println(String.format("valid data:%s",StringUtils.join(validUserIdList.toArray(),",")));
//        }

    }
}
