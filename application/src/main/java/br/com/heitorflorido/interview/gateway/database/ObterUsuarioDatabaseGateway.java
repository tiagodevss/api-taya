package br.com.heitorflorido.interview.gateway.database;

import br.com.heitorflorido.interview.gateway.ObterUsuarioGateway;
import br.com.heitorflorido.interview.gateway.database.model.UsuarioData;
import br.com.heitorflorido.interview.gateway.database.repository.UsuarioRepository;
import br.com.heitorflorido.interview.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class ObterUsuarioDatabaseGateway implements ObterUsuarioGateway {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Mono<Usuario> getUsuario(long id) {
        return usuarioRepository.findById(id)
            .map(UsuarioData::toUsuario);
    }

    /**
     * Author Tiago
     */
    @Override
    public Flux<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll()
            .map(UsuarioData::toUsuario);
    }

    /**
     * Author Tiago
     */
    @Override
    public Mono<Void> deleteUser(long id) {
        return usuarioRepository.deleteById(id);
    }

    /**
     * Author Tiago
     */
    @Override
    public Mono<Usuario> saveUser(Usuario usuario) {
        return usuarioRepository.save(UsuarioData.toUsuarioData(usuario))
            .map(UsuarioData::toUsuario);
    }
}
