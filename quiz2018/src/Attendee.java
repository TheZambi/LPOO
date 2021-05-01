public class Attendee implements Person, Comparable,User{
    String name;
    int age = 0;
    Boolean paied = false;

    public Attendee(String name) {
        this.name = name;
    }

    public Attendee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Boolean hasPaid() {
        return paied;
    }

    @Override
    public String toString() {
        return "Attendee " + this.getName() + (this.hasPaid() ? " has" : " hasn't") + " paid its registration.";
    }

    @Override
    public int compareTo(Object o) {
        return this.getName().compareTo(((Person) o).getName());

    }

    @Override
    public String getUsername() {
        return this.name + this.age;
    }
}
