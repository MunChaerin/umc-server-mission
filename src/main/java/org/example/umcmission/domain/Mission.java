package org.example.umcmission.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.example.umcmission.domain.base.BaseEntity;
import org.example.umcmission.domain.enums.MissionStatus;
import org.example.umcmission.domain.mapping.MemberMission;

@Entity
public class Mission extends BaseEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private Integer reward;
    private LocalDate deadline;
    private String missionSpec;
    @Enumerated(EnumType.STRING)
    @Column(
            columnDefinition = "VARCHAR(15)"
    )
    private MissionStatus status;
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "store_id"
    )
    private Store store;
    @OneToMany(
            mappedBy = "mission",
            cascade = {CascadeType.ALL}
    )
    private List<MemberMission> memberMissionList = new ArrayList();

    public static MissionBuilder builder() {
        return new MissionBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public Integer getReward() {
        return this.reward;
    }

    public LocalDate getDeadline() {
        return this.deadline;
    }

    public String getMissionSpec() {
        return this.missionSpec;
    }

    public MissionStatus getStatus() {
        return this.status;
    }

    public Store getStore() {
        return this.store;
    }

    public List<MemberMission> getMemberMissionList() {
        return this.memberMissionList;
    }

    protected Mission() {
    }

    public Mission(Long id, Integer reward, LocalDate deadline, String missionSpec, MissionStatus status, Store store, List<MemberMission> memberMissionList) {
        this.id = id;
        this.reward = reward;
        this.deadline = deadline;
        this.missionSpec = missionSpec;
        this.status = status;
        this.store = store;
        this.memberMissionList = memberMissionList;
    }

    public static class MissionBuilder {
        private Long id;
        private Integer reward;
        private LocalDate deadline;
        private String missionSpec;
        private MissionStatus status;
        private Store store;
        private List<MemberMission> memberMissionList;

        MissionBuilder() {
        }

        public MissionBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public MissionBuilder reward(Integer reward) {
            this.reward = reward;
            return this;
        }

        public MissionBuilder deadline(LocalDate deadline) {
            this.deadline = deadline;
            return this;
        }

        public MissionBuilder missionSpec(String missionSpec) {
            this.missionSpec = missionSpec;
            return this;
        }

        public MissionBuilder status(MissionStatus status) {
            this.status = status;
            return this;
        }

        public MissionBuilder store(Store store) {
            this.store = store;
            return this;
        }

        public MissionBuilder memberMissionList(List<MemberMission> memberMissionList) {
            this.memberMissionList = memberMissionList;
            return this;
        }

        public Mission build() {
            return new Mission(this.id, this.reward, this.deadline, this.missionSpec, this.status, this.store, this.memberMissionList);
        }

        public String toString() {
            return "Mission.MissionBuilder(id=" + this.id + ", reward=" + this.reward + ", deadline=" + this.deadline + ", missionSpec=" + this.missionSpec + ", status=" + this.status + ", store=" + this.store + ", memberMissionList=" + this.memberMissionList + ")";
        }
    }
}
