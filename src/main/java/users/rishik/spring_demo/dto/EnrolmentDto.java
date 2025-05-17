package users.rishik.spring_demo.dto;
import lombok.Data;
import lombok.NoArgsConstructor;
import users.rishik.spring_demo.enums.EnrolmentStatus;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class EnrolmentDto {
    private LocalDateTime enrolmentDate;
    private long studentId;
    private long courseId;
    private EnrolmentStatus status = EnrolmentStatus.ACTIVE;
}
