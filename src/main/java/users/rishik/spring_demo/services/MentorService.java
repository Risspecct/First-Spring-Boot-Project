package users.rishik.spring_demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import users.rishik.spring_demo.entities.Mentor;
import users.rishik.spring_demo.exceptions.NotFoundException;
import users.rishik.spring_demo.respositories.MentorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MentorService {
    private final MentorRepository mentorRepository;

    @Autowired
    public MentorService(MentorRepository mentorRepository){
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

    public List<Mentor> addAllMentor(List<Mentor> mentors){
        return this.mentorRepository.saveAll(mentors);
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
