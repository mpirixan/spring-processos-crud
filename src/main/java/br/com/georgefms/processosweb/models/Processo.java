package br.com.georgefms.processosweb.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Processo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    //atributo Tipo de processo
    @Column(nullable = false)
    private Long numero;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(nullable = false)
    private BigDecimal valorRecurso;
    @Column(nullable = false)
    private String objetivo;

    public Processo(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public BigDecimal getValorRecurso() {
        return valorRecurso;
    }

    public void setValorRecurso(BigDecimal valorRecurso) {
        this.valorRecurso = valorRecurso;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    @Override
    public String toString() {
        return "Processo: {" +
                "id=" + id +
                ", numero=" + numero +
                ", data=" + data +
                ", valorRecurso=" + valorRecurso +
                ", objetivo='" + objetivo + '\'' +
                '}';
    }
}
