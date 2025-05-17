package users.rishik.spring_demo.Controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import users.rishik.spring_demo.dto.EnrolmentDto;
import users.rishik.spring_demo.entities.Enrolment;
import users.rishik.spring_demo.exceptions.NotFoundException;
import users.rishik.spring_demo.mappers.EnrolmentMapper;
import users.rishik.spring_demo.services.EnrolmentService;

import java.util.Map;

@RestController
@RequestMapping("/enrolment")
public class EnrolmentController {
    private final EnrolmentService enrolmentService;
    private final EnrolmentMapper enrolmentMapper;

    @Autowired
    public EnrolmentController(EnrolmentService enrolmentService, EnrolmentMapper enrolmentMapper){
        this.enrolmentService = enrolmentService;
        this.enrolmentMapper = enrolmentMapper;
    }
    @PostMapping("/add")
    public ResponseEntity<?> addEnrolment(@RequestBody EnrolmentDto dto){
        try {
            Enrolment enrolment = this.enrolmentMapper.mapToModel(dto);
            return new ResponseEntity<>(this.enrolmentService.addEnrolment(enrolment), HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/find/{enrolmentId}")
    public ResponseEntity<?> getEnrolment(@PathVariable long enrolmentId){
        try {
            return ResponseEntity.ok(this.enrolmentService.getEnrolment(enrolmentId));
        } catch (NotFoundException e) {
            return new ResponseEntity<>(Map.of("Error", e.getMessage()), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{enrolmentId}")
    public ResponseEntity<?> deleteEnrolment(@PathVariable long enrolmentId){
        try {
            this.enrolmentService.deleteEnrolment(enrolmentId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
