package com.tg.team;

import com.tg.team.delivery.Team;
import com.tg.team.delivery.interfact.MemberFilter;
import com.tg.team.delivery.member.BA;
import com.tg.team.delivery.member.DEV;
import com.tg.team.delivery.member.Member;
import com.tg.team.delivery.member.QA;
import com.tg.team.delivery.story.StoryStatus;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TeamTest {

    @Test
    public void shouldReturnAllBAMemberWhenGivenBAFilter() {
//        given BAFilter, Team(Members)
        Member baOne = new BA("baOne");
        Member baTwo = new BA("baTwo");
        Member qaOne = new QA("qaOne");
        Member devOne = new DEV("devOne");
        ArrayList<Member> members = new ArrayList<>();
        members.add(baOne);
        members.add(qaOne);
        members.add(devOne);
        members.add(baTwo);
        Team team = new Team(members);

        MemberFilter memberFilter = member -> member instanceof BA;
//        when execute team.getMembers(BAFilter)

        ArrayList<Member> bas = team.getMembers(memberFilter);
//        return only all BA
        assertAll("shouldReturnAllBAMemberWhenGivenBAFilter", () -> {
            assertEquals(2, bas.size());
            assertEquals("baOne", ((BA) bas.get(0)).getName());
            assertEquals("baTwo", ((BA) bas.get(1)).getName());
        });

    }

    @Test
    public void shouldReturnAllMemberThatNameIncludeSpecifyCharacterWhenGivenCharacterFilter() {
//        given BAFilter, Team(Members)
        Member baOne = new BA("baOne");
        Member baTwo = new BA("baTwo");
        Member qaOne = new QA("qaOne");
        Member devOne = new DEV("devOne");
        ArrayList<Member> members = new ArrayList<>();
        members.add(baOne);
        members.add(qaOne);
        members.add(devOne);
        members.add(baTwo);
        Team team = new Team(members);

        MemberFilter nameFilter = member -> member.getName().contains("a");
//        when execute team.getMembers(nameFilter)

        ArrayList<Member> result = team.getMembers(nameFilter);
//        return only all BA
        assertAll("shouldReturnAllMemberThatNameIncludeSpecifyCharacterWhenGivenCharacterFilter", () -> {
            assertEquals(3, result.size());
            assertEquals("baOne", ((BA) result.get(0)).getName());
            assertEquals("qaOne", ((QA) result.get(1)).getName());
            assertEquals("baTwo", ((BA) result.get(2)).getName());
        });

    }
}
