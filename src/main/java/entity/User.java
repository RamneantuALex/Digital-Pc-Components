package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;
@Entity
@Table(name = "")
public class User {
    enum Title {JUNIORSWE, SENIORSWE, CLIENT, MANAGER};

    @Id
    private int id;
    private String nume;
    private String prenume;
    private String email;
    private String parola;
    private Title title;
    public User(){

    }
    public User(String nume, String prenume, String email, String parola) {
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.parola = parola;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", email='" + email + '\'' +
                ", parola='" + parola + '\'' +
                '}';
    }
}
