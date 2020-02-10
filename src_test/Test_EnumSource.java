import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.EnumSet;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class Test_EnumSource {

    @ParameterizedTest
    @EnumSource(TimeUnit.class)
    void test(TimeUnit timeUnit) {
        System.out.println(timeUnit + " -- " + String.valueOf(timeUnit.ordinal()));
        System.out.println("xxx");
        assertNotNull(timeUnit);
    }

    //names 取值范围
    @ParameterizedTest
    @EnumSource(value = TimeUnit.class,names={"DAYS","HOURS"})
    void test2(TimeUnit timeUnit){

        assertTrue(EnumSet.of(TimeUnit.DAYS,TimeUnit.HOURS).contains(timeUnit));
    }

    //mode:测模式 EXCLUDE :排除
    @ParameterizedTest
    @EnumSource(value = TimeUnit.class,names={"DAYS","HOURS"},mode= EnumSource.Mode.EXCLUDE)
    void test3(TimeUnit timeUnit){
        assertFalse(EnumSet.of(TimeUnit.DAYS,TimeUnit.HOURS).contains(timeUnit));
        assertTrue(timeUnit.name().length()>5);
    }

    //mode MATCH_ALL 全部匹配,names为正则表达式
    @ParameterizedTest
    @EnumSource(value = TimeUnit.class,names="(M|N).+SECONDS",mode = EnumSource.Mode.MATCH_ALL)
    void test4(TimeUnit timeUnit){
        String names = timeUnit.name();
        assertTrue(names.startsWith("M") || names.startsWith("N"));
        assertTrue(names.endsWith("SECONDS"));
    }
}
