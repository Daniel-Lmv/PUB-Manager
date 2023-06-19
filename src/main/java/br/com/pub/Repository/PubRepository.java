package br.com.pub.Repository;

import br.com.pub.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PubRepository extends MongoRepository<User, String> {
}
