import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HelloWorldTest {
//    final List<String> fruits = Arrays.asList("apple","banana","orange");
//
//    @DisplayName("水果模板测试")
//    @TestTemplate
//    @ExtendWith(MyTestTemplate.class)
//    void test(String fruit){
////        assertTrue()
////        fruits.contains()
//        System.out.println(fruit);
//        assertTrue(fruits.contains(fruit));
//    }

    @BeforeEach
    //TestInfo 常规test测试信息,repetitionInfo重复测试常规信息
    void beforeEach(TestInfo testInfo,RepetitionInfo repetitionInfo){
        //当前重复次数
        int currentRepetition = repetitionInfo.getCurrentRepetition();
        //总重复次数
        int totalRepetitions = repetitionInfo.getTotalRepetitions();
        String name = testInfo.getTestMethod().get().getName();
        System.out.println("name"+name);
        System.out.println(String.format("开始测试repetition %d of %d for %s",currentRepetition,totalRepetitions,name));

    }



    @RepeatedTest(5)
    @DisplayName("重复测试")
    void test2(){
        assertEquals(100,100);
    }



}