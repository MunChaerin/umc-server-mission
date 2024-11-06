package org.example.umcmission.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import org.example.umcmission.domain.FoodCategory;
import org.example.umcmission.domain.Member;
import org.example.umcmission.domain.base.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberPrefer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //연관관계 - 단방향
    //member
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    //foodCategory
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="category_id")
    private FoodCategory foodCategory;

}

