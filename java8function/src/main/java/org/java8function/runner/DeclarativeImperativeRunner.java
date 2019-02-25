package org.java8function.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//@Component
@Order(1)
public class DeclarativeImperativeRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        this.imperativeMethod();
        this.declarativeMethod();
        this.immutableOperationMethod();
    }
    private void imperativeMethod(){
        Integer[] dataList = {1,2,3,4,5};
        for(int index = 0; index< dataList.length;index ++){
            System.out.println(dataList[index]);
        }
    }
    private void declarativeMethod(){
        Integer[] dataList = {1,2,3,4,5};
        Arrays.stream(dataList).forEach(System.out::println);
    }
    private void immutableOperationMethod(){
        Integer[] dataList = {1,2,3,4,5};
        Arrays.stream(dataList).map((x) -> x = x+1).forEach(System.out::println);
        System.out.println();
        Arrays.stream(dataList).forEach(System.out::println);
    }
}
