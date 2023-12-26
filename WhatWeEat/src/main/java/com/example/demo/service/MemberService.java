package com.example.demo.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MemberDao;
import com.example.demo.model.Member;

@Service
public class MemberService {

	@Autowired
	private MemberDao dao;

	// 判斷資料有無重複
	public Boolean queryDataExisted(Member member) {
		boolean usernameExist = dao.existsByUsername(member.getUsername());
		boolean nameExist = dao.existsByName(member.getName());
		if (usernameExist || nameExist) {
			return true;
		}
		return false;
	}

	// 註冊管理員資料加入資料庫
	public String addmember(Member member) {
		boolean b = queryDataExisted(member);
		if (b) {
			return "會員資料重複，新增失敗";
		} else {
			dao.save(member);
			return "會員資料新增成功";
		}
	}

	public String getByUsernameAndPassword(HttpSession session, String username, String password) {
		Member member = dao.findByUsernameAndPassword(username, password);
		if (member != null) {
			session.setAttribute("Member", member);
			return "登入成功";
		}
		return "查無會員";
	}

	// 更新資料暫時沒用到
	public String UpdateData(Member member) {
		System.out.println(member.toString());
		dao.save(member);
		return "密碼修改成功";
	}

}
