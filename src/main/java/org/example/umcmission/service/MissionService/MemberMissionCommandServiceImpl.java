package org.example.umcmission.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.example.umcmission.domain.enums.MissionStatus;
import org.example.umcmission.domain.mapping.MemberMission;
import org.example.umcmission.repository.MemberMissionRespository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService{
    private final MemberMissionRespository memberMissionRespository;

    @Override
    public void completeMission(Long memberMissionId){
        MemberMission memberMission = memberMissionRespository.findById(memberMissionId)
                .orElseThrow(() -> new IllegalArgumentException("User mission not found"));

        if (memberMission.getStatus() != MissionStatus.CHALLENGING) {
            throw new IllegalStateException("Mission is not in progress");
        }

        memberMission.setStatus(MissionStatus.COMPLETE);
        memberMission.setCompletedAt(LocalDateTime.now());
        memberMissionRespository.save(memberMission);
    }
}
