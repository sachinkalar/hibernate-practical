package in.co.rays.test;

import static org.junit.Assert.fail;

import org.junit.Test;

import in.co.rays.dto.UserDTO;
import in.co.rays.model.UserModel;


 
public class TestFail {
	
	
	@Test
	public void testAdd() throws Exception{
		
		UserDTO dto = new UserDTO();
		
		dto.setId(10);
		dto.setFirstName("sourabh");
		dto.setLastname("rajput");
		
		UserModel model = new UserModel();
		
		model.add(dto);
		dto = model.findByPk(6);
		
		if(dto==null) {
			fail("rescord not add");
		}
		
	}

}
