package br.com.heitorflorido.interview.model;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;
import java.util.Date;

@Value
@Builder(toBuilder = true)
public class Usuario {

    Long id;
    String nome;
    String cidade;
    String uf;
    LocalDate dataNascimento;
    String cep;
}
