import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class TestMethodSource {
    //源为MethodSource
    @ParameterizedTest
    @MethodSource("stringStream")
    void test(String str){
        assertNotNull(str);
    }
    //必须为静态方法  字符串作为方法提供者
    static Stream<String> stringStream(){
        return Stream.of("aaa","bbb");
    }

    //必须是静态方法 之 流作为方法提供者(IntStream,DoubleStream,LongStream)
    @ParameterizedTest
    @MethodSource("range")
    void test2(int argument){
        assertNotEquals(9,argument);
    }
    static IntStream range(){
        return IntStream.range(0,20).skip(10);
    }

    //测试方法有多个参数时

    @ParameterizedTest
    @MethodSource("stringIntAndListProvider")
    void test3(String str, Integer num, List<String> list){
        assertEquals(3,str.length());
        assertTrue(num<5);
        assertEquals(3,list.size());

    }
    static Stream<Arguments> stringIntAndListProvider()
    {
        return Stream.of(Arguments.of("aaa",2, Arrays.asList("x","y","z")),
                Arguments.of("bbb",3,Arrays.asList("a","b","c")));
    }

    //参数测试 外部静态工厂方法  完整包名.类名#方法名
    @ParameterizedTest
    @MethodSource("example.StringProviders#tinyString")
    void test4(String tinyString){
        assertTrue(tinyString.length()<5);
    }



}
