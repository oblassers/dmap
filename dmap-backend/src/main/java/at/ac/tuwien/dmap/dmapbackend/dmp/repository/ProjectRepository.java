package at.ac.tuwien.dmap.dmapbackend.dmp.repository;

import at.ac.tuwien.dmap.dmapbackend.dmp.domain.Project;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends MongoRepository<Project, String> {
}
