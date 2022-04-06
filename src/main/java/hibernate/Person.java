package hibernate;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY )
public class Person {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
   Integer number;
   String name;

    public Person(Integer id, Integer number, String name) {
        this.id = id;
        this.number = number;
        this.name = name;
    }

    public Person(Integer number, String name) {
        this.number = number;
        this.name = name;
    }

    public Person() {

    }
}
