package br.com.pub.Repository;

import br.com.pub.Model.Publicacao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PubRepository extends MongoRepository<Publicacao, Long> {
	Publicacao findBypubId(long pubId);
}
