package com.tg.team.delivery.interfact;

import com.tg.team.delivery.member.Member;

import java.util.ArrayList;

public interface MemberNumberRule {
    void consumer(ArrayList<Member> members, int numberLimit);
}
