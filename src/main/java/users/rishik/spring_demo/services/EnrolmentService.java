package users.rishik.spring_demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import users.rishik.spring_demo.entities.Enrolment;
import users.rishik.spring_demo.exceptions.InvalidDateException;
import users.rishik.spring_demo.exceptions.MaxCapacityException;
import users.rishik.spring_demo.exceptions.NotFoundException;
import users.rishik.spring_demo.respositories.EnrolmentRepository;

@Service
public class EnrolmentService {
    private final EnrolmentRepository enrolmentRepository;

    @Autowired
    public EnrolmentService(EnrolmentRepository enrolmentRepository){
        this.enrolmentRepository = enrolmentRepository;
    }

    public Enrolment addEnrolment(Enrolment enrolment){
        if (enrolment.getEnrolmentDate().isAfter(enrolment.getCourse().getStartDate())){
            throw new InvalidDateException("Invalid Enrollment date");
        }
        if (this.enrolmentRepository.countByCourse(enrolment.getCourse()) + 1 >= enrolment.getCourse().getCapacity()){
            throw new MaxCapacityException("No seats available in this course");
        }
        return this.enrolmentRepository.save(enrolment);
    }

    public Enrolment getEnrolment(long enrolmentId){
        return this.enrolmentRepository.findById(enrolmentId).orElseThrow(()-> new NotFoundException("Enrolment with id: " + enrolmentId + " not found"));
    }

    public void deleteEnrolment(long enrolmentId){
        this.enrolmentRepository.deleteById(enrolmentId);
    }
}
