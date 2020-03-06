import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestViewConvert {
    @ParameterizedTest
    @EnumSource(TimeUnit.class)
    void test(@ConvertWith(ToStringArgument.class) String argument){
        assertNotNull(argument);
    }
}

class ToStringArgument extends SimpleArgumentConverter {

    @Override
    protected Object convert(Object o, Class<?> aClass) throws ArgumentConversionException {
        assertEquals(String.class,aClass,"Can only convert To String");
        return String.valueOf(o);
    }
}
