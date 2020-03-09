import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

public class Tesst_Aggregation_Defined {


    @ParameterizedTest
    @CsvSource({
            "Jane,Deo,F,1992-10-19",
            "Joe,Deo,M,1991-10-19"
    })
    void test(@AggregateWith(PersonAggregator.class) Person person){

    }
}
public class PersonAggregator implements ArgumentsAggregator{

    @Override
    public Object aggregateArguments(ArgumentsAccessor argumentsAccessor, ParameterContext parameterContext) throws ArgumentsAggregationException {
        return new Person(
                argumentsAccessor.getString(0),
                argumentsAccessor.getString(1),
                argumentsAccessor.get(2,Gender.class),
                argumentsAccessor.get(3, LocalDate.class));
    }
}
