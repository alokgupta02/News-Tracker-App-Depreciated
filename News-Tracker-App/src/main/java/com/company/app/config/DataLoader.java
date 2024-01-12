package com.company.app.config;

import com.company.app.entity.*;
import com.company.app.repository.NewsRepository;
import com.company.app.repository.ReporterRepository;
import com.company.app.repository.TeamMemberRepository;
import com.company.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReporterRepository reporterRepository;
    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private TeamMemberRepository teamMemberRepository;

    @Override
    public void run(String... args) throws Exception {
        // Creating a dummy Collection of roles
        /*Role role = new Role("ADMIN");
        Collection<Role> dummyRoles = new ArrayList<>();
        dummyRoles.add(role);

        // User
        User adminUser = new User("admin", "admin@gmail.com",
                new BCryptPasswordEncoder().encode("admin"), dummyRoles);
        userRepository.save(adminUser);

        //news reporter
        Reporter defReporter1 = new Reporter(1, "Amit", "Kumar", "8768768765", "amit.kr@gmail.com",
                "HSR Layout", "Male", "Bangalore", "Karnataka");
        Reporter defReporter2 = new Reporter(2, "Raju", "Mohan", "9897394493", "raju@gmail.com",
                "MG road", "Male", "Patna", "Bihar");
        Reporter defReporter3 = new Reporter(3, "Shankar", "Pandey", "94438748944", "shankar" +
                "@gmail" +
                ".com","Arera colony", "Male", "Bhopal", "Madhya Pradesh");
        reporterRepository.save(defReporter1);
        reporterRepository.save(defReporter2);
        reporterRepository.save(defReporter3);

        *//*News defNews = new News(1, "CM_BAITHAK", "AV", "Karnataka", "Bangalore", "High", "Pending",
                null, null, null, null, null);
        newsRepository.save(defNews);*//*

        //team member
        //TeamMember defMember1 = new TeamMember(1,"Vishal","Verma",1);
        TeamMember defMember2 = new TeamMember(2, "Shruti", "Baghel", 1);
        TeamMember defMember3 = new TeamMember(3, "Deepshika", "Dubey", 1);
        TeamMember defMember4 = new TeamMember(4, "Vasundhara", "Prajapati", 2);
        //teamMemberRepository.save(defMember1);
        teamMemberRepository.save(defMember2);
        teamMemberRepository.save(defMember3);
        teamMemberRepository.save(defMember4);*/
    }
}
