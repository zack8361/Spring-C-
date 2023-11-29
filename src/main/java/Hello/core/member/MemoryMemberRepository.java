package Hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;



@Component
public class MemoryMemberRepository implements MemberRepository{

    private static HashMap<Long, Member> store = new HashMap<>();
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long MemberId) {
        return store.get(MemberId);
    }
}
