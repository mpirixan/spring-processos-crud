package br.com.georgefms.processosweb.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

public class DtoProcesso {

    @NotNull
    private Long numero;

    @NotNull
    private java.sql.Date data;
    @NotNull
    @DecimalMin("0.0")
    private BigDecimal valorRecurso;
    @NotBlank
    @NotNull
    private String objetivo;

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

    public Processo toProcesso(){
        Processo Processo = new Processo();
        Processo.setNumero(this.numero);
        Processo.setData(this.data);
        Processo.setObjetivo(this.objetivo);
        Processo.setValorRecurso(this.valorRecurso);
        return Processo;
    }

    public Processo toProcesso(Processo processo){
        processo.setData(this.data);
        processo.setNumero(this.numero);
        processo.setValorRecurso(this.valorRecurso);
        processo.setObjetivo(this.objetivo);
        return processo;
    }

    public void fromProcesso(Processo processo){

        this.numero = processo.getNumero();
        this.data = processo.getData();
        this.valorRecurso = processo.getValorRecurso();
        this.objetivo = processo.getObjetivo();
    }

    @Override
    public String toString() {
        return "DtoProcesso: {" +
                "numero=" + numero +
                ", data=" + data +
                ", valorRecurso=" + valorRecurso +
                ", objetivo='" + objetivo + '\'' +
                '}';
    }
}
