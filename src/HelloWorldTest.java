import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HelloWorldTest {
    final List<String> fruits = Arrays.asList("apple","banana","orange");

    @DisplayName("水果模板测试")
    @TestTemplate
    @ExtendWith(MyTestTemplate.class)
    void test(String fruit){
        assertTrue(fruits.contains(fruit));
    }

    @RepeatedTest(5)
    @Test
    @DisplayName("重复测试")
    void test2(){
        assertEquals(100,100);
    }

}