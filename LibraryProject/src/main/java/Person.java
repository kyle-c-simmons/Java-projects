public class Person {

    private String name;
    private int age;
    private String job_title;

    public Person(String name, int age, String job_title) {
        this.name = name;
        this.age = age;
        this.job_title = job_title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }
}
