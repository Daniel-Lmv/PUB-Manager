package br.com.pub.Repository;

import br.com.pub.Model.User;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PubRepository extends MongoRepository<User, ObjectId> {
	@Query("{'_id' : 'ObjectID(?0)'}")
	Optional<User> findById(ObjectId userId);
}
