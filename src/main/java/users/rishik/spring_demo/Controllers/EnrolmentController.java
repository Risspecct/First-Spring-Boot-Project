package users.rishik.spring_demo.Controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import users.rishik.spring_demo.dto.EnrolmentDto;
import users.rishik.spring_demo.dto.StatusUpdateDo;
import users.rishik.spring_demo.entities.Enrolment;
import users.rishik.spring_demo.enums.EnrolmentStatus;
import users.rishik.spring_demo.exceptions.NotFoundException;
import users.rishik.spring_demo.mappers.EnrolmentMapper;
import users.rishik.spring_demo.projections.EnrolmentView;
import users.rishik.spring_demo.services.EnrolmentService;

import java.util.ArrayList;
import java.util.List;
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
    public ResponseEntity<?> addEnrolment(@RequestBody @Valid EnrolmentDto dto){
        try {
            Enrolment enrolment = this.enrolmentMapper.mapToModel(dto);
            return new ResponseEntity<>(this.enrolmentService.addEnrolment(enrolment), HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping("/addAll")
    public ResponseEntity<?> addAllEnrolment(@RequestBody @Valid List<@Valid EnrolmentDto> dtos){
        List<Enrolment> enrolments = new ArrayList<>(dtos.size());
        try {
            for(EnrolmentDto dto: dtos)
                enrolments.add(this.enrolmentMapper.mapToModel(dto));
            return new ResponseEntity<>(this.enrolmentService.addAllEnrolments(enrolments), HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/find/{enrolmentId}")
    public ResponseEntity<?> getEnrolment(@PathVariable long enrolmentId) {
        try {
            return ResponseEntity.ok(this.enrolmentService.getEnrolment(enrolmentId));
        } catch (NotFoundException e) {
            return new ResponseEntity<>(Map.of("Error", e.getMessage()), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/findByCourse/{courseId}")
    public ResponseEntity<?> getEnrolmentsByCourse(@PathVariable long courseId){
        try{
            List<EnrolmentView> enrolments = this.enrolmentService.getEnrolmentsByCourse(courseId);
            if (enrolments.isEmpty()){
                return new ResponseEntity<>(Map.of("Error", "Couldn't find any enrolments with course id: " + courseId), HttpStatus.NOT_FOUND);
            } else return ResponseEntity.ok(enrolments);
        } catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/findByStatus/{status}")
    public ResponseEntity<?> getEnrolmentByStatus(@PathVariable EnrolmentStatus status){
        try {
            List<EnrolmentView> enrolments = this.enrolmentService.findEnrolmentByStatus(status);
            if (enrolments.isEmpty()) return new ResponseEntity<>(Map.of("Error", "No enrolments found with status: " + status), HttpStatus.NOT_FOUND);
            else return ResponseEntity.ok(enrolments);
        } catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/findByStudent/{studentId}")
    public ResponseEntity<?> getEnrolmentByStudent(@PathVariable long studentId){
        try {
            List<EnrolmentView> enrolments = this.enrolmentService.findEnrolmentByStudendId(studentId);
            if (enrolments.isEmpty()) return new ResponseEntity<>(Map.of("Error", "The student has not enrolled in any courses"), HttpStatus.NOT_FOUND);
            else return ResponseEntity.ok(enrolments);
        } catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PutMapping("/update/{enrolmentId}/status")
    public ResponseEntity<?> updateEnrolmentStatus(@PathVariable long enrolmentId, @RequestBody StatusUpdateDo statusDto){
        try {
            return ResponseEntity.ok(this.enrolmentService.updateEnrolmentStatus(enrolmentId, statusDto.getStatus()));
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
