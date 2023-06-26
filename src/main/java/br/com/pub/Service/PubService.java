package br.com.pub.Service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pub.Model.Publicacao;
import br.com.pub.Repository.PubRepository;

@Service
public class PubService {

	@Autowired
	private PubRepository repo;
	
	public List<Publicacao> retornarPubs() {
		return repo.findAll();
	}

	public Publicacao retornarPub(long pubId) {
		Publicacao pub = repo.findBypubId(pubId);
	    return pub;
	}
	
	public List<Publicacao> retornarPubsDoUsuario(String user) {
		return repo.findByuser(user);
	}

	public void adicionarPub(Publicacao novaPublicacao){
	    repo.insert(novaPublicacao);
	}

	public void alterarPub(Publicacao pubAlterada){
	    Publicacao pub = retornarPub(pubAlterada.getPubId());
	    
	    if (!pub.equals(null)) {
	    	BeanUtils.copyProperties(pubAlterada, pub);
	    	repo.save(pub);
	    }
	}

	public void deletarPub(long pubId){
		Publicacao pub = retornarPub(pubId);
	    
		if (!pub.equals(null)) {
	        repo.delete(pub);
	    }
	}

}
