package MuscleChampMall.Member.Service;

import MuscleChampMall.Member.Entity.Member;
import MuscleChampMall.Member.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    public Member memberCreate(String username, String password, String email, String phoneNumber, String nickname, int mailKey) {
        Member member =  Member
                .builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .email(email)
                .phoneNumber(phoneNumber)
                .nickname(nickname)
                .mailKey(mailKey)
                .build();
        return this.memberRepository.save(member);
    }
}
