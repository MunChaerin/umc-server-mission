package org.example.umcmission.domain;
import jakarta.persistence.*;
import lombok.*;
import org.example.umcmission.domain.base.BaseEntity;
import org.example.umcmission.domain.enums.MemberStatus;
import org.example.umcmission.domain.enums.MissionStatus;
import org.example.umcmission.domain.mapping.MemberMission;
import org.example.umcmission.dto.requestDTO.MissionReqDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer reward;

    private LocalDate deadline;

    private String missionSpec;

    @Enumerated(EnumType.STRING)
    @Column(name = "status",columnDefinition = "VARCHAR(10)")
    private MissionStatus missionStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();

    //상태 변경
    public void updateChallengingMission(){
        this.missionStatus = MissionStatus.CHALLENGING;
    }
}
