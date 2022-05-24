package com.my.test.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.test.dao.DocDao;
import com.my.test.dao.UserDao;
import com.my.test.vo.Doc;
import com.my.test.vo.User;

@Controller
public class HomeController {
	@Resource(name="UserDao")
	private UserDao userDao;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping(value = "/getOneUser", method = RequestMethod.GET)
	public @ResponseBody User getOneUser(
			@RequestParam(value="idx") int user_idx
			) {
		User user = userDao.getOneUser(user_idx);	
		
		return user;
	}
	
	
	@RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
	public @ResponseBody List<User> getAllUser(
			) {
		
		List<User> userList = userDao.getAllUser();
		
		
		return userList;
	}
	
	
	@RequestMapping(value="/insertUser", method = RequestMethod.GET)
	public @ResponseBody String insertUser(
			@RequestParam(value="id") String id,
			@RequestParam(value="pw") String pw,
			@RequestParam(value="nick") String nickname,
			@RequestParam(value="gen") String gender
			
			) {
		
		User user = new User();
		user.setUser_id(id);
		user.setUser_pw(pw);
		user.setUser_name(nickname);
		
		userDao.insertUser(user);
		
		return "insertUser ok";
		
	}
	
	
		@RequestMapping(value="/updateUser", method=RequestMethod.GET)
		public @ResponseBody String updateUser(
				@RequestParam(value="idx") int user_idx,
				@RequestParam(value="id") String id,
				@RequestParam(value="pw") String pw,
				@RequestParam(value="nick") String nickname,
				@RequestParam(value="gen") String gender
				) {
			User user = new User();
			user.setUser_idx(user_idx);
			user.setUser_id(id);
			user.setUser_pw(pw);
			user.setUser_name(nickname);
			
			userDao.updateUser(user);
			
			return "Update Success";
		}
		
		@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
		public @ResponseBody String deleteUser(
				@RequestParam(value="idx") int user_idx
				) {
			
			userDao.deleteUser(user_idx);
			
			return "ok";
		}
		
		@RequestMapping(value = "/loginUser", method = RequestMethod.GET)
		public @ResponseBody User loginUser(
				@RequestParam(value = "id")String id,
				@RequestParam(value = "pw")String pw
				) {
			User user = new User();
			user.setUser_id(id);
			user.setUser_pw(pw);
			
			User me = userDao.getUserByIdAndPw(user);
			return me;
		}
		
		/////////////////////////////////////////////////////////////////////////////
		@Resource(name="DocDao")
		private DocDao docDao;
		
		@RequestMapping(value="/insertDoc", method = RequestMethod.GET)
		public @ResponseBody String insertDoc(
				@RequestParam(value="tit") String tit,
				@RequestParam(value="writ") String writ,
				@RequestParam(value="cont") String cont
				) {
			
			Doc doc = new Doc();
			
			doc.setDoc_tit(tit);
			doc.setDoc_writ(writ);
			doc.setDoc_cont(cont);
			
			docDao.insertDoc(doc);
			return "insert Document success";
			
		}
		
		@RequestMapping(value = "/getAllDoc", method = RequestMethod.GET)
		public @ResponseBody List<Doc> getAllDoc(
				) {
			
			List<Doc> docList = docDao.getAllDoc();
			
			
			return docList;
		}
		
}