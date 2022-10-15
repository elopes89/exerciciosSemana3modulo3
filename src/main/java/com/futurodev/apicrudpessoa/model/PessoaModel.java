package com.futurodev.apicrudpessoa.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Data
@Entity
@Table(name = "pessoa")

public class PessoaModel {
    //como colocar a hora
    //00:00:00.000-0300
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 120, nullable = false)
    private String nome;

    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @Temporal(TemporalType.TIME)
    @JsonFormat(pattern="hh:mm:ss")
    private Date horaDeNascimento;

   //para o horario no formato


    private  Date horaNascimento;

    private String email;

    private String estado;

    private String cidade;

    private String logradouro;

    private String cep;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PessoaModel that = (PessoaModel) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
