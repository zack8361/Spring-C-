package Hello.core;

import Hello.core.member.Grade;
import Hello.core.member.Member;
import Hello.core.member.MemberService;
import Hello.core.member.MemberServiceImpl;
import Hello.core.order.Order;
import Hello.core.order.OrderService;
import Hello.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();
        Long memberId = 1L;
        Member member = new Member(memberId,"kong", Grade.VIP);

//        먼저 회원가입
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"kong",10000);

        System.out.println("order = " + order);
        System.out.println("order = " + order.calculatePrice());
    }
}
