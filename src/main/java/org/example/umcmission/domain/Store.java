package org.example.umcmission.domain;

import jakarta.persistence.*;
import org.example.umcmission.domain.base.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Store extends BaseEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String name;
    private String address;
    private Float score;
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "region_id"
    )
    private Region region;
    @OneToMany(
            mappedBy = "store",
            cascade = {CascadeType.ALL}
    )
    private List<Mission> missionList = new ArrayList();
    @OneToMany(
            mappedBy = "store",
            cascade = {CascadeType.ALL}
    )
    private List<Review> reviewList = new ArrayList();

    public String toString() {
        Long var10000 = this.id;
        return "Store{id=" + var10000 + ", name='" + this.name + "', address='" + this.address + "', score=" + this.score + ", region=" + (this.region != null ? this.region.getName() : "N/A") + "}";
    }

    public static StoreBuilder builder() {
        return new StoreBuilder();
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

    public Float getScore() {
        return this.score;
    }

    public Region getRegion() {
        return this.region;
    }

    public List<Mission> getMissionList() {
        return this.missionList;
    }

    public List<Review> getReviewList() {
        return this.reviewList;
    }

    protected Store() {
    }

    public Store(Long id, String name, String address, Float score, Region region, List<Mission> missionList, List<Review> reviewList) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.score = score;
        this.region = region;
        this.missionList = missionList;
        this.reviewList = reviewList;
    }

    public static class StoreBuilder {
        private Long id;
        private String name;
        private String address;
        private Float score;
        private Region region;
        private List<Mission> missionList;
        private List<Review> reviewList;

        StoreBuilder() {
        }

        public StoreBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public StoreBuilder name(String name) {
            this.name = name;
            return this;
        }

        public StoreBuilder address(String address) {
            this.address = address;
            return this;
        }

        public StoreBuilder score(Float score) {
            this.score = score;
            return this;
        }

        public StoreBuilder region(Region region) {
            this.region = region;
            return this;
        }

        public StoreBuilder missionList(List<Mission> missionList) {
            this.missionList = missionList;
            return this;
        }

        public StoreBuilder reviewList(List<Review> reviewList) {
            this.reviewList = reviewList;
            return this;
        }

        public Store build() {
            return new Store(this.id, this.name, this.address, this.score, this.region, this.missionList, this.reviewList);
        }

        public String toString() {
            return "Store.StoreBuilder(id=" + this.id + ", name=" + this.name + ", address=" + this.address + ", score=" + this.score + ", region=" + this.region + ", missionList=" + this.missionList + ", reviewList=" + this.reviewList + ")";
        }
    }
}
