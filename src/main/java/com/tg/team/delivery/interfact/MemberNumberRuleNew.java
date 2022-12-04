package com.tg.team.delivery.interfact;

import com.tg.team.delivery.Team;
import com.tg.team.delivery.member.Member;

import java.util.ArrayList;

public interface MemberNumberRuleNew {
    boolean test(Member member, Team team);
}
