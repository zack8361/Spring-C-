package Hello.core;

import Hello.core.member.Grade;
import Hello.core.member.Member;
import Hello.core.member.MemberService;
import Hello.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        Member member = new Member(1L,"kong", Grade.VIP);

        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("findMember = " + findMember.getName());
    }
}
