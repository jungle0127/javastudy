package org.java8function.runner;

import com.sun.xml.internal.ws.policy.spi.PolicyAssertionValidator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

@Component
@Order(2)
public class LambdaStepByStep implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        Integer[] dataList = {1,2,3,4,5};
        this.step1Method(dataList);
        this.step2Method(dataList);
        this.step3Method(dataList);
        this.step4Method(dataList);
        this.step5Method(dataList);
        this.step6Method(dataList);
        this.step7DoubleCall(dataList);
    }

    /**
     * Imperative programming way
     * @param dataArray
     */
    private void step1Method(Integer[] dataArray){
        for(Integer item: dataArray){
            System.out.println(item);
        }
    }

    /**
     * Lambda stream way.
     *
     * Arrays stream 返回了一个流对象，类似于集合或数组；
     * 流对象也是一个对象的集合，它将给予我们遍历处理流内元素的功能。
     * @param dataArray
     */
    private void step2Method(Integer[] dataArray){
        Arrays.stream(dataArray).forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
    }

    /**
     * Deduce ConsumerType
     * @param dataArray
     */
    private void step3Method(Integer[] dataArray){
        Arrays.stream(dataArray).forEach((final Integer data)->{
            System.out.println(data);
        });
    }

    /**
     * Deduce paramter data type
     * @param dataArray
     */
    private void step4Method(Integer[] dataArray){
        Arrays.stream(dataArray).forEach((data)->{
            System.out.println(data);
        });
    }

    /**
     * Omit {}
     * @param dataArray
     */
    private void step5Method(Integer[] dataArray){
        Arrays.stream(dataArray).forEach((data)-> System.out.println(data));
    }

    /**
     * Deduce based on method reference
     * @param dataArray
     */
    private void step6Method(Integer[] dataArray){
        Arrays.stream(dataArray).forEach(System.out::println);
    }

    /**
     * sequence call
     * @param dataArray
     */
    private void step7DoubleCall(Integer[] dataArray){
        Consumer outPrintln = System.out::println;
        Consumer<Integer> errPrintln = System.err::println;
        Arrays.stream(dataArray).forEach(outPrintln.andThen(errPrintln));
    }
}
