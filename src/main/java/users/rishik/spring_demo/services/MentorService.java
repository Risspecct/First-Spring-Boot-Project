package users.rishik.spring_demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import users.rishik.spring_demo.entities.Mentor;
import users.rishik.spring_demo.exceptions.NotFoundException;
import users.rishik.spring_demo.respositories.Mentorrepository;

import java.util.Optional;

@Service
public class MentorService {
    private final Mentorrepository mentorRepository;

    @Autowired
    public MentorService(Mentorrepository mentorRepository){
        this.mentorRepository = mentorRepository;
    }

    public Mentor addMentor(Mentor mentor){
        return this.mentorRepository.save(mentor);
    }

    public Mentor getMentorById(long mentorId){
        Optional<Mentor> mentor = this.mentorRepository.findById(mentorId);
        return mentor.orElseThrow(() -> {
            return new NotFoundException("Couln'd find mentor with id: " + mentorId);
        });
    }

    public Mentor updateMentor(long mentorId, Mentor mentor){
        Mentor existingMentor = this.getMentorById(mentorId);
        existingMentor.setFirstName(mentor.getFirstName());
        existingMentor.setLastName(mentor.getLastName());
        existingMentor.setCompany(mentor.getCompany());
        existingMentor.setYearsOfExperience(mentor.getYearsOfExperience());
        existingMentor.setId(mentor.getId());
        return mentorRepository.save(existingMentor);
    }

    public void deleteMentorById(long mentorId){
        mentorRepository.deleteById(mentorId);
    }
}
