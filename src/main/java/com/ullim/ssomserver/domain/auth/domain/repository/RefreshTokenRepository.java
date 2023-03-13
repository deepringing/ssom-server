package com.ullim.ssomserver.domain.auth.domain.repository;

import com.ullim.ssomserver.domain.auth.domain.RefreshToken;
import org.springframework.data.repository.CrudRepository;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {

}
