package org.example.umcmission.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = -1324103643L;

    public static final QMember member = new QMember("member1");

    public final org.example.umcmission.domain.base.QBaseEntity _super = new org.example.umcmission.domain.base.QBaseEntity(this);

    public final StringPath address = createString("address");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final EnumPath<org.example.umcmission.domain.enums.Gender> gender = createEnum("gender", org.example.umcmission.domain.enums.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DatePath<java.time.LocalDate> inactiveDate = createDate("inactiveDate", java.time.LocalDate.class);

    public final ListPath<org.example.umcmission.domain.mapping.MemberAgree, org.example.umcmission.domain.mapping.QMemberAgree> memberAgreeList = this.<org.example.umcmission.domain.mapping.MemberAgree, org.example.umcmission.domain.mapping.QMemberAgree>createList("memberAgreeList", org.example.umcmission.domain.mapping.MemberAgree.class, org.example.umcmission.domain.mapping.QMemberAgree.class, PathInits.DIRECT2);

    public final ListPath<org.example.umcmission.domain.mapping.MemberMission, org.example.umcmission.domain.mapping.QMemberMission> memberMissionList = this.<org.example.umcmission.domain.mapping.MemberMission, org.example.umcmission.domain.mapping.QMemberMission>createList("memberMissionList", org.example.umcmission.domain.mapping.MemberMission.class, org.example.umcmission.domain.mapping.QMemberMission.class, PathInits.DIRECT2);

    public final ListPath<org.example.umcmission.domain.mapping.MemberPrefer, org.example.umcmission.domain.mapping.QMemberPrefer> memberPreferList = this.<org.example.umcmission.domain.mapping.MemberPrefer, org.example.umcmission.domain.mapping.QMemberPrefer>createList("memberPreferList", org.example.umcmission.domain.mapping.MemberPrefer.class, org.example.umcmission.domain.mapping.QMemberPrefer.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final ListPath<Review, QReview> reviewList = this.<Review, QReview>createList("reviewList", Review.class, QReview.class, PathInits.DIRECT2);

    public final EnumPath<org.example.umcmission.domain.enums.SocialType> socialType = createEnum("socialType", org.example.umcmission.domain.enums.SocialType.class);

    public final StringPath specAddress = createString("specAddress");

    public final EnumPath<org.example.umcmission.domain.enums.MemberStatus> status = createEnum("status", org.example.umcmission.domain.enums.MemberStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

