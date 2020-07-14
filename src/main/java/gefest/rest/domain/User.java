package gefest.rest.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq_gen")
    @SequenceGenerator(name = "users_seq_gen", sequenceName = "users_id_seq", allocationSize=1)

    private long userId;
    private String userName;
    private int age;

    public User() {    }

    public User(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }
}

