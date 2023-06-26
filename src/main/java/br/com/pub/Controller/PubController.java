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
    public List<Publicacao> getPubs()
    {
    	return service.retornarPubs();
    }

    @GetMapping("/{pubId}")
    public ResponseEntity<Publicacao> getPub(@PathVariable @Valid long pubId)
    {
    	Publicacao pub = service.retornarPub(pubId);
    	
    	if (pub.equals(null)) {
    		return ResponseEntity.notFound().build();
    	}
    	
    	return ResponseEntity.ok().body(pub);
    }

    @PostMapping()
    public ResponseEntity<Publicacao> postPub(@RequestBody @Valid Publicacao pub)
    {
    	service.adicionarPub(pub);
    	
    	return ResponseEntity.created(null).body(pub);
    }

    @PutMapping()
    public ResponseEntity<Publicacao> putPub(@RequestBody @Valid Publicacao publicacao)
    {
    	Publicacao pub = service.retornarPub(publicacao.getPubId());
    	
    	if (pub.equals(null)) {
    		return ResponseEntity.notFound().build();
    	}
    	
        service.alterarPub(publicacao);
        return ResponseEntity.ok().body(pub);
    }

    @DeleteMapping("/{pubId}")
    public ResponseEntity<Publicacao> delPub(@PathVariable long pubId)
    {
    	Publicacao pub = service.retornarPub(pubId);
    	
    	if (pub.equals(null)) {
    		return ResponseEntity.notFound().build();
    	}
    	
        service.deletarPub(pubId);
        return ResponseEntity.ok().body(null);
    }
}
