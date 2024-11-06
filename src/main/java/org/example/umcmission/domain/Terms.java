package org.example.umcmission.domain;

import jakarta.persistence.*;
import org.example.umcmission.domain.base.BaseEntity;
import org.example.umcmission.domain.mapping.MemberAgree;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Terms extends BaseEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(
            nullable = false,
            length = 20
    )
    private String title;
    private String body;
    private Boolean optional;
    @OneToMany(
            mappedBy = "terms",
            cascade = {CascadeType.ALL}
    )
    private List<MemberAgree> memberAgreeList = new ArrayList();

    public static TermsBuilder builder() {
        return new TermsBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getBody() {
        return this.body;
    }

    public Boolean getOptional() {
        return this.optional;
    }

    public List<MemberAgree> getMemberAgreeList() {
        return this.memberAgreeList;
    }

    protected Terms() {
    }

    public Terms(Long id, String title, String body, Boolean optional, List<MemberAgree> memberAgreeList) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.optional = optional;
        this.memberAgreeList = memberAgreeList;
    }

    public static class TermsBuilder {
        private Long id;
        private String title;
        private String body;
        private Boolean optional;
        private List<MemberAgree> memberAgreeList;

        TermsBuilder() {
        }

        public TermsBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public TermsBuilder title(String title) {
            this.title = title;
            return this;
        }

        public TermsBuilder body(String body) {
            this.body = body;
            return this;
        }

        public TermsBuilder optional(Boolean optional) {
            this.optional = optional;
            return this;
        }

        public TermsBuilder memberAgreeList(List<MemberAgree> memberAgreeList) {
            this.memberAgreeList = memberAgreeList;
            return this;
        }

        public Terms build() {
            return new Terms(this.id, this.title, this.body, this.optional, this.memberAgreeList);
        }

        public String toString() {
            return "Terms.TermsBuilder(id=" + this.id + ", title=" + this.title + ", body=" + this.body + ", optional=" + this.optional + ", memberAgreeList=" + this.memberAgreeList + ")";
        }
    }
}
