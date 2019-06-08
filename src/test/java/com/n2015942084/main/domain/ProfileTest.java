package com.n2015942084.main.domain;

import com.n2015942084.main.repository.ProfileRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProfileTest {

    @Autowired
    private ProfileRepository profileRepository;

    private Profile saveProfile;

    @Before
    public void init(){

        saveProfile = profileRepository.save(Profile.builder()
                .netWork("트위터")
                .userName("@hong")
                .url("https://twitter/@home")
                .createDate(LocalDateTime.of(2019,05,21,19,33,21))
                .build()
        );
    }

    @Test
    public void testFindIdProfile(){
        Profile foundProfile = profileRepository.findById(saveProfile.getIdx()).orElse(null);
        assertThat(foundProfile.getIdx()).isEqualTo(saveProfile.getIdx());
    }

    @Test
    public void testFindAllProfile(){
        List<Profile> foundProfile = profileRepository.findAllByUserName("@hong");
        assertThat(foundProfile.size()).isEqualTo(1);
    }
    @Test
    public void testFindUserNameProfile(){
       Profile foundProfile = profileRepository.findFirstByUserName("@hong");
        assertThat(foundProfile.getUserName()).isEqualTo("@hong");
    }


}

