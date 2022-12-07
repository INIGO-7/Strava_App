package server.data.dto;

import java.util.ArrayList;
import java.util.List;

import server.data.domain.Challenge;


public class ChallengeAssembler {
	private static ChallengeAssembler instance;

	private ChallengeAssembler() { }
	
	public static ChallengeAssembler getInstance() {
		if (instance == null) {
			instance = new ChallengeAssembler();
		}
		
		return instance;
	}

	public ChallengeDTO challengeToDTO(Challenge challange) {
		ChallengeDTO dto = new ChallengeDTO();
		
		dto.setName(challange.getName());
		dto.setStartDate(challange.getStartDate());
		dto.setEndDate(challange.getEndDate());
		dto.setTargetType(challange.getTargetType());
		dto.setTarget(challange.getTarget());
		
		return dto;
	}
	
	public List<ChallengeDTO> challengeToDTO(List<Challenge> challenges) {		
		List<ChallengeDTO> dtos = new ArrayList<>();
		
		for (Challenge challenge : challenges) {
			dtos.add(this.challengeToDTO(challenge));
		}
		
		return dtos;
	}

}
