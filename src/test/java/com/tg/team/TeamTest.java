package com.tg.team;

import com.tg.team.delivery.Team;
import com.tg.team.delivery.exception.MemberRoleExceedException;
import com.tg.team.delivery.interfact.MemberFilter;
import com.tg.team.delivery.member.BA;
import com.tg.team.delivery.member.DEV;
import com.tg.team.delivery.member.Member;
import com.tg.team.delivery.member.QA;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    public void shouldReturnTwoBAsWhenAddSecondBAsToTeam() {
//        given BAFilter, Team(Members)
        Member baOne = new BA("baOne");
        Member baTwo = new BA("baTwo");
        ArrayList<Member> members = new ArrayList<>();
        members.add(baOne);
        Team team = new Team(members);

//        when add ba to team(only one BA now)
        team.add(baTwo);
//        return only all BA
        assertAll("shouldReturnTwoBAsWhenAddSecondBAsToTeam", () -> {
            ArrayList<Member> result = team.getMembers(member -> member instanceof BA);
            assertEquals(2, result.size());
            assertEquals("baOne", result.get(0).getName());
            assertEquals("baTwo", result.get(1).getName());
        });

    }

    @Test
    public void shouldThrowExceptionWhenAddThirdBAToTeam() {
//        given BAFilter, Team(Members)
        Member baOne = new BA("baOne");
        Member baTwo = new BA("baTwo");
        Member baThr = new BA("baThr");
        ArrayList<Member> members = new ArrayList<>();
        members.add(baOne);
        members.add(baTwo);
        Team team = new Team(members);

//        when add ba to team(only two BA now) , then throw exception
        assertThrows(MemberRoleExceedException.class, () -> team.add(baThr), "This role already exceed number.");
//
        assertAll("shouldThrowExceptionWhenAddThirdBAToTeam", () -> {
            ArrayList<Member> result = team.getMembers(member -> member instanceof BA);
            assertEquals(2, result.size());
            assertEquals("baOne", result.get(0).getName());
            assertEquals("baTwo", result.get(1).getName());

        });

    }

    @Test
    public void shouldThrowExceptionWhenAddSecondQAToTeam() {
        Member qaOne = new QA("qaOne");
        Member qaTwo = new QA("qaTwo");
        ArrayList<Member> members = new ArrayList<>();
        members.add(qaOne);
        Team team = new Team(members);

        assertThrows(MemberRoleExceedException.class, () -> team.add(qaTwo), "This role already exceed number.");
        assertAll("shouldThrowExceptionWhenAddSecondQAToTeam", () -> {
            ArrayList<Member> result = team.getMembers(member -> member instanceof QA);
            assertEquals(1, result.size());
            assertEquals("qaOne", result.get(0).getName());
        });
    }

    @Test
    public void shouldThrowExceptionWhenAddFourthDEVToTeam() {
        Member qaOne = new QA("qaOne");
        Member baOne = new BA("baOne");

        Member devOne = new DEV("devOne");
        Member devTwo = new DEV("devTwo");
        Member devThr = new DEV("devThr");
        Member devFour = new DEV("devFour");
        ArrayList<Member> members = new ArrayList<>();
        members.add(baOne);
        members.add(qaOne);
        members.add(devOne);
        members.add(devTwo);
        members.add(devThr);
        Team team = new Team(members);

        assertThrows(MemberRoleExceedException.class, () -> team.add(devFour), "This role already exceed number.");
        assertAll("shouldThrowExceptionWhenAddFourthDEVToTeam", () -> {
            ArrayList<Member> result = team.getMembers(member -> member instanceof DEV);
            assertEquals(3, result.size());
            assertEquals("devOne", result.get(0).getName());
        });
    }
}
