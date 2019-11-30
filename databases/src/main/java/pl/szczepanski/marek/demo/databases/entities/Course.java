package pl.szczepanski.marek.demo.databases.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "course_table")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nazwa_kursu", nullable = false)
    private String name;

    @Column(name = "start_day")
    private LocalDate startDate;

    @Transient
    private String comment;
    //private String comment; nie chcemy czegoś zapisać do bazy. Będzie tylko w runtime/ w pamięci.
    //mappedBy - by powiazać pola, refactor powinien też zmienić to pole.
    //Trzeba zainicjalizować
    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    private Set<Student> studentSet = new HashSet<>();

    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<Student> studentSet) {
        this.studentSet = studentSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}
