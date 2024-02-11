package com.ashokit.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ashokit.entity.City;
import com.ashokit.entity.Country;
import com.ashokit.entity.State;
import com.ashokit.repository.ICityRepository;
import com.ashokit.repository.ICountryRepository;
import com.ashokit.repository.IStateRepository;

//@Component
public class StaticDataLoader implements CommandLineRunner {

	@Autowired
	private ICityRepository cityRepo;
	@Autowired
	private ICountryRepository countryRepo;
	@Autowired
	private IStateRepository stateRepo;

	@Override
	public void run(String... args) throws Exception {

		State s1 = new State();
		s1.setStateName("Andra Pradesh");

		State s2 = new State();
		s2.setStateName("Bihar");

		State s3 = new State();
		s3.setStateName("Tamil Nadu");

		State s4 = new State();
		s4.setStateName("Jharkhand");

		State s5 = new State();
		s5.setStateName("Rajasthan");

		State s6 = new State();
		s6.setStateName("Punjab");

		State s7 = new State();
		s7.setStateName("Telangana");

		State s8 = new State();
		s8.setStateName("Uttar Pradesh");

		State s9 = new State();
		s9.setStateName("Odisha");

		// china states
		State s10 = new State();
		s10.setStateName("Anhui");

		State s11 = new State();
		s11.setStateName("Fujian");

		State s12 = new State();
		s12.setStateName("Gansu");

		State s13 = new State();
		s13.setStateName("Guangdong");

		State s14 = new State();
		s14.setStateName("Hainan");

		List<State> indiaState = Arrays.asList(s1, s2, s3, s4, s5, s6, s7, s8, s9);
		List<State> chinaState = Arrays.asList(s10, s11, s12, s13, s14);
		
		Country coun1 = new Country();
		coun1.setCountryName("India");

		Country coun2 = new Country();
		coun2.setCountryName("China");
		countryRepo.save(coun1);
		countryRepo.save(coun2);
		
		List<Country> counList = countryRepo.findAll();		
		for(Country coun : counList) {
			for(State st : indiaState) {
				if(st.getCountry()==null && coun.getCountryName().equals("India")) {
					st.setCountry(coun);				
				}
			}
		}//for
		for(Country coun : counList) {
			for(State st : chinaState) {
				if(st.getCountry()==null && coun.getCountryName().equals("China")) {
					st.setCountry(coun);				
				}
			}
		}//for
		stateRepo.saveAll(indiaState);
		stateRepo.saveAll(chinaState);

		City c1 = new City();
		c1.setCityName("Amaravati");

		City c2 = new City();
		c2.setCityName("Guntur");

		City c3 = new City();
		c3.setCityName("Nellore");

		City c4 = new City();
		c4.setCityName("Kurnool");

		City c5 = new City();
		c5.setCityName("Vijayawada");

		City c6 = new City();
		c6.setCityName("Patna");

		City c7 = new City();
		c7.setCityName("Gaya");

		City c8 = new City();
		c8.setCityName("Bhagalpur");

		City c9 = new City();
		c9.setCityName("Chennai");

		City c10 = new City();
		c10.setCityName("Coimbatore");

		City c11 = new City();
		c11.setCityName("Madurai");

		City c12 = new City();
		c12.setCityName("Tiruchirappalli");

		City c13 = new City();
		c13.setCityName("Kanyakumari");

		// Jharkhand cities name
		City c14 = new City();
		c14.setCityName("Ranchi");

		City c15 = new City();
		c15.setCityName("Jamshedpur");

		City c16 = new City();
		c16.setCityName("Dhanbad");

		City c17 = new City();
		c17.setCityName("Hazaribagh");

		City c18 = new City();
		c18.setCityName("Deoghar");

		City c19 = new City();
		c19.setCityName("Ramgarh");

		City c20 = new City();
		c20.setCityName("Jaipur");

		City c21 = new City();
		c21.setCityName("Jodhpur");

		City c22 = new City();
		c22.setCityName("Udaipur");

		City c23 = new City();
		c23.setCityName("Ajmer");

		City c24 = new City();
		c24.setCityName("Bikaner");

		City c25 = new City();
		c25.setCityName("Kota");

		City c26 = new City();
		c26.setCityName("Amritsar");

		City c27 = new City();
		c27.setCityName("Ludhiana ");

		City c28 = new City();
		c28.setCityName("Jalandhar");

		City c29 = new City();
		c29.setCityName("Patiala");

		City c30 = new City();
		c30.setCityName("Chandigarh");

		City c31 = new City();
		c31.setCityName("Hyderabad");

		City c32 = new City();
		c32.setCityName("Warangal ");

		City c33 = new City();
		c33.setCityName("Nizamabad");

		City c34 = new City();
		c34.setCityName("Ramagundam");

		City c35 = new City();
		c35.setCityName("Karimnagar");

		City c36 = new City();
		c36.setCityName("Lucknow");

		City c37 = new City();
		c37.setCityName("Kanpur ");

		City c38 = new City();
		c38.setCityName("Agra");

		City c39 = new City();
		c39.setCityName("Varanasi");

		City c40 = new City();
		c40.setCityName("Prayagraj");

		City c41 = new City();
		c41.setCityName("Meerut");

		City c42 = new City();
		c42.setCityName("Ghaziabad");

		City c43 = new City();
		c43.setCityName("Bhubaneswar ");

		City c44 = new City();
		c44.setCityName("Cuttack");

		City c45 = new City();
		c45.setCityName("Puri");

		City c46 = new City();
		c46.setCityName("Sambalpur");

		City c47 = new City();
		c47.setCityName("Brahmapur");

		//china cities
		City c48 = new City();
		c48.setCityName("Hefei");

		City c49 = new City();
		c49.setCityName("Bengbu");

		City c50 = new City();
		c50.setCityName("Huainan");

		City c51 = new City();
		c51.setCityName("Wuhu");

		City c52 = new City();
		c52.setCityName("Fuzhou");

		City c53 = new City();
		c53.setCityName("Xiamen");

		City c54 = new City();
		c54.setCityName("Quanzhou");

		City c55 = new City();
		c55.setCityName("Putian");

		City c56 = new City();
		c56.setCityName("Lanzhou");

		City c57 = new City();
		c57.setCityName("Baiyin");

		City c58 = new City();
		c58.setCityName("Tianshui");

		City c59 = new City();
		c59.setCityName("Jiayuguan");

		City c60 = new City();
		c60.setCityName("Guangzhou");

		City c61 = new City();
		c61.setCityName("Shenzhen");

		City c62 = new City();
		c62.setCityName("Dongguan");

		City c63 = new City();
		c63.setCityName("Zhongshan");

		City c64 = new City();
		c64.setCityName("Haikou");

		City c65 = new City();
		c65.setCityName("Haikou");

		City c66 = new City();
		c66.setCityName("Danzhou");

		City c67 = new City();
		c67.setCityName("Wenchang");

		List<City> andraPradeshCities = Arrays.asList(c1, c2, c3, c4, c5);
		List<City> biharCities = Arrays.asList(c6, c7, c8);
		List<City> tamilNaduCities = Arrays.asList(c9, c10, c11, c12, c13);
		List<City> jharkhandCities = Arrays.asList(c14, c15, c16, c17, c18, c19);
		List<City> rajhthanCities = Arrays.asList(c20, c21, c22, c23, c24, c25);
		List<City> punjabCities = Arrays.asList(c26, c27, c28, c29, c30);
		List<City> telanganaCities = Arrays.asList(c31, c32, c33, c34, c35);
		List<City> upCities = Arrays.asList(c36, c37, c38, c39, c40, c41, c42);
		List<City> odisaCities = Arrays.asList(c43, c44, c45, c46, c47);
		List<City> anhuiCities = Arrays.asList(c48, c49, c50, c51);
		List<City> fujianCities = Arrays.asList(c52, c53, c54, c55);
		List<City> gansuCities = Arrays.asList(c56, c57, c58, c59);
		List<City> guangCities = Arrays.asList(c60, c61, c62, c63);
		List<City> hainanCities = Arrays.asList(c64, c65, c66, c67);

		List<State> stateList = stateRepo.findAll();
		
		for(State st : stateList) {
			for(City c : andraPradeshCities) {
				if(c.getState()==null && st.getStateName().equals("Andra Pradesh")) {
					c.setState(st);
				}
			}
		}
		for(State st : stateList) {
			for(City c : biharCities) {
				if(c.getState()==null && st.getStateName().equals("Bihar")) {
					c.setState(st);
				}
			}
		}
		for(State st : stateList) {
			for(City c : tamilNaduCities) {
				if(c.getState()==null && st.getStateName().equals("Tamil Nadu")) {
					c.setState(st);
				}
			}
		}
		for(State st : stateList) {
			for(City c : jharkhandCities) {
				if(c.getState()==null && st.getStateName().equals("Jharkhand")) {
					c.setState(st);
				}
			}
		}
		for(State st : stateList) {
			for(City c : rajhthanCities) {
				if(c.getState()==null && st.getStateName().equals("Rajasthan")) {
					c.setState(st);
				}
			}
		}
		for(State st : stateList) {
			for(City c : punjabCities) {
				if(c.getState()==null && st.getStateName().equals("Punjab")) {
					c.setState(st);
				}
			}
		}
		for(State st : stateList) {
			for(City c : telanganaCities) {
				if(c.getState()==null && st.getStateName().equals("Telangana")) {
					c.setState(st);
				}
			}
		}
		for(State st : stateList) {
			for(City c : upCities) {
				if(c.getState()==null && st.getStateName().equals("Uttar Pradesh")) {
					c.setState(st);
				}
			}
		}
		for(State st : stateList) {
			for(City c : odisaCities) {
				if(c.getState()==null && st.getStateName().equals("Odisha")) {
					c.setState(st);
				}
			}
		}
		for(State st : stateList) {
			for(City c : anhuiCities) {
				if(c.getState()==null && st.getStateName().equals("Anhui")) {
					c.setState(st);
				}
			}
		}
		for(State st : stateList) {
			for(City c : fujianCities) {
				if(c.getState()==null && st.getStateName().equals("Fujian")) {
					c.setState(st);
				}
			}
		}
		for(State st : stateList) {
			for(City c : gansuCities) {
				if(c.getState()==null && st.getStateName().equals("Gansu")) {
					c.setState(st);
				}
			}
		}
		for(State st : stateList) {
			for(City c : guangCities) {
				if(c.getState()==null && st.getStateName().equals("Guangdong")) {
					c.setState(st);
				}
			}
		}
		for(State st : stateList) {
			for(City c : hainanCities) {
				if(c.getState()==null && st.getStateName().equals("Hainan")) {
					c.setState(st);
				}
			}
		}
		cityRepo.saveAll(andraPradeshCities);
		cityRepo.saveAll(biharCities);
		cityRepo.saveAll(tamilNaduCities);
		cityRepo.saveAll(jharkhandCities);
		cityRepo.saveAll(rajhthanCities);
		cityRepo.saveAll(punjabCities);
		cityRepo.saveAll(telanganaCities);
		cityRepo.saveAll(upCities);
		cityRepo.saveAll(odisaCities);

		cityRepo.saveAll(anhuiCities);
		cityRepo.saveAll(fujianCities);
		cityRepo.saveAll(gansuCities);
		cityRepo.saveAll(guangCities);
		cityRepo.saveAll(hainanCities);

	}

}
