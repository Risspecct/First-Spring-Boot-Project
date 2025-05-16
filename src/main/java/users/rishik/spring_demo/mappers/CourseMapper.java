package users.rishik.spring_demo.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import users.rishik.spring_demo.dto.CourseDto;
import users.rishik.spring_demo.entities.Course;
import users.rishik.spring_demo.entities.Mentor;
import users.rishik.spring_demo.exceptions.NotFoundException;
import users.rishik.spring_demo.respositories.MentorRepository;

@Component
public class CourseMapper {
    private final MentorRepository mentorrepository;

    @Autowired
    public CourseMapper(MentorRepository mentorrepository){
        this.mentorrepository = mentorrepository;
    }

    public Course mapToModel(CourseDto dto){
        Course c = new Course();
        Mentor m = this.mentorrepository.findById(dto.getMentorId()).orElseThrow(() -> {
            return new NotFoundException("Couldn't find mentor with id: " + dto.getMentorId());
        });
        c.setName(dto.getName());
        c.setCapacity(dto.getCapacity());
        c.setMentor(m);
        c.setPrice(dto.getPrice());
        c.setDescription(dto.getDescription());
        c.setNoOfDays(dto.getNoOfDays());
        c.setStartDate(dto.getStartDate());

        return c;
    }
}
