package org.java8function.runner;

import org.java8function.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
@Order(3)
public class StreamMethodRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        Integer[] dataArray = {1,2,3};
        this.collectMethodList(dataArray);
        this.collectMethodSet(dataArray);
        this.collectMap(new LinkedList<>());
        this.peekMethod(dataArray);
    }
    private void collectMethodList(Integer[] dataArray){
        List<Integer> dataList = Arrays.stream(dataArray).collect(Collectors.toList());
        dataList = Arrays.stream(dataArray).collect(ArrayList::new,ArrayList::add,ArrayList::addAll);
        dataList.stream().forEach(System.out::println);
    }
    private void collectMethodSet(Integer[] dataArray){
        Set<Integer> dataSet = Arrays.stream(dataArray).collect(Collectors.toSet());
        dataSet.stream().forEach(System.out::println);
    }
    private void collectMap(List<User> userList){
        for(int index = 0; index < 10; index++){
            userList.add(new User("PS" + index,index));
        }
        Map<String,User> userMap = userList.stream().collect(Collectors.toMap(u-> u.getName(), u->u));
        userMap.forEach((k,u)->{
            System.out.println(u.toString());
        });
    }
    private void peekMethod(Integer[] dataArray){
        long count = Arrays.stream(dataArray).filter(data->data % 2 == 0)
                .peek(System.out::println).count();
        System.out.println(count);
    }
}
