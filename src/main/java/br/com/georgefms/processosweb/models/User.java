package br.com.georgefms.processosweb.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="email", unique = true)
    private String email;

    @Column(name="usuario",unique = true)
    private String usuario;

    @Column(name = "senha")
    private String senha;
}
