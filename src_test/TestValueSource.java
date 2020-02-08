import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestValueSource {
    @ParameterizedTest
    @ValueSource(strings = {"a","b","c"})
    @DisplayName("参数化测试")
    void test(String str){
        assertFalse(str.isEmpty());

    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4})
    void test2(int num){
        assertTrue(num<5);
    }
}
