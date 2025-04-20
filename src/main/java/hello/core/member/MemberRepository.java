package hello.core.member;

public interface MemberRepository {
    //회원을 저장
    void save(Member member);
    //회원을 Id로 찾는 기능
    Member findById(Long memberId);
}
