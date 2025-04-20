package hello.core.member;

public interface MemberService {
    //회원 서비스는 회원 가입, 회원 조회 기능이 있다.
    void join(Member member);
    Member findMember(Long memberId);
}
