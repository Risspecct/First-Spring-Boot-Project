package users.rishik.spring_demo.Controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import users.rishik.spring_demo.dto.MentorDto;
import users.rishik.spring_demo.entities.Mentor;
import users.rishik.spring_demo.exceptions.NotFoundException;
import users.rishik.spring_demo.projections.MentorView;
import users.rishik.spring_demo.services.MentorService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/mentor")
public class MentorController {
    private final MentorService mentorService;

    @Autowired
    public MentorController(MentorService mentorService){
        this.mentorService = mentorService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addMentor(@RequestBody @Valid Mentor mentor){
        try {
            return ResponseEntity.ok(this.mentorService.addMentor(mentor));
        } catch (Exception e){
            return ResponseEntity.internalServerError().body(Map.of("Error", e.getMessage()));
        }
    }

    @PostMapping("/addAll")
    public ResponseEntity<?> addAllMentors(@RequestBody List<Mentor> mentors){
        try {
            return ResponseEntity.ok(this.mentorService.addAllMentor(mentors));
        } catch (Exception e){
            return ResponseEntity.internalServerError().body(Map.of("Error", e.getMessage()));
        }
    }

    @GetMapping("/find/{mentorId}")
    public ResponseEntity<?> getMentor(@PathVariable long mentorId){
        try {
            return ResponseEntity.ok(this.mentorService.getMentorById(mentorId));
        } catch (NotFoundException e) {
            return new ResponseEntity<>(Map.of("Error", e.getMessage()), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/find/all")
    public ResponseEntity<?> getAllMentors(){
        try {
            List<MentorView> mentors = this.mentorService.getAllMentors();
            if (mentors.isEmpty()) return new ResponseEntity<>(Map.of("Error", "No mentors found in database"), HttpStatus.NOT_FOUND);
            else return ResponseEntity.ok(mentors);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PutMapping("/update/{mentorId}")
    public ResponseEntity<?>  updateMentor(@PathVariable long mentorId, @RequestBody @Valid MentorDto mentor){
        try {
            return ResponseEntity.ok(this.mentorService.updateMentor(mentorId, mentor));
        } catch (NotFoundException e) {
            return new ResponseEntity<>(Map.of("Error", e.getMessage()), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{mentorId}")
    public ResponseEntity<?> deleteMentor(@PathVariable long mentorId) {
        try {
            this.mentorService.deleteMentorById(mentorId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
