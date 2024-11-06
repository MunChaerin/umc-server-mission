package org.example.umcmission.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.example.umcmission.domain.base.BaseEntity;

@Entity
public class Region extends BaseEntity {
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

    public static RegionBuilder builder() {
        return new RegionBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    protected Region() {
    }

    public Region(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static class RegionBuilder {
        private Long id;
        private String name;

        RegionBuilder() {
        }

        public RegionBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public RegionBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Region build() {
            return new Region(this.id, this.name);
        }

        public String toString() {
            return "Region.RegionBuilder(id=" + this.id + ", name=" + this.name + ")";
        }
    }
}

