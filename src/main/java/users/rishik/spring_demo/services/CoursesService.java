package users.rishik.spring_demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import users.rishik.spring_demo.entities.Course;
import users.rishik.spring_demo.exceptions.NotFoundException;
import users.rishik.spring_demo.respositories.CoursesRepository;

import java.util.Optional;

@Service
public class CoursesService {
    private final CoursesRepository coursesRepository;

    @Autowired
    public CoursesService(CoursesRepository coursesRepository) {
        this.coursesRepository = coursesRepository;
    }

    public Course addCourse(Course course){
        return this.coursesRepository.save(course);
    }

    public Course getcourse(long courseId){
        Optional<Course> course = this.coursesRepository.findById(courseId);
        return course.orElseThrow(() -> new NotFoundException("Course with id: " + courseId + " not found"));
    }

    public void deleteCourse(long courseId){
        this.coursesRepository.deleteById(courseId);
    }

    public Course updateCourse(Course course, long courseId){
        Course course1 = this.getcourse(courseId);
        course1.setId(courseId);
        course1.setName(course.getName());
        course1.setCapacity(course.getCapacity());
        course1.setStartDate(course.getStartDate());
        course1.setPrice(course.getPrice());
        course1.setMentor(course.getMentor());
        course1.setNoOfDays(course.getNoOfDays());
        course1.setDescription(course.getDescription());
        return this.coursesRepository.save(course1);
    }

}
