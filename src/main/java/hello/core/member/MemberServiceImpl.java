package hello.core.member;

//관례 상 구현체가 하나만 있으면 인터페이스명 뒤에 Impl을 많이 쓴다.
public class MemberServiceImpl implements MemberService {
    //멤버서비스는 멤버리포지토리를 의존한다. 구현체를 넣어줘야 한다.
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    //직접 넣어주지 않고 생성자만 만들꺼다.
    //레포지토리의 결정을 생성자를 통해서 만들 것이다!

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
