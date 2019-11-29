package API.reflect;

public class SubEntity extends Entity {
    private String address;
    private String habit;

    @Override
    public String toString() {
        return "SubEntity{" +
                "address='" + address + '\'' +
                ", habit='" + habit + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHabit() {
        return habit;
    }

    public void setHabit(String habit) {
        this.habit = habit;
    }
}
