package com.n2015942084.main.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table

@NoArgsConstructor
@Getter
@Setter

public class Profile implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idx;

    @Column
    private String netWork;

    @Column
    private String userName;

    @Column
    private String url;

    @Column
    private LocalDateTime createDate;


    @Builder
    public Profile(String netWork, String userName, String url, LocalDateTime createDate) {
        this.netWork = netWork;
        this.userName = userName;
        this.url = url;
        this.createDate = createDate;
    }

}

