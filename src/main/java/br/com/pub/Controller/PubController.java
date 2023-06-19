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
    UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<ArrayList<Publicacao>> getAllUserPubs(@PathVariable @Valid String userId)
    {
        Optional<User> user = userService.selecionarPeloId(userId);
        if(user.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            ArrayList<Publicacao> lista = new ArrayList<>();
            User userLocal = user.get();
            lista = userLocal.getListaPubs();
            return ResponseEntity.ok().body(lista);
        }
    }

    @GetMapping("/x")
    public void getOpen()
    {

    }

    @PostMapping("/{userId}")
    public ResponseEntity<Publicacao> postPub(@PathVariable @Valid String userId, @RequestBody @Valid Publicacao pub)
    {
        Publicacao publicacao = null;
        Optional<User> user = userService.selecionarPeloId(userId);
        if(user.isEmpty()){
            userService.inserirNoBanco(new User(userId));
        }

        try{
            publicacao = userService.adicionarPub(userId, pub);
            return ResponseEntity.created(null).body(publicacao);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{userId}/{pubId}")
    public ResponseEntity<Publicacao> putPub(@PathVariable @Valid String userId, @PathVariable String pubId, @RequestBody @Valid Publicacao publicacao)
    {
        try{
            Publicacao pub = userService.alterarPub(userId, pubId, publicacao);
            if(pub != null){
                return ResponseEntity.ok().body(pub);
            }else {
                return ResponseEntity.badRequest().build();
            }
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{userId}/{pubId}")
    public ResponseEntity<Publicacao> delPub(@PathVariable @Valid String userId, @PathVariable String pubId)
    {
        try{
            Publicacao pub = userService.deletarPub(userId, pubId);
            if(pub != null){
                return ResponseEntity.ok().body(pub);
            }else {
                return ResponseEntity.badRequest().build();
            }
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
