package org.example.umcmission.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.example.umcmission.domain.base.BaseEntity;

@Entity
public class Review extends BaseEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String body;
    private Float score;
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "store_id"
    )
    private Store store;
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "member_id"
    )
    private Member member;

    public static ReviewBuilder builder() {
        return new ReviewBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getBody() {
        return this.body;
    }

    public Float getScore() {
        return this.score;
    }

    public Store getStore() {
        return this.store;
    }

    public Member getMember() {
        return this.member;
    }

    protected Review() {
    }

    public Review(Long id, String body, Float score, Store store, Member member) {
        this.id = id;
        this.body = body;
        this.score = score;
        this.store = store;
        this.member = member;
    }

    public static class ReviewBuilder {
        private Long id;
        private String body;
        private Float score;
        private Store store;
        private Member member;

        ReviewBuilder() {
        }

        public ReviewBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public ReviewBuilder body(String body) {
            this.body = body;
            return this;
        }

        public ReviewBuilder score(Float score) {
            this.score = score;
            return this;
        }

        public ReviewBuilder store(Store store) {
            this.store = store;
            return this;
        }

        public ReviewBuilder member(Member member) {
            this.member = member;
            return this;
        }

        public Review build() {
            return new Review(this.id, this.body, this.score, this.store, this.member);
        }

        public String toString() {
            return "Review.ReviewBuilder(id=" + this.id + ", body=" + this.body + ", score=" + this.score + ", store=" + this.store + ", member=" + this.member + ")";
        }
    }
}
