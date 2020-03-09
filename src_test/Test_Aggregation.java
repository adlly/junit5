import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

public class Test_Aggregation {
    @ParameterizedTest
    @CsvSource({
            "Jane,Deo,F,1992-10-19",
            "Joe,Deo,M,1991-10-19"
    })
    void test(ArgumentsAccessor argumentsAccessor){
        String firstName = argumentsAccessor.getString(0);
        String lastName = argumentsAccessor.getString(1);
        Gender gender = argumentsAccessor.get(2,Gender.class);
        LocalDate localDate = argumentsAccessor.get(3,LocalDate.class);


        System.out.printf("first name: %s /n" ,firstName);
        System.out.printf("last name: %s /n", lastName);
        System.out.printf("sex:%s/n",gender.getGender());
        System.out.printf("date:"+localDate);

    }
}
