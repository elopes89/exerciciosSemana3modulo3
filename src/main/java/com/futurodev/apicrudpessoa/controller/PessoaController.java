package com.futurodev.apicrudpessoa.controller;

import com.futurodev.apicrudpessoa.model.PessoaModel;
import com.futurodev.apicrudpessoa.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<PessoaModel> cadastrar(@RequestBody PessoaModel pessoaModel) {
        PessoaModel pes = pessoaRepository.save(pessoaModel);
        return new ResponseEntity<PessoaModel>(pes, HttpStatus.CREATED);
    }

    @PutMapping(value = "/", produces = "application/json")
    public ResponseEntity<PessoaModel> atualizar(@RequestBody PessoaModel pm) {
        PessoaModel pes =  pessoaRepository.save(pm);
        return new ResponseEntity<PessoaModel>(pes, HttpStatus.OK);
    }

    @DeleteMapping(value = "/")
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Long idPessoa) {
        pessoaRepository.deleteById(idPessoa);
        return new ResponseEntity<String>("Pessoa deletada com êxito", HttpStatus.OK);
    }

    @GetMapping(value = "/{idPessoa}")
    public ResponseEntity<PessoaModel>  getContatoById(@PathVariable(value = "idPessoa") Long idPessoa) {
        PessoaModel pes = pessoaRepository.findById(idPessoa).get();
        return new ResponseEntity<PessoaModel>(pes, HttpStatus.OK);
    }

    @GetMapping(value = "/" , produces = "application/json")
    public ResponseEntity<List<PessoaModel>> getContatoModelById(@RequestParam (name = "nome") String nome){
        List<PessoaModel> pessoas =  pessoaRepository.getPessoaModelByName(nome);
        return new ResponseEntity<List<PessoaModel>>(pessoas, HttpStatus.OK);
    }

}