package com.n2015942084.main.domain;


import com.n2015942084.main.repository.BasicRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BasicTest {

    @Autowired
    private BasicRepository basicRepository;

    private Basic saveBasic;

    @Before
    public void init(){
        saveBasic = basicRepository.save(Basic.builder()
        .name("홍길동")
        .label("도적")
        .email("hong@gmail.com")
        .phone("012-3456-789")
        .build());
    }

    @Test
    public void testFindID(){
        Basic foundBasic = basicRepository.findById((saveBasic.getIdx())).orElse(null);
        assertThat(foundBasic.getIdx()).isEqualTo(saveBasic.getIdx());
    }
    @Test
    public void testFindAllBasic(){
        List<Basic> foundBasic = basicRepository.findAllByName("홍길동");
        assertThat(foundBasic.size()).isEqualTo(1);
    }
    @Test
    public void testFindNameBasic(){
      Basic foundNameBaord = basicRepository.findFirstByName("홍길동");
        assertThat(foundNameBaord.getName()).isEqualTo("홍길동");
    }
}
