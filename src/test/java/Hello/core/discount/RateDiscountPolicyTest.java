package Hello.core.discount;

import Hello.core.member.Grade;
import Hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다")

    void vip_o(){
        //given
        Member member = new Member(1L,"kong", Grade.VIP);

        //when
        int discount = discountPolicy.discount(member, 10000);

        assertThat(discount).isEqualTo(1000);

        //then
    }

    @Test
    @DisplayName("VIP 가 아니면 할인이 적용되지 않아야 한다")

    void vip_x(){
        //given
        Member member = new Member(2L,"kong",Grade.BASIC);

        //when
        int discount = discountPolicy.discount(member, 10000);

        //then
        assertThat(discount).isEqualTo(0);
    }
}