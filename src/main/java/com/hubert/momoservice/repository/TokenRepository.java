package com.hubert.momoservice.repository;

import com.hubert.momoservice.entity.Token;
import com.hubert.momoservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

    public List<Token> findAllByUser_Id(Long id);

    public List<Token> findAllByUser(User user);

}
