package br.com.heitorflorido.interview.usecase;


import br.com.heitorflorido.interview.gateway.ObterUsuarioGateway;
import br.com.heitorflorido.interview.model.Usuario;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class ObterUsuarioUseCase {

    private final ObterUsuarioGateway obterUsuarioGateway;

    public Mono<Usuario> getUsuario(long id) {
        return obterUsuarioGateway.getUsuario(id);
    }

    public Flux<Usuario> getAllUsuarios() {
        return obterUsuarioGateway.getAllUsuarios();
    }

    public Mono<Void> deleteUser(long id) {
        return obterUsuarioGateway.deleteUser(id);
    }

    public Mono<Usuario> saveUser(Usuario usuario) {
        return obterUsuarioGateway.saveUser(usuario);
    }
}
