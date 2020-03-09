import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestNameDefined {
    @DisplayName("display name of container")
    @ParameterizedTest(name="{index}==>[{arguments}] first = ''{0}'' second = ''{1}''")
    @CsvSource({"aa,1","c_c,2","'a,a',3"})
    void test(String first,int second){

    }
}
