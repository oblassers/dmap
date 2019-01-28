package at.ac.tuwien.dmap.dmapbackend.dmp.repository;

import at.ac.tuwien.dmap.dmapbackend.dmp.domain.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {
}
