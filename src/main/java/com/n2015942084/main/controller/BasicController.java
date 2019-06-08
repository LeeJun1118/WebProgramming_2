package com.n2015942084.main.controller;

import com.n2015942084.main.domain.Basic;
import com.n2015942084.main.domain.Profile;
import com.n2015942084.main.repository.BasicRepository;
import com.n2015942084.main.repository.ProfileRepository;
import com.n2015942084.main.service.BasicService;
import com.n2015942084.main.service.ProfileService;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
public class BasicController {

    private BasicService basicService;
    private BasicRepository basicRepository;

    private ProfileService profileService;
    private ProfileRepository profileRepository;

    public BasicController(BasicService basicService, BasicRepository basicRepository, ProfileService profileService, ProfileRepository profileRepository) {
        this.basicService = basicService;
        this.basicRepository = basicRepository;
        this.profileService = profileService;
        this.profileRepository = profileRepository;
    }

    @GetMapping("/")
    public String list(@PageableDefault Pageable pageable,Model model){
        model.addAttribute("basicList",basicService.findBasicList(pageable));
        model.addAttribute("profileList",profileService.findProfileList(pageable));
        return "index";
    }


    @GetMapping({"/basic/{idx}"})
    public String read(@PathVariable Long idx,Model model){
        model.addAttribute("basic",basicService.findBasicByIdx(idx));
        return "basic/item";
    }

    @PostMapping("/basic/add")
    public String add(Basic basic, Model model) {

        Basic saveBasic = basicRepository.save(basic);
        model.addAttribute("basic", basicService.findBasicByIdx(saveBasic.getIdx()));
        return "basic/item";
    }
    @GetMapping({"/basic/new"})
    public String form(Basic basic){
        return "basic/new";
    }


    //============================================//

    @GetMapping({"/profile/{idx}"})
    public String readP(@PathVariable Long idx, Model model){
        model.addAttribute("profile",profileService.findProfileByIdx(idx));
        return "profile/item";
    }
    @PostMapping("/profile/add")
    public String addP(Profile profile, Model model) {

        profile.setCreateDate(LocalDateTime.now());

        Profile saveProfile = profileRepository.save(profile);
        model.addAttribute("profile", profileService.findProfileByIdx(saveProfile.getIdx()));
        return "profile/item";
    }
    @GetMapping({"/profile/new"})
    public String formP(Profile profile){
        return "profile/new";
    }

}
