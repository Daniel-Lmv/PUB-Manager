package br.com.pub.Controller;

import br.com.pub.Model.Publicacao;
import br.com.pub.Service.PubService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pub-manager/v1/pubs")
public class PubController {

    @Autowired
    private PubService service;
    
    @GetMapping()
    public ResponseEntity<List<Publicacao>> getPubs() {
    	return ResponseEntity.ok().body(service.retornarPubs());
    }

    @GetMapping("/{pubId}")
    public ResponseEntity<Publicacao> getPub(@PathVariable @Valid long pubId) {
    	Publicacao pub = service.retornarPub(pubId);
    	
    	if (pub.equals(null)) {
    		return ResponseEntity.notFound().build();
    	}
    	
    	return ResponseEntity.ok().body(pub);
    }
    
    @GetMapping("/user/{user}")
    public ResponseEntity<List<Publicacao>> getPubsFromUser(@PathVariable @Valid String user) {
    	return ResponseEntity.ok().body(service.retornarPubsDoUsuario(user));
    }

    @PostMapping()
    public ResponseEntity<Long> postPub(@RequestBody @Valid Publicacao pub) {
    	long id = service.adicionarPub(pub);
    	return ResponseEntity.created(null).body(id);
    }

    @PutMapping("/{pubId}")
    public ResponseEntity<Publicacao> putPub(@PathVariable @Valid long pubId, @RequestBody @Valid Publicacao publicacao) {
    	if (service.retornarPub(pubId).equals(null)) {
    		return ResponseEntity.notFound().build();
    	}
    	
        service.alterarPub(pubId, publicacao);
        return ResponseEntity.ok().body(null);
    }

    @DeleteMapping("/{pubId}")
    public ResponseEntity<Publicacao> delPub(@PathVariable @Valid long pubId) {
    	Publicacao pub = service.retornarPub(pubId);
    	
    	if (pub.equals(null)) {
    		return ResponseEntity.notFound().build();
    	}
    	
        service.deletarPub(pubId);
        return ResponseEntity.ok().body(null);
    }
}
