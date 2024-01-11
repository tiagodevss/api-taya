package br.com.heitorflorido.interview.gateway;

import br.com.heitorflorido.interview.model.Usuario;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ObterUsuarioGateway {
    Mono<Usuario> getUsuario(long id);
    Flux<Usuario> getAllUsuarios();
    Mono<Void> deleteUser(long id);
    Mono<Usuario> saveUser(Usuario usuario);
}
