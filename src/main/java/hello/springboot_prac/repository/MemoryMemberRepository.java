package hello.springboot_prac.repository;

import hello.springboot_prac.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    //실무에서는 공유되는 변수는 동시성문제로 잘 사용하지 않음
    //ConcurrnetHashMap 사용 확인
    private static Map<Long,Member> store = new HashMap<>();

    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        //null값이 있을수도 있기에 Optional로 감싸줌
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
