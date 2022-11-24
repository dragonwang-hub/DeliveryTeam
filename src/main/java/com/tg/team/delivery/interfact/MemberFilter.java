package com.tg.team.delivery.interfact;

import com.tg.team.delivery.member.Member;

public interface MemberFilter {
    boolean test(Member member);
}
