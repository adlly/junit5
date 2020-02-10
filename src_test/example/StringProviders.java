package example;

import java.util.stream.Stream;

public class StringProviders {
    public static Stream<String>  tinyString(){
        return Stream.of(".","oo","0000");
    }
}
