package com.tg.team.delivery.member;

public class Member {
    String name;

    public Member() {
        this.name = "anonymous";
    }

    public String getName() {
        return name;
    }

    public Member(String name) {
        this.name = name;
    }
}
