package br.com.heitorflorido.interview.entrypoint.rest;

import br.com.heitorflorido.interview.entrypoint.rest.model.UsuarioResponse;
import br.com.heitorflorido.interview.gateway.database.model.UsuarioData;
import br.com.heitorflorido.interview.model.Usuario;
import br.com.heitorflorido.interview.usecase.ObterUsuarioUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private ObterUsuarioUseCase obterUsuarioUseCase;

    @GetMapping("/usuarios")
    public Flux<Usuario> getUsuarios() {
        return obterUsuarioUseCase.getAllUsuarios();
    }

    @GetMapping("/usuario/{id}")
    public Mono<Usuario> getUsuario(final @PathVariable long id) {
        return obterUsuarioUseCase.getUsuario(id);
    }

    @DeleteMapping("/usuario/{id}")
    public Mono<ResponseEntity<Void>> deleteUsuario(final @PathVariable long id){
        return obterUsuarioUseCase.deleteUser(id)
            .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
            .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/usuario")
    public Mono<ResponseEntity<Void>> saveUsuario(@RequestBody Usuario usuario){
        return obterUsuarioUseCase.saveUser(usuario)
            .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
            .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
