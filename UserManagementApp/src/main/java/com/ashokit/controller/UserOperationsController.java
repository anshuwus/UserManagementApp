package com.ashokit.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ashokit.binding.LoginForm;
import com.ashokit.binding.RegistrationForm;
import com.ashokit.binding.UnlockForm;
import com.ashokit.service.IUserMgmtService;

@Controller
public class UserOperationsController {
	@Autowired
	private IUserMgmtService userService;
	
	private Integer stateId;
	private Integer cityId;
	
	@GetMapping("/")
	public String displaySignIn(@ModelAttribute("signIn")LoginForm form) {
		System.out.println("UserOperationsController.displaySignIn()");
		return "signInPage";
	}
	
	@PostMapping("/")
	public String signIn(@ModelAttribute("signIn")LoginForm form,RedirectAttributes attr) {
		System.out.println("UserOperationsController.signIn()"+form);
		String status=userService.login(form);
		if(status.contains("success")) {
			return "dashboard";
		}
		else
			attr.addFlashAttribute("errMsg", status);
		return "redirect:";
	}
	
	@GetMapping("/signUp")
	public String displaySignUp(@ModelAttribute("user")RegistrationForm form , Model model) {
		Map<Integer, String> Countrymap = userService.getCountryIdAndName();
		model.addAttribute("counMap", Countrymap);
		return "signUpPage";
	}
	
	@PostMapping("/signUp")
	public String registerForm(@ModelAttribute("user")RegistrationForm form,RedirectAttributes attr) {
		System.out.println("UserOperationsController.registerForm()"+form);
		System.out.println("stateId: "+stateId);
		System.out.println("cityId: "+cityId);
		String msg="";
		String result=userService.insertFormData(form,stateId,cityId);
		if(result.equals("success")) {
			msg="Please check your email to unlock your account";
		}
		else
			msg="Something went wrong, please try again";
		attr.addFlashAttribute("msg", msg);
		return "redirect:signUp";
	}
	
	@GetMapping("/unlock")
	public String unlockAccount(@ModelAttribute("unlockForm")UnlockForm form, @RequestParam(name="email")String email,Model model) {
		System.out.println("UserOperationsController.unlockAccount()"+email);
		model.addAttribute("email", email);
		return "unlockAccountPage";
	}
	
	@PostMapping("/unlock")
	public String unlockAccountProcess(@ModelAttribute("unlockForm")UnlockForm form, RedirectAttributes attr) {
		System.out.println("UserOperationsController.unlockAccountProcess()"+form);
		attr.addAttribute("email", form.getEmail());
		String msg="";
	    if(form.getNewPwd().equals(form.getPwd())) {
			String result=userService.unlockUserAccount(form);
			if(result.equals("success")) {
				msg="Account unlocked, please proceed with login.";
			}
			else if(result.equals("error"))
				msg="Please enter correct temporary password, sent to your email";
			else
				msg="Your account is already unlock";
		}
		else {
			msg="Your new password not matching with confirmed password";
		}
		attr.addFlashAttribute("msg", msg);
		return "redirect:unlock";
	}
	
	@GetMapping("/forgotPwd")
	public String forgotPwd() {
		return "forgotPwdPage";
	}
	
	@PostMapping("/forgotPwd")
	public String forgotPwdProcess(@RequestParam("email")String email,RedirectAttributes attr) {
		System.out.println("UserOperationsController.forgotPwdProcess()"+email);
		String status=userService.recoverPwd(email);
		if(status.contains("success")) {
			attr.addFlashAttribute("succMsg","Your current password is sent on your registered email id.");
		}else
			attr.addFlashAttribute("errMsg", status);
		return "redirect:forgotPwd";
	}
	
	@GetMapping("/checkEmail")
	@ResponseBody
	public String checkEmail(@RequestParam("email")String email) {
		System.out.println("UserOperationsController.checkEmail()"+email);
		String message=""; //name not exist
		if(userService.isEmailExist(email))
			message="Email already registered";
		return message;
	}
	
	@GetMapping("/stateDropdown")
	public String stateDropdown(@RequestParam("counId")Integer counId,Model model) {
		System.out.println("UserOperationsController.stateDropdown()"+counId);
		Map<Integer, String> stateMap = userService.getStateIdAndNameBasedOnCountryId(counId);
		model.addAttribute("stateMap", stateMap);
		return "stateDropdown";
	}
	
	@GetMapping("/cityDropdown")
	public String cityDropdown(@RequestParam("stateId")Integer stateId,Model model) {
		System.out.println("UserOperationsController.cityDropdown()"+stateId);
		this.stateId=stateId;
		Map<Integer, String> cityMap = userService.getCityIdAndNameBasedOnStateId(stateId);
		model.addAttribute("cityMap", cityMap);
		return "cityDropdown";
	}
	
	@GetMapping("/cityId")
	@ResponseBody
	public void cityId(@RequestParam("cityId")Integer cityId) {
		System.out.println("UserOperationsController.cityId()"+cityId);
		this.cityId=cityId;
	}

}
