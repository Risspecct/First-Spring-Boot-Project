package users.rishik.spring_demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import users.rishik.spring_demo.enums.EnrolmentStatus;

@Data
@NoArgsConstructor
public class StatusUpdateDo {
    private EnrolmentStatus status;
}
