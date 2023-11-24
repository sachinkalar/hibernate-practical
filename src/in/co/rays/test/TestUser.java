package in.co.rays.test;

import in.co.rays.dto.UserDTO;
import in.co.rays.model.UserModel;

public class TestUser {
	
	public static void main(String[] args) {
		
	   //testAdd();
		//testUpdate();
		testSearch();
		//testAuthenticate();
	}

	private static void testAuthenticate() {
		
		UserDTO dto = new UserDTO();
		
		
		UserModel model = new UserModel();
      dto =	model.authenticate("reema@gmail.com", "1234");
		
		System.out.println(dto.getFirstName());
		System.out.println(dto.getLastname());
		
	}

	private static void testSearch() {
		
		UserDTO dto = new UserDTO();
		dto.setFirstName("seema");;
		
		UserModel model = new UserModel();
		
		model.search(dto,1,3);
		
		System.out.println(dto.getFirstName());
		System.out.println(dto.getLastname());
		System.out.println(dto.getLoginId());
		
	}

	private static void testUpdate() {
     
		UserDTO dto = new UserDTO();
		
		
		dto.setId(2);
		dto.setFirstName("sachin");
		
		UserModel model = new UserModel();
		model.update(dto);
		
	}

	private static void testAdd() {
		
		UserDTO dto = new UserDTO();
		
		dto.setId(5);
		dto.setFirstName("sourabh");
		dto.setLastname("rajput");
		dto.setLoginId("naman@gmail.com");
		dto.setPassword("1234");
		dto.setAddress("indoere");
		
		UserModel model = new UserModel();
		
		model.add(dto);
		
	}

}
