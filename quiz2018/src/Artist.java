public class Artist implements Person,User {
    String name;
    int age = 0;

    public Artist(String name) {
        this.name = name;
    }

    public Artist(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getUsername() {
        return this.name + this.age;
    }
}
