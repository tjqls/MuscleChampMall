package MuscleChampMall.Member;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Component
public class MemberCreateForm {
    @NotEmpty(message = "사용자ID는 필수 항목 입니다.")
    @Email
    private String username;

    @NotEmpty(message = "비밀번호는 필수 항목 입니다.")
    private String password1;

    @NotEmpty(message = "비밀번호 확인은 필수 항목 입니다.")
    private String password2;

    @Size(min = 3, max = 25)
    @NotEmpty(message = "닉네임은 필수 항목 입니다.")
    private String nickname;

    private String email;

    @NotEmpty(message = "전화 번호는 필수 항목 입니다.")
    private String phoneNumber;

    private Integer mailKey = null;

//    private Integer genMailKey;

    private boolean mailAuth;
}
