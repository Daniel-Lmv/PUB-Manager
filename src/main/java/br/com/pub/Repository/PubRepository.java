package br.com.pub.Repository;

import br.com.pub.Model.User;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PubRepository extends MongoRepository<User, ObjectId> {
	
}
