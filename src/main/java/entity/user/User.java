package entity.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "")
public class User {
    @Id
    private int id;
    private String nume;
    private String prenume;
    private String email;
    private String parola;

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
        StringBuilder builder = new StringBuilder();
        builder.append("User{")
                .append("id=").append(id)
                .append(", nume='").append(nume).append('\'')
                .append(", prenume='").append(prenume).append('\'')
                .append(", email='").append(email).append('\'')
                .append(", parola='").append(parola).append('\'')
                .append('}');
        return builder.toString();
    }

}
