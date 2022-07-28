package com.inventorycheck.repo;

import com.inventorycheck.entity.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin,Long> {

  Optional<UserLogin> findByMobileNo(String mobileNo);

}
