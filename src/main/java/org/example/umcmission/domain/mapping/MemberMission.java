package org.example.umcmission.domain.mapping;
import jakarta.persistence.*;
import lombok.*;
import org.example.umcmission.domain.Member;
import org.example.umcmission.domain.Mission;
import org.example.umcmission.domain.base.BaseEntity;
import org.example.umcmission.domain.enums.MissionStatus;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private MissionStatus status;

    //연관관계
    //member
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;
    //mission
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="mission_id")
    private Mission mission;
}
