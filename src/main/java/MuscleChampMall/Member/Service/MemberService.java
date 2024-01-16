package MuscleChampMall.Member.Service;

import MuscleChampMall.Base.Exception.DataNotFoundException;
import MuscleChampMall.Member.Entity.Member;
import MuscleChampMall.Member.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;

  public Member findByUsername(String name) {
    Optional<Member> member = this.memberRepository.findByUsername(name);
    if (member.isPresent()) {
      return member.get();
    } throw new DataNotFoundException("member not found");
  }
}
