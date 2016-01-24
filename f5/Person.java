package f5;

public class Person {
    private String name;

    public Person() {
        this("Okänd");
    }
  
    public Person(String name) {
        this.name = name;
    }
  
    public void setName(String name) {
        this.name = name;
    }
  
    public String getName() {
        return name;
    }

    public String toString() {
        return ("En person som heter "+name);
    }
}
