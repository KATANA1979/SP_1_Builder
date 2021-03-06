import java.util.OptionalInt;

public class PersonBuilder {
    private String name;
    private String surname;
    private OptionalInt age;
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0 || age > 140) {
            throw new IllegalArgumentException("Не корректный возраст");
        }

        this.age = OptionalInt.of(age);
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if ((name == null) || (surname == null)) {
            throw new IllegalStateException("Не указаны все обязательные поля");
        }

        Person newPerson;
        if (age.isPresent()) {
            newPerson = new Person(name, surname, age.getAsInt());
        } else {
            newPerson = new Person(name, surname);
        }

        newPerson.setAddress(address);

        return newPerson;
    }
}