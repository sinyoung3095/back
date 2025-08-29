package com.example.rebound.controller;

import com.example.rebound.common.exception.LoginFailCounselorException;
import com.example.rebound.dto.CounselorDTO;
import com.example.rebound.mapper.CounselorMapper;
import com.example.rebound.repository.CounselorDAO;
import com.example.rebound.service.CounselorService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/counselor/**")
public class CounselorController {
    private final CounselorService counselorService;
    private final HttpSession session;
    private final CounselorDAO counselorDAO;

    //    상담사 회원가입 페이지로 이동
    @GetMapping("join")
    public String goToCounselorJoin(CounselorDTO counselorDTO, Model model) {
        model.addAttribute("counselorDTO", counselorDTO);
        return "member/join-counselor";
    }

    //    이메일 중복 검사
    @PostMapping("check-email")
    @ResponseBody
    public ResponseEntity<?> checkEmail(@RequestBody Map<String, String> counselor){
        String counselorEmail = counselor.get("counselorEmail");

        boolean isExist = counselorService.isExistCounselorEmail(counselorEmail);
        Map<String, Object> result = new HashMap<>();
        result.put("counselorEmail", counselorEmail);
        result.put("isExist", isExist);

//        System.out.println("이메일 체크 실행");
        if(isExist){
//            System.out.println("이미 존재하는 이메일");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        return ResponseEntity.ok().body(result);
    }

    //    전화번호 중복 검사
    @PostMapping("check-phone-number")
    @ResponseBody
    public ResponseEntity<?> checkPhoneNumber(@RequestBody Map<String, String> counselor){
        String counselorPhoneNumber = counselor.get("counselorPhoneNumber");

        boolean isExist = counselorService.isExistCounselorPhoneNumber(counselorPhoneNumber);
        Map<String, Object> result = new HashMap<>();
        result.put("counselorPhoneNumber", counselorPhoneNumber);
        result.put("isExist", isExist);

//        System.out.println("전화번호 체크 실행");
        if(isExist){
//            System.out.println("이미 존재하는 전화번호");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        return ResponseEntity.ok().body(result);
    }

//    회원가입 완료
    @PostMapping("join")
    public RedirectView joinCounselor(CounselorDTO counselorDTO, @RequestParam("file") List<MultipartFile> counselorQualificationsFiles) {
        counselorService.joinCounselor(counselorDTO, counselorQualificationsFiles);
        return new RedirectView("/counselor/login");
    }

    //    로그인 페이지로 이동
    @GetMapping("login")
    public String goToLogin(CounselorDTO counselorDTO, Model model) {
//        로그인 페이지 이동
        model.addAttribute("counselorDTO", counselorDTO);
        return "member/login-counselor";
    }

    //    로그인 완료
    @PostMapping("login")
    public String Login(CounselorDTO counselorDTO) {
        CounselorDTO counselor=counselorService.login(counselorDTO).orElseThrow(LoginFailCounselorException::new);
        session.setAttribute("counselor", counselor);
        counselorDAO.setLatelyDate(counselorDTO.getCounselorEmail());
        return "redirect:/"; }

//    마이페이지로 이동
    @GetMapping("mypage")
    public String goToMyPageCounselor(HttpSession session, Model model) {
        CounselorDTO counselor = (CounselorDTO) session.getAttribute("counselor");
        if (counselor == null) {
            return "redirect:/counselor/login";
        }

        Optional<CounselorDTO> fullCounselorOpt = counselorService.showFileById(counselor.getId());

        if (fullCounselorOpt.isEmpty()) {
            model.addAttribute("counselor", counselor);
            model.addAttribute("file", null);
            return "member/counselor-mypage";
        }
        CounselorDTO fullCounselor = fullCounselorOpt.get();
        if (fullCounselorOpt.isPresent()) {
            model.addAttribute("counselor", fullCounselor);
            model.addAttribute("file", fullCounselor.getFile());
        } else {
            model.addAttribute("file", null);
        }
        return "member/counselor-mypage";
    }
    @GetMapping("mypage/info")
    public String goToMyPageCouselorInfo(){
        return "member/mypage-counselor-info";
    }
    @GetMapping("mypage/post")
    public String goToMyPageCounselorPost(){
        return "member/mypage-counselor-post";
    }
    @GetMapping("mypage/reply")
    public String goToMyPageCounselorReply(){
        return "member/mypage-counselor-reply";
    }
    @GetMapping("mypage/set")
    public String goToMyPageCounselorSet(HttpSession session, Model model) {
        CounselorDTO counselor = (CounselorDTO) session.getAttribute("counselor");
        Optional<CounselorDTO> fullCounselorOpt = counselorService.showFileById(counselor.getId());

        if (fullCounselorOpt.isEmpty()) {
            model.addAttribute("counselor", counselor);
            model.addAttribute("file", null);
            return "member/mypage-counselor-set";
        }
        CounselorDTO fullCounselor = fullCounselorOpt.get();
        model.addAttribute("counselor", fullCounselor);
        model.addAttribute("file", fullCounselor.getFile());
        return "member/mypage-counselor-set";
    }
    @GetMapping("mypage/consultation/history")
    public String goToMyPageCounselorConsultationHistory(){
        return "member/mypage-counselor-consultation-history";
    }

    //로그아웃
    @GetMapping("logout")
    public RedirectView logout(){
        session.invalidate();
        return new RedirectView("/counselor/login");
    }

    //    이메일 찾기
    @GetMapping("find-email")
    public String goToFindEmail(){
        return "counselor/find-email";
    }

    //    인증번호 성공
    @PostMapping("find-email-ok")
    public String findEmailOk(@RequestParam("counselorPhoneNumber") String counselorPhoneNumber, Model model) {
        CounselorDTO counselor = counselorService.findEmailByPhone(counselorPhoneNumber);
        model.addAttribute("counselorEmail", counselor.getCounselorEmail());
        String[] word = counselor.getCreatedDate().split(" ");
        model.addAttribute("createdDate", word[0]);
        return "counselor/find-email-ok";
    }

    //    비밀번호 찾기
    @GetMapping("find-password")
    public String goToFindPassword() {
        return "counselor/find-password";
    }

    //    이메일 확인 안내
    @GetMapping("find-confirm")
    public String goToConfirm() {
        return "counselor/find-confirm";
    }

    //    새 비밀번호 변경
    @GetMapping("new-password")
    public String goToNewPassword(){
        return "counselor/new-password";
    }
}
