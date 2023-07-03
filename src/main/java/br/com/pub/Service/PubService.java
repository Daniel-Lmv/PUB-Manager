package br.com.pub.Service;

import java.util.List;
import java.time.Instant;

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

	public long adicionarPub(Publicacao novaPublicacao){
		long id = 0;
		
		while (repo.existsById(id)) {
			id++;
		}
		
		novaPublicacao.setPubId(id);
		novaPublicacao.setPublishedAt(Instant.now());
		
	    repo.insert(novaPublicacao);
	    
	    return id;
	}

	public void alterarPub(long pubId, Publicacao pubAlterada){
	    Publicacao pub = retornarPub(pubId);
	    deletarPub(pubId);
	    
	    if (!pub.equals(null)) {
	    	pub.setUser(pubAlterada.getUser());
	    	pub.setText(pubAlterada.getText());
	    	pub.setSummary(pubAlterada.getSummary());
	    	repo.insert(pub);
	    }
	}

	public void deletarPub(long pubId){
		Publicacao pub = retornarPub(pubId);
	    
		if (!pub.equals(null)) {
	        repo.delete(pub);
	    }
	}

}
