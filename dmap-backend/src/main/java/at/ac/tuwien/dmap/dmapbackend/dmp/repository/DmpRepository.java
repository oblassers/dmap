package at.ac.tuwien.dmap.dmapbackend.dmp.repository;

import at.ac.tuwien.dmap.dmapbackend.dmp.domain.Dmp;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface DmpRepository extends MongoRepository<Dmp, BigInteger> {
}
