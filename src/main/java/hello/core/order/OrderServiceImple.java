package hello.core.order;

import hello.core.discount.DiscountPoicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImple implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPoicy discountPoicy;
    //private final DiscountPoicy discountPoicy = new FixDiscountPolicy();
    //private final DiscountPoicy discountPoicy = new RateDiscountPolicy();
    //private DiscountPoicy discountPoicy;    // 인터페이스에만 의존한다.

    public OrderServiceImple(MemberRepository memberRepository, DiscountPoicy discountPoicy) {
        this.memberRepository = memberRepository;
        this.discountPoicy = discountPoicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPoicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
