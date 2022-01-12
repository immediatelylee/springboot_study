package objectmapper.objectmapper;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    private String name;
    private int age;


    @JsonProperty("phone_number") // (1) JsonProperty추가
    private String phoneNumber;

    public User(){
        this.name = null;
        this.age = 0;
        this.phoneNumber = null; //(2-1) 디폴트 생성자에 phoneNumber추가
    }

    public User(String name,int age,String phoneNumber){
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;  // (2-2) 생성자에 phoneNumber추가

    }

    public String getPhoneNumber() { //(3) phoneNumber getter추가
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // (4) toString 업데이트
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
