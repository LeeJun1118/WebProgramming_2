package com.n2015942084.main.repository;

import com.n2015942084.main.domain.Basic;
import com.n2015942084.main.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfileRepository extends JpaRepository<Profile,Long> {
    List<Profile> findAllByUserName(final String userName);
    Profile findFirstByUserName(final String userName);
}
