package API.reflect;

public class Entity {
    String name;
    Integer age;


    public Entity(){
        System.out.println("running===entity constructor");
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
