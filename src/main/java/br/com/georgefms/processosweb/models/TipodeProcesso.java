package br.com.georgefms.processosweb.models;
//Iniciando a criação da entidade TIPO_DE_PROCESSO

import javax.persistence.*;

@Entity(name = "TIPO_DE_PROCESSO")
public class TipodeProcesso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(nullable = false)
    private String Name;

    public TipodeProcesso(){};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "TipodeProcesso: {" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                '}';
    }
}
