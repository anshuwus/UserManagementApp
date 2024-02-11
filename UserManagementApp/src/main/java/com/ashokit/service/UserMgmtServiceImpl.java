package com.ashokit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.binding.LoginForm;
import com.ashokit.binding.RegistrationForm;
import com.ashokit.binding.UnlockForm;
import com.ashokit.entity.City;
import com.ashokit.entity.Country;
import com.ashokit.entity.State;
import com.ashokit.entity.User;
import com.ashokit.repository.ICityRepository;
import com.ashokit.repository.ICountryRepository;
import com.ashokit.repository.IStateRepository;
import com.ashokit.repository.IUserRepository;
import com.ashokit.utils.EmailUtils;
import com.ashokit.utils.MyCollection;
import com.ashokit.utils.PwdUtils;

@Service
public class UserMgmtServiceImpl implements IUserMgmtService {
	@Autowired
	private IUserRepository userRepo;
	@Autowired
	private ICountryRepository countryRepo;
	@Autowired
	private IStateRepository stateRepo;
	@Autowired
	private ICityRepository cityRepo;
	@Autowired
	private EmailUtils email;

	@Override
	public Map<Integer, String> getCountryIdAndName() {
		List<Object[]> list = countryRepo.getCountryIdAndName();
		return MyCollection.convertListToMap(list);
	}

	@Override
	public boolean isEmailExist(String email) {
		return userRepo.getEmailCount(email) > 0;
	}

	@Override
	public Map<Integer, String> getStateIdAndNameBasedOnCountryId(Integer counId) {
		List<Country> list = countryRepo.findAll();
		List<State> stateList = new ArrayList<State>();
		list.forEach(country -> {
			if (country.getCountryId().equals(counId)) {
				List<State> list1 = country.getState();
				for (State s : list1)
					stateList.add(s);
			}
			;// if
		});

		return MyCollection.convertListToMap2(stateList);
	}

	@Override
	public Map<Integer, String> getCityIdAndNameBasedOnStateId(Integer stateId) {
		List<State> list = stateRepo.findAll();
		List<City> cityList = new ArrayList<City>();
		list.forEach(state -> {
			if (state.getStateId().equals(stateId)) {
				List<City> city = state.getCity();
				for (City c : city)
					cityList.add(c);
			}
		});
		return MyCollection.convertListToMap3(cityList);
	}

	@Override
	public String insertFormData(RegistrationForm form, Integer stateId, Integer cityId) {
		Optional<State> opt = stateRepo.findById(stateId);
		Optional<City> opt2 = cityRepo.findById(cityId);
		String msg = "";
		if (opt.isPresent() && opt2.isPresent()) {
			State state = opt.get();
			City city = opt2.get();
			form.setState(state);
			form.setCity(city);
			User entity = new User();
			BeanUtils.copyProperties(form, entity);
			// generate random pwd for user
			entity.setPwd(PwdUtils.generatePwd());
			// set account status as LOCKED
			entity.setStatus("LOCKED");
			userRepo.save(entity);
			String userEmail = entity.getEmail();
			String subject = "Unlock User Account";
			StringBuffer body = new StringBuffer("");
			body.append("<p>Hi, " + entity.getFirstName() + " " + entity.getLastName()
					+ "</p> <p>Welcome to IES family, Your registration is almost complete.</p><p>Please unlock your account using below details.</p><p>Temporary Password : "
					+ entity.getPwd() + "</p>");
			body.append("<a href=\"http://localhost:8081/unlock?email=" + userEmail + "\">Link to unlock account</a>");
			boolean flag = email.sendEmail(userEmail, subject, body);
			if (flag) {
				msg = "success";
			}
		}
		return msg;
	}

	@Override
	public String unlockUserAccount(UnlockForm form) {
		User user = userRepo.getUserAccount(form.getEmail());
		String msg = "";
		if (user.getStatus().equals("LOCKED")) {
			if (form.getTempPwd().equals(user.getPwd())) {
				user.setStatus("UNLOCK");
				user.setPwd(form.getPwd());
				userRepo.save(user);
				msg = "success";
			}else
				msg="error";
		}

		return msg;
	}

	@Override
	public String recoverPwd(String email) {
		User user = userRepo.getUserAccount(email);
		String status="";
		if(user==null) {
			return "Your email id is not registered";
		}
		if(user.getStatus().equals("LOCKED")) {
			return "Please unlock your account";
		}
		if(user.getEmail().equals(email)) {
			String pwd = user.getPwd();
			String subject="Recover Your Password";
			StringBuffer body= new StringBuffer("");
			body.append("<h1>Please recover your password</h1>");
			body.append("<p>Hi, "+user.getFirstName()+"</p><p> Below is your recovered password.</p>");
			body.append("<p>Your Password:"+pwd+"</p>");
			body.append("<a href=\"http://localhost:8081/\">click here to login into your account</a>");
			boolean isSent = this.email.sendEmail(email, subject, body);
			if(isSent)
				status="success";
		}
		return status;
	}

	@Override
	public String login(LoginForm form) {
		User user = userRepo.getUserAccount(form.getEmail());
		String status="";
		if(user==null) {
			return "Email not registered";
		}
		if(form.getEmail().equals(user.getEmail())) {
			if(form.getPwd().equals(user.getPwd())) {
				status="success";
			}
			else
				status="Invalid Credentials";
		}
		return status;
	}

}
