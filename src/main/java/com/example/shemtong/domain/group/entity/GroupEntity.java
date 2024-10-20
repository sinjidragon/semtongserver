package com.example.shemtong.domain.group.entity;

import com.example.shemtong.domain.user.Entity.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "groups_info")
@SuperBuilder
public class GroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gid;

    private String groupname;

    @Column(nullable = false, unique = true)
    private String groupcode;

    @OneToMany(mappedBy = "group")
    private List<UserEntity> users;

}
