package br.com.pub.Controller;

import br.com.pub.Model.Publicacao;
import br.com.pub.Model.User;
import br.com.pub.Service.UserService;
import jakarta.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/pub-manager/v1/pubs")
public class PubController {

    @Autowired
    private UserService service;

    @GetMapping("/{userId}")
    public ResponseEntity<ArrayList<Publicacao>> getAllUserPubs(@PathVariable ObjectId userId)
    {
    	try {	
    		Optional<User> user = service.selecionarPeloId(userId);
		        
		    if (user.isEmpty()) {
		        return ResponseEntity.notFound().build();
		    } else {
		        return ResponseEntity.ok().body(user.get().getListaPubs());
		    }
    	} catch (Exception e) {
    		return ResponseEntity.internalServerError().build();
    	}
    }

    @PostMapping("/{userId}")
    public String postPub(@PathVariable @Valid ObjectId userId, @RequestBody @Valid Publicacao pub)
    {
    	try {
    		return ResponseEntity.ok().body(service.adicionarPub(userId, pub)).toString();
    	} catch (Exception e) {
    		return e.getLocalizedMessage();
    	}
    }

    @PutMapping("/{userId}/{pubId}")
    public ResponseEntity<Publicacao> putPub(@PathVariable @Valid ObjectId userId, @PathVariable ObjectId pubId, @RequestBody @Valid Publicacao publicacao)
    {
        try {
        	Optional<User> user = service.selecionarPeloId(userId);
        	
        	if (user.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
        	
        	Publicacao pub = user.get().getPubById(pubId);
            
            if (pub == null) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok().body(service.alterarPub(userId, pub));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{userId}/{pubId}")
    public ResponseEntity<Publicacao> delPub(@PathVariable @Valid ObjectId userId, @PathVariable ObjectId pubId)
    {
    	try {
    		Optional<User> user = service.selecionarPeloId(userId);
        	
        	if (user.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
        	
        	Publicacao pub = user.get().getPubById(pubId);
            
            if (pub == null) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok().body(user.get().removePub(pubId));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
