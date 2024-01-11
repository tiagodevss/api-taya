package br.com.heitorflorido.interview.entrypoint.rest.model;

import br.com.heitorflorido.interview.model.Usuario;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;


@Data
@Builder(toBuilder = true)
public class UsuarioResponse {

    private Long id;
    private String nome;
    private String cidade;
    private String uf;
    private LocalDate dataNascimento;
    private String cep;

    public static UsuarioResponse toUsuarioResponse(final Usuario usuario) {

        return UsuarioResponse.builder()
            .id(usuario.getId())
            .nome(usuario.getNome())
            .cidade(usuario.getCidade())
            .uf(usuario.getUf())
            .dataNascimento(usuario.getDataNascimento())
            .cep(usuario.getCep())
            .build();
    }
}
