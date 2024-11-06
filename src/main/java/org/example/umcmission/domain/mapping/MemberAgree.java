package org.example.umcmission.domain.mapping;

import jakarta.persistence.*;
import org.example.umcmission.domain.Member;
import org.example.umcmission.domain.Terms;
import org.example.umcmission.domain.base.BaseEntity;

@Entity
public class MemberAgree extends BaseEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "member_id"
    )
    private Member member;
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "terms_id"
    )
    private Terms terms;

    public static MemberAgreeBuilder builder() {
        return new MemberAgreeBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public Member getMember() {
        return this.member;
    }

    public Terms getTerms() {
        return this.terms;
    }

    protected MemberAgree() {
    }

    public MemberAgree(Long id, Member member, Terms terms) {
        this.id = id;
        this.member = member;
        this.terms = terms;
    }

    public static class MemberAgreeBuilder {
        private Long id;
        private Member member;
        private Terms terms;

        MemberAgreeBuilder() {
        }

        public MemberAgreeBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public MemberAgreeBuilder member(Member member) {
            this.member = member;
            return this;
        }

        public MemberAgreeBuilder terms(Terms terms) {
            this.terms = terms;
            return this;
        }

        public MemberAgree build() {
            return new MemberAgree(this.id, this.member, this.terms);
        }

        public String toString() {
            return "MemberAgree.MemberAgreeBuilder(id=" + this.id + ", member=" + this.member + ", terms=" + this.terms + ")";
        }
    }
}
