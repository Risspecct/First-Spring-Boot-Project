package users.rishik.spring_demo.dto;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import users.rishik.spring_demo.enums.EnrolmentStatus;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class EnrolmentDto {
    @NotNull
    private LocalDateTime enrolmentDate;
    @NotNull
    private long studentId;
    @NotNull
    private long courseId;

    private EnrolmentStatus status = EnrolmentStatus.ACTIVE;
}
