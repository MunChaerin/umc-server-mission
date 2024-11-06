package org.example.umcmission.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.example.umcmission.domain.base.BaseEntity;
import org.example.umcmission.domain.enums.Gender;
import org.example.umcmission.domain.enums.MemberStatus;
import org.example.umcmission.domain.enums.SocialType;
import org.example.umcmission.domain.mapping.MemberAgree;
import org.example.umcmission.domain.mapping.MemberMission;
import org.example.umcmission.domain.mapping.MemberPrefer;

@Entity
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(
            nullable = false,
            length = 20
    )
    private String name;
    @Column(
            nullable = false,
            length = 40
    )
    private String address;
    @Column(
            nullable = false,
            length = 40
    )
    private String specAddress;
    @Enumerated(EnumType.STRING)
    @Column(
            columnDefinition = "VARCHAR(10)"
    )
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private SocialType socialType;
    @Enumerated(EnumType.STRING)
    @Column(
            columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'"
    )
    private MemberStatus status;
    private LocalDate inactiveDate;
    @Column(
            nullable = false,
            length = 50
    )
    private String email;
    private Integer point;
    @OneToMany(
            mappedBy = "member",
            cascade = {CascadeType.ALL}
    )
    private List<MemberAgree> memberAgreeList = new ArrayList();
    @OneToMany(
            mappedBy = "member",
            cascade = {CascadeType.ALL}
    )
    private List<MemberPrefer> memberPreferList = new ArrayList();
    @OneToMany(
            mappedBy = "member",
            cascade = {CascadeType.ALL}
    )
    private List<Review> reviewList = new ArrayList();
    @OneToMany(
            mappedBy = "member",
            cascade = {CascadeType.ALL}
    )
    private List<MemberMission> memberMissionList = new ArrayList();

    public static MemberBuilder builder() {
        return new MemberBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public String getSpecAddress() {
        return this.specAddress;
    }

    public Gender getGender() {
        return this.gender;
    }

    public SocialType getSocialType() {
        return this.socialType;
    }

    public MemberStatus getStatus() {
        return this.status;
    }

    public LocalDate getInactiveDate() {
        return this.inactiveDate;
    }

    public String getEmail() {
        return this.email;
    }

    public Integer getPoint() {
        return this.point;
    }

    public List<MemberAgree> getMemberAgreeList() {
        return this.memberAgreeList;
    }

    public List<MemberPrefer> getMemberPreferList() {
        return this.memberPreferList;
    }

    public List<Review> getReviewList() {
        return this.reviewList;
    }

    public List<MemberMission> getMemberMissionList() {
        return this.memberMissionList;
    }

    protected Member() {
    }

    public Member(Long id, String name, String address, String specAddress, Gender gender, SocialType socialType, MemberStatus status, LocalDate inactiveDate, String email, Integer point, List<MemberAgree> memberAgreeList, List<MemberPrefer> memberPreferList, List<Review> reviewList, List<MemberMission> memberMissionList) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.specAddress = specAddress;
        this.gender = gender;
        this.socialType = socialType;
        this.status = status;
        this.inactiveDate = inactiveDate;
        this.email = email;
        this.point = point;
        this.memberAgreeList = memberAgreeList;
        this.memberPreferList = memberPreferList;
        this.reviewList = reviewList;
        this.memberMissionList = memberMissionList;
    }

    public static class MemberBuilder {
        private Long id;
        private String name;
        private String address;
        private String specAddress;
        private Gender gender;
        private SocialType socialType;
        private MemberStatus status;
        private LocalDate inactiveDate;
        private String email;
        private Integer point;
        private List<MemberAgree> memberAgreeList;
        private List<MemberPrefer> memberPreferList;
        private List<Review> reviewList;
        private List<MemberMission> memberMissionList;

        MemberBuilder() {
        }

        public MemberBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public MemberBuilder name(String name) {
            this.name = name;
            return this;
        }

        public MemberBuilder address(String address) {
            this.address = address;
            return this;
        }

        public MemberBuilder specAddress(String specAddress) {
            this.specAddress = specAddress;
            return this;
        }

        public MemberBuilder gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public MemberBuilder socialType(SocialType socialType) {
            this.socialType = socialType;
            return this;
        }

        public MemberBuilder status(MemberStatus status) {
            this.status = status;
            return this;
        }

        public MemberBuilder inactiveDate(LocalDate inactiveDate) {
            this.inactiveDate = inactiveDate;
            return this;
        }

        public MemberBuilder email(String email) {
            this.email = email;
            return this;
        }

        public MemberBuilder point(Integer point) {
            this.point = point;
            return this;
        }

        public MemberBuilder memberAgreeList(List<MemberAgree> memberAgreeList) {
            this.memberAgreeList = memberAgreeList;
            return this;
        }

        public MemberBuilder memberPreferList(List<MemberPrefer> memberPreferList) {
            this.memberPreferList = memberPreferList;
            return this;
        }

        public MemberBuilder reviewList(List<Review> reviewList) {
            this.reviewList = reviewList;
            return this;
        }

        public MemberBuilder memberMissionList(List<MemberMission> memberMissionList) {
            this.memberMissionList = memberMissionList;
            return this;
        }

        public Member build() {
            return new Member(this.id, this.name, this.address, this.specAddress, this.gender, this.socialType, this.status, this.inactiveDate, this.email, this.point, this.memberAgreeList, this.memberPreferList, this.reviewList, this.memberMissionList);
        }

        public String toString() {
            return "Member.MemberBuilder(id=" + this.id + ", name=" + this.name + ", address=" + this.address + ", specAddress=" + this.specAddress + ", gender=" + this.gender + ", socialType=" + this.socialType + ", status=" + this.status + ", inactiveDate=" + this.inactiveDate + ", email=" + this.email + ", point=" + this.point + ", memberAgreeList=" + this.memberAgreeList + ", memberPreferList=" + this.memberPreferList + ", reviewList=" + this.reviewList + ", memberMissionList=" + this.memberMissionList + ")";
        }
    }
}

