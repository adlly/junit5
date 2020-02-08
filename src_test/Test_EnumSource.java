import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.EnumSet;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Test_EnumSource {

    @ParameterizedTest
    @EnumSource(TimeUnit.class)
    void test(TimeUnit timeUnit) {
        System.out.println(timeUnit + " -- " + String.valueOf(timeUnit.ordinal()));
        System.out.println("xxx");
        assertNotNull(timeUnit);
    }

    @ParameterizedTest
    @EnumSource(value = TimeUnit.class,names={"DAYS","HOURS"})
    void test2(TimeUnit timeUnit){

        assertTrue(EnumSet.of(TimeUnit.DAYS,TimeUnit.HOURS).contains(timeUnit));
    }
}
