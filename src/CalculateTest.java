import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;

//import static org.hamcrest.Matchers.is;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

@DisplayName("class name")
class CalculateTest {

//    @org.junit.jupiter.api.Test
//    void add() {
//    }
//    @Test
//    void test1(){
//        assertThat(5-2, Matchers.is(Matchers.equalTo(3)));
//        assertThat(4-3,Matchers.is(Matchers.equalTo(2)));
//        assertThat("hardwork",Matchers.endsWith("work"));
//    }

//    @Test
//    void test2(){
//        List<String> s1 = Arrays.asList("a","b","c");
//        List<String>s2 = Arrays.asList("a","b","c");
//        assertLinesMatch(s1,s2);
//    }
    @Test
    @DisplayName("method name1")
    void test3_assumeTrue(){
        assumeTrue("abc".equalsIgnoreCase("ABC"));

    }

    @DisplayName("method name2")
    @Test
    void test4_assumeTrue(){
        assumeTrue("abc".equals("Abc"),"assume failed");
    }

    @Test
    void test5_assumeTrue(){
        assumeTrue("abc".equals("Abc"),()->"assume failed");
    }

    @Test
    void test6_assumeFalse(){
        assumeFalse("abc".equals("Abc"),()->"assume False");
    }

    @Test
    @DisplayName("禁用")
    @Disabled
    void test7_assumingThat(){
        assumingThat("abc".equals("abc"),()->
        {
            assertEquals("abc","Abc");
        });
    }

}