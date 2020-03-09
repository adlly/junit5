public class Gender {

    public static final Gender Female = new Gender("female");
    public static final Gender Male = new Gender("male");
    private String gender;
    public Gender(String s){
        this.gender = s;
    }

    public String getGender(){
        return this.gender;
    }

    public static Gender parse(String str){
        if(str.equals("F")){
            return Female;
        }else if(str.equals("M")){
            return Male;
        }
        return null;

    }
}
