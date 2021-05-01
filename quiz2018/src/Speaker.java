public class Speaker implements Person, Comparable, User{
    String name;
    int age = 0;
    int fee = 0;

    public Speaker(String name) {
        this.name = name;
    }

    public Speaker(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int getFee() {
        return fee;
    }

    @Override
    public String toString() {
        return "Speaker " + this.getName() + " has a fee value of " + this.getFee() + ".";
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
