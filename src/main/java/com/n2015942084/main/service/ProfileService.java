package com.n2015942084.main.service;

import com.n2015942084.main.domain.Profile;
import com.n2015942084.main.repository.ProfileRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Page<Profile> findProfileList(Pageable pageable){
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber()-1,pageable.getPageSize());
        return profileRepository.findAll(pageable);
    }

    public Profile findProfileByIdx(Long idx){
        return profileRepository.findById(idx).orElse(new Profile());
    }


}
