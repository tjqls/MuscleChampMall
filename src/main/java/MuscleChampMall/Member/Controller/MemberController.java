package MuscleChampMall.Member.Controller;

import MuscleChampMall.Member.MemberCreateForm;
import MuscleChampMall.Member.Service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/member")
@Controller
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/signup")
    public String signup(MemberCreateForm memberCreateForm) {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@Valid MemberCreateForm memberCreateForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "signup";
        }

        if (!memberCreateForm.getPassword1().equals(memberCreateForm.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordInCorrect", "비밀번호가 일치하지 않습니다.");
            return "signup";
        }

        this.memberService.memberCreate(memberCreateForm.getUsername(), memberCreateForm.getPassword1(), memberCreateForm.getEmail(),
                memberCreateForm.getPhoneNumber(), memberCreateForm.getNickname(), memberCreateForm.getMailKey());

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }


}
