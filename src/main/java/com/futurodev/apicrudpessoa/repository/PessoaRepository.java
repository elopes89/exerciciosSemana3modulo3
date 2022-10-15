package com.futurodev.apicrudpessoa.repository;

import com.futurodev.apicrudpessoa.model.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface PessoaRepository extends JpaRepository<PessoaModel, Long> {
    @Query(value = "select c from PessoaModel  c where c.nome like %?1% ")
    ArrayList<PessoaModel> getPessoaModelByName(String nome);

}