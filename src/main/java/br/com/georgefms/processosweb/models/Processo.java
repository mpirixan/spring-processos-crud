package br.com.georgefms.processosweb.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Processo {
    @Id
    @Column(name = "id", nullable = false)
    private Long numero;
    @Column(name = "data_criacao", nullable = false)
    private java.sql.Date data;
    @Column(nullable = false)
    private BigDecimal valorRecurso;
    @Column(nullable = false)
    private String objetivo;

    public Processo(){}

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public java.sql.Date getData() {
        return data;
    }

    public void setData(java.sql.Date data) {
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
        return "Processos{" +
                "numero=" + numero +
                ", data=" + data +
                ", valorRecurso=" + valorRecurso +
                ", objetivo='" + objetivo + '\'' +
                '}';
    }
}
