package web.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Имя не должно быть пустым")
    @Size(min = 1, max = 50, message = "Имя должно быть от 1 до 50 символов")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я]+$", message = "Имя должно содержать только буквы")
    @Column
    private String name;

    @NotBlank(message = "Фамилия не должна быть пустой")
    @Size(min = 1, max = 50, message = "Фамилия должна быть от 1 до 50 символов")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я]+$", message = "Фамилия должно содержать только буквы")
    @Column
    private String lastName;

    @Column
    @NotNull(message = "Возраст обязателен")
    @Min(value = 1, message = "Возраст не может быть отрицательным или 0")
    @Max(value = 150, message = "Возраст не может превышать 150")
    private Integer age;

    public User(){}

    public User(String name, String lastName, Integer age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
