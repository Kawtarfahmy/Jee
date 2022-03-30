package com.emsi.hospital;

import com.emsi.hospital.entities.*;
import com.emsi.hospital.repositories.ConsultationRepository;
import com.emsi.hospital.repositories.MedecinRepository;
import com.emsi.hospital.repositories.PatientRepository;
import com.emsi.hospital.repositories.RendezVousRepository;
import com.emsi.hospital.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.lang.invoke.ConstantCallSite;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

	public static void main(String[] args) {

		SpringApplication.run(HospitalApplication.class, args);
	}
    @Bean
	CommandLineRunner start(IHospitalService hospitalService, PatientRepository patientRepository,
							RendezVousRepository rendezVousRepository, MedecinRepository medecinRepository){
		return args -> {
			Stream.of("Wiam","Kawtar","Hamza")
					.forEach(name -> {
						Patient patient = new Patient();
						patient.setNom(name);
						patient.setDateNaissance(new Date());
						patient.setMalade(false);
						hospitalService.savePatient(patient);
					});
			Stream.of("Ahmed","Asmae","Mohamed")
					.forEach(name -> {
						Medecin medecin = new Medecin();
						medecin.setNom(name);
						medecin.setEmail(name+"@gmail.com");
						medecin.setSpecialite(Math.random()>0.5?"Cardio":"Neuro");
						hospitalService.saveMedecin(medecin);
					});
			Patient patient = patientRepository.findById(1L).orElse(null);
			Patient patient1 = patientRepository.findByNom("Kawtar");

			Medecin medecin = medecinRepository.findByNom("Asmae");

			RendezVous rendezVous = new RendezVous();
			rendezVous.setDate(new Date());
			rendezVous.setStatus(StatusRDV.PENDING);
			rendezVous.setMedecin(medecin);
			rendezVous.setPatient(patient);
			RendezVous savedRDV = hospitalService.saveRDV(rendezVous);
			System.out.println(savedRDV.getId());

			RendezVous rendezVous1 = rendezVousRepository.findAll().get(0);
			Consultation consultation = new Consultation();
			consultation.setDateConsultation(new Date());
			consultation.setRendezVous(rendezVous1);
			consultation.setRapport("Rapport de la consultation ...");
			hospitalService.saveConsultation(consultation);


		};
	}
}
