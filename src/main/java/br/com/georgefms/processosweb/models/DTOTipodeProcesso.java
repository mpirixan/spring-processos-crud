package br.com.georgefms.processosweb.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//Clase responsável por evitar envios indesejados pelo lado do servidor
//DTO -> DATA TRANSFERING OBJECT
public class DtoTipodeProcesso {
    @NotNull
    @NotBlank
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipodeProcesso toTipoProcesso(){
        TipodeProcesso tipodeProcesso = new TipodeProcesso();
        tipodeProcesso.setNome(this.nome);
        return tipodeProcesso;
    }

    @Override
    public String toString() {
        return "DTOTipodeProcesso{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
