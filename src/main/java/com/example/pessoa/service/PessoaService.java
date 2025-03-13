package com.example.pessoa.service;

import com.example.pessoa.model.Pessoa;
import com.example.pessoa.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public Pessoa salvarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

    public Pessoa buscarPorId(Long id) {
        return pessoaRepository.findById(id).orElse(null);
    }

    public Pessoa atualizarPessoa(Long id, Pessoa novaPessoa) {
        Pessoa pessoa = pessoaRepository.findById(id).orElse(null);

        if (pessoa == null) {
            throw new RuntimeException("Pessoa não encontrada com id: " + id);
        }

        pessoa.setNome(novaPessoa.getNome());
        pessoa.setEmail(novaPessoa.getEmail());
        pessoa.setIdade(novaPessoa.getIdade());

        return pessoaRepository.save(pessoa);
    }

    public void deletarPessoa(Long id) {
        pessoaRepository.deleteById(id);
    }
}
