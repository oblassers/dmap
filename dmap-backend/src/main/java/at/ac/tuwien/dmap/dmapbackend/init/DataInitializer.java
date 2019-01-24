package at.ac.tuwien.dmap.dmapbackend.init;

import at.ac.tuwien.dmap.dmapbackend.dmp.domain.Dmp;
import at.ac.tuwien.dmap.dmapbackend.dmp.domain.Project;
import at.ac.tuwien.dmap.dmapbackend.dmp.domain.StaffMember;
import at.ac.tuwien.dmap.dmapbackend.dmp.domain.StaffRole;
import at.ac.tuwien.dmap.dmapbackend.dmp.repository.DmpRepository;
import at.ac.tuwien.dmap.dmapbackend.dmp.repository.ProjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.data.repository.init.RepositoriesPopulatedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Component
@Profile("dev")
public class DataInitializer {
    private static final Logger log = LoggerFactory.getLogger(DataInitializer.class);
    private DmpRepository dmpRepository;
    private ProjectRepository projectRepository;

    @Autowired
    public DataInitializer(DmpRepository dmpRepository, ProjectRepository projectRepository) {
        this.dmpRepository = dmpRepository;
        this.projectRepository = projectRepository;
    }

    @EventListener({RepositoriesPopulatedEvent.class})
    public void onRepositoriesPopulated(){
        initDmps();
    }

    private void initDmps(){
        Dmp dmp = new Dmp();
        dmp.setId("123");
        dmp.setCreated(LocalDateTime.now().minusHours(2));
        dmp.setLastUpdate(LocalDateTime.now());

        StaffMember member = new StaffMember();
        member.setFirstName("Gordon");
        member.setLastName("Flash");
        member.setTitle("Mr");
        member.setEmail("gordon@flash.com");
        member.setRole(StaffRole.OTHER);

        dmp.setContactPerson(member);

        Project project = new Project();
        project.setTitle("Test Project");
        project.setDescription("This is some random abstract..");
        project.setProjectStart(LocalDate.now().minusDays(7));
        project.setProjectEnd(LocalDate.now().plusDays(7));

        dmp.setResearchProjects(new LinkedList<>(Arrays.asList(project)));

        projectRepository.save(project);
        dmpRepository.save(dmp);
    }
}
