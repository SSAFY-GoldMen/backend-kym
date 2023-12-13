package com.goldmen.cheolbuji.domain.map.gu.domain;

import com.goldmen.cheolbuji.domain.map.dong.domain.Dong;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Gu {
    @Id
    @Column(name = "GU_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "GU_NAME", nullable = false, length = 10)
    private String name;

    @Column(name = "GU_CODE", unique = true, nullable = false, length = 10)
    private String code;

    @OneToMany(mappedBy = "GU")
    private List<Dong> dongList = new ArrayList<>();

    @Builder
    public Gu(String name, String code){
        this.name = name;
        this.code = code;
    }
}
