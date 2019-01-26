package at.ac.tuwien.dmap.dmapbackend.init;

import at.ac.tuwien.dmap.dmapbackend.dmp.domain.*;
import at.ac.tuwien.dmap.dmapbackend.dmp.repository.DmpRepository;
import at.ac.tuwien.dmap.dmapbackend.dmp.repository.ProjectRepository;
import at.ac.tuwien.dmap.dmapbackend.dmp.repository.StaffMemberRepository;
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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Helper class to populate the database with test data from constructed objects.
 */
@Component
@Profile("dev")
public class DataInitializer {
    private static final Logger log = LoggerFactory.getLogger(DataInitializer.class);
    private DmpRepository dmpRepository;
    private ProjectRepository projectRepository;
    private StaffMemberRepository staffRepository;

    @Autowired
    public DataInitializer(DmpRepository dmpRepository, ProjectRepository projectRepository,
                           StaffMemberRepository staffRepository) {
        this.dmpRepository = dmpRepository;
        this.projectRepository = projectRepository;
        this.staffRepository = staffRepository;
    }

    @EventListener({RepositoriesPopulatedEvent.class})
    public void onRepositoriesPopulated() {
        // for now test data is inserted directly from json files (testdata/..)
        // the insertion of test data constructed from (complex) objects might be used later.
        // initDmps();
    }

    private void initDmps() {
        Dmp dmp = new Dmp();
        dmp.setId("5c4b38f5d4fdffed683ed690");
        dmp.setCreated(LocalDateTime.now().minusHours(2));
        dmp.setLastUpdate(LocalDateTime.now());

        StaffMember contactPerson = new StaffMember("1", "Gordon", "Flash", "Mr", "gordon@flash.com");
        dmp.setContactPerson(contactPerson);

        StaffMember member1 = new StaffMember("2", "Peter", "Parker", "Mr", "peter@parker.com");
        StaffMember member2 = new StaffMember("3", "Bruce", "Wayne", "Mr", "bruce@wayne.com");
        LinkedList<StaffMember> dataManagementMembers = new LinkedList<>(Arrays.asList(member1, member2));
        dmp.setDataManagementStaff(dataManagementMembers);

        Project project = new Project();
        project.setTitle("Test Project");
        project.setDescription("This is some random abstract..");
        project.setProjectStart(LocalDate.now().minusDays(7));
        project.setProjectEnd(LocalDate.now().plusDays(7));

        Funding funding1 = new Funding();
        funding1.setFunderName("FWF");
        funding1.setFundingType("Grant funds");
        Funding funding2 = new Funding();
        funding2.setFunderName("WWTF");
        funding2.setFundingType("Federal state Vienna");
        project.setFundings(new LinkedList<>(Arrays.asList(funding1, funding2)));

        dmp.setResearchProjects(new LinkedList<>(Arrays.asList(project)));

        staffRepository.save(contactPerson);
        staffRepository.saveAll(dataManagementMembers);
        projectRepository.save(project);
        dmpRepository.save(dmp);
    }
}
