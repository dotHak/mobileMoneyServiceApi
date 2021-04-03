package com.hubert.momoservice.email.token;

import com.hubert.momoservice.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
@Transactional
public interface EmailConfirmationTokenRepository
        extends JpaRepository<EmailConfirmationToken, Long> {

    Optional<EmailConfirmationToken> findByToken(String token);

    @Transactional
    @Modifying
    @Query("UPDATE EmailConfirmationToken c " +
            "SET c.confirmedAt = ?2 " +
            "WHERE c.token = ?1")
    int updateConfirmedAt(String token,
                          LocalDateTime confirmedAt);

    Optional<EmailConfirmationToken> findEmailConfirmationTokenByAppUserOrderByConfirmedAtDesc(AppUser appUser);
}

