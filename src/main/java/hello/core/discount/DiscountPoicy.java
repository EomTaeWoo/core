package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPoicy {

    /**
     *
     * @return
     */
    int discount(Member member, int price);
}
