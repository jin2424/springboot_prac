package hello.springboot_prac.repository;

import hello.springboot_prac.domain.Member;
import org.apache.catalina.LifecycleState;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
