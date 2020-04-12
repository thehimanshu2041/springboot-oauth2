package com.api.shadow.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.shadow.constants.VariableConstants;
import com.api.shadow.dao.repository.CardRepository;
import com.api.shadow.dao.repository.RoleRepository;
import com.api.shadow.dao.repository.UserRepository;
import com.api.shadow.dto.UserDto;
import com.api.shadow.entity.CardEntity;
import com.api.shadow.entity.RoleTypeEnum;
import com.api.shadow.entity.UserEntity;
import com.api.shadow.utility.TokenGenerator;

@Service
public class UserDaoImpl implements UserDao {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private CardRepository cardRepository;

	@Override
	public UserEntity save(UserEntity user) {

		UserEntity userWithDuplicateUsername = userRepository.findByUsername(user.getUsername());
		if (userWithDuplicateUsername != null && user.getUserID() != userWithDuplicateUsername.getUserID()) {
			throw new RuntimeException("Duplicate username.");
		}
		UserEntity userWithDuplicateEmail = userRepository.findByUserEmail(user.getUserEmail());
		if (userWithDuplicateEmail != null && user.getUserID() != userWithDuplicateEmail.getUserID()) {
			throw new RuntimeException("Duplicate email.");
		}

		user.setUserCreatedDateTime(new Date());
		user.setUserModifiedDateTime(new Date());
		user.setUserIsAdmin(VariableConstants.FLAG_N);
		user.setUserIsDeleted(VariableConstants.FLAG_N);
		user.setUserUpdatedBy(user.getUsername());
		user.setUserPassword(BCrypt.hashpw(user.getUserPassword(), BCrypt.gensalt()));
		user.setUserToken(new TokenGenerator().generateToken());

		/** set default role */
		UserDto userDto = new UserDto();
		List<String> list = new ArrayList<String>();
		list.add("USER");
		userDto.setRole(list);
		/** end */

		List<RoleTypeEnum> roleTypes = new ArrayList<>();
		userDto.getRole().stream().map(role -> roleTypes.add(RoleTypeEnum.valueOf(role)));
		user.setRoles(roleRepository.find(userDto.getRole()));

		return userRepository.save(user);
	}

	@Override
	public List<UserEntity> findAll() {
		List<UserEntity> list = new ArrayList<>();
		userRepository.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public UserEntity findByUsername(String userId) {
		return userRepository.findByUsername(userId);
	}

	@Override
	public UserEntity findByUserEmail(String userEmail) {
		return userRepository.findByUserEmail(userEmail);
	}

	@Override
	public boolean saveCardDetail(CardEntity cardEntity) {
		boolean response = false;
		try {
			CardEntity ce = cardRepository.findByCardUserID(cardEntity.getCardUserID());
			if (null != ce) {
				cardRepository.updateCardDetails(cardEntity.getCardNumber(), cardEntity.getHolderFirstName(),
						cardEntity.getHolderLastName(), cardEntity.getExpiryMonth(), cardEntity.getExpiryYear(),
						cardEntity.getCvv(), cardEntity.getCardUserID());
			} else {
				cardRepository.save(cardEntity);
			}
			response = true;
		} catch (Exception e) {
			e.printStackTrace();
			response = false;
		}
		return response;
	}

	@Override
	public CardEntity getCardDetail(int userID) {
		return cardRepository.findByCardUserID(userID);
	}
}
