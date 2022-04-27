package com.emsi.patientsmvc;

import com.emsi.patientsmvc.entities.Patient;
import com.emsi.patientsmvc.repositories.PatientRepository;
import com.emsi.patientsmvc.security.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {

        SpringApplication.run(PatientsMvcApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }

    //@Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(
                    new Patient(null,"kawtar",new Date(),false,112));
            patientRepository.save(
                    new Patient(null,"wiam",new Date(),false,120));
            patientRepository.save(
                    new Patient(null,"yassine",new Date(),true,182));
            patientRepository.save(
                    new Patient(null,"hamza",new Date(),true,140));

            patientRepository.findAll().forEach(patient -> {
                System.out.println(patient.getNom());
            });

        };
    }
    //@Bean
    CommandLineRunner saveUsers(SecurityService securityService){
        return args -> {
            securityService.saveNewUser("walid", "1234","1234" );
            securityService.saveNewUser("mouad","1234","1234");
            securityService.saveNewUser("khalid","1234","1234");

            securityService.saveNewRole("USER","");
            securityService.saveNewRole("ADMIN","");

            securityService.addRoleToUser("walid","USER");
            securityService.addRoleToUser("walid","ADMIN");
            securityService.addRoleToUser("mouad","USER");
            securityService.addRoleToUser("khalid","USER");
        };
    }

}
