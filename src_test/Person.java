import java.time.LocalDate;

public class Person {
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate  localDate;
    public Person(String firstName,String lastName,Gender gender,LocalDate localDate){
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.localDate = localDate;
    }
}
