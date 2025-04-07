package com.siesta.modern.domain.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Member {
    @Id
    private Long id;
    private String username;
    private String email;

    private Member(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public static Member createMember(String username, String email) {
        return new Member(username,email);
    }
}
