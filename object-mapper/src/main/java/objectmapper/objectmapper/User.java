package objectmapper.objectmapper;

public class User {
    //(2) User클래스 생성 name,age,toString,생성자
    private String name;
    private int age;

    public User(String name,int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
