//package com.n2015942084.main.controller;
//
//import com.n2015942084.main.domain.Profile;
//import com.n2015942084.main.repository.ProfileRepository;
//import com.n2015942084.main.service.ProfileService;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import java.time.LocalDateTime;
//
//@Controller
//public class ProfileController {
//
//    private ProfileService profileService;
//    private ProfileRepository profileRepository;
//
//    public ProfileController(ProfileService profileService, ProfileRepository profileRepository) {
//        this.profileService = profileService;
//        this.profileRepository = profileRepository;
//    }
//
//    @GetMapping({"/","/profile"})
//    public String list(@PageableDefault Pageable pageable,Model model){
//        model.addAttribute("profileList",profileService.findProfileList(pageable));
//        return "index";
//    }
//
//
//    @GetMapping("/{idx}")
//    public String read(@PathVariable Long idx, Model model){
//        model.addAttribute("profile",profileService.findProfileByIdx(idx));
//        return "/profile/item";
//    }
//    @PostMapping("/add")
//    public String add(Profile profile, Model model) {
//
//        profile.setCreateDate(LocalDateTime.now());
//
//        Profile saveProfile = profileRepository.save(profile);
//        model.addAttribute("profile", profileService.findProfileByIdx(saveProfile.getIdx()));
//        return "/profile/item";
//    }
//    @GetMapping("/new")
//    public String form(Profile profile){
//        return "new";
//    }
//
//}
