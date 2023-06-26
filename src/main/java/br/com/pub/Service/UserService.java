package br.com.pub.Service;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pub.Model.Publicacao;
import br.com.pub.Model.User;
import br.com.pub.Repository.PubRepository;

@Service
public class UserService {

	 @Autowired
	 PubRepository pubRepository;

	 public void inserirNoBanco(User user){
	     pubRepository.save(user);
	 }

	public Optional<User> selecionarPeloId(ObjectId userId){
	    return pubRepository.findById(userId);
	}

	public void atualizarUser(ObjectId userId, User novoUser) {
	    Optional<User> user = selecionarPeloId(userId);
	    
	    if(user.isPresent()){
	        User userLocal = user.get();
	        BeanUtils.copyProperties(novoUser, userLocal);
	        pubRepository.save(userLocal);
	    }
	}


	public Publicacao adicionarPub(ObjectId userId, Publicacao novaPublicacao){
	    Optional<User> user = selecionarPeloId(userId);
	    
	    if (user.isEmpty()) {
	    	User newUser = new User(userId);
	    	newUser.addToListaPubs(novaPublicacao);
	    	inserirNoBanco(newUser);
	    } else {
	    	user.get().addToListaPubs(novaPublicacao);
	    	atualizarUser(userId, user.get());
	    }
	    
	    return novaPublicacao;
	}

	public Publicacao alterarPub(ObjectId userId, Publicacao pubAlterada){
	    Optional<User> user = selecionarPeloId(userId);
	    
	    if (user.isEmpty()) {
	        return null;
	    } 

	    user.get().modifyPub(pubAlterada);
	    atualizarUser(userId, user.get());
	    return pubAlterada;
	}

	public Publicacao deletarPub(ObjectId userId, ObjectId pubId){
	    Optional<User> user = selecionarPeloId(userId);
	    
	    if (user.isEmpty()) {
	        return null;
	    }
	    
	    Publicacao pubDeletada = user.get().removePub(pubId);
	    atualizarUser(userId, user.get());
	    return pubDeletada;
	}

}
