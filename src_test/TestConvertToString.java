import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestConvertToString {
    @ParameterizedTest
    @ValueSource(strings="啦啦啦啦啦啦")
    void fallback_convert_test(Book book){
        assertEquals("啦啦啦啦啦啦",book.getTitle());

    }

}
class Book{
    private String title;

    private Book(String title){
        this.title = title;
    }

    //工厂方法

    public static Book fromTitle(String title){
        System.out.println("工厂方法转换");
        return new Book(title);
    }

    public String getTitle(){
        return this.title;
    }

}