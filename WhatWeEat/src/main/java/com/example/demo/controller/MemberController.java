package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.MemberDao;
import com.example.demo.model.Member;
import com.example.demo.service.MemberService;

@RestController
@CrossOrigin(origins = "*")

public class MemberController {

    @Autowired
    private MemberDao dao;
    @Autowired
    private MemberService service;

    // 註冊資料加入資料庫
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody Member member) {
        System.out.println("Received data: " + member);
        String result = service.addmember(member);
        System.out.println("Result from service: " + result);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @GetMapping("/getAllUser")
    public List<Member> getMembers() {
        return dao.findAll();
    }

    // 更新資料
    @PostMapping("/userupdate")
    public String updateData(@RequestBody Member member, HttpSession session) {
        session.setAttribute("Member", member);
        return service.UpdateData(member);
    }

    // 刪除Member
    @DeleteMapping("/delete/{id}")
    public String deleteMember(@PathVariable int id) {
        dao.deleteById(id);
        return "刪除成功";
    }

    
}
