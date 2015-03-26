package ie.cit.adf.web;

import static org.junit.Assert.*;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;

public class ContentControllerTest {

	private ContentController tested;
	private ExtendedModelMap model;
	
	@Before
	public void setup(){
		tested = new ContentController();
		model = new ExtendedModelMap();
	}
	
	//test that the correct view is being returned from the method.
	@Test
	public void content() throws Exception{
		String view = tested.content(model);
		assertThat(view, CoreMatchers.equalTo("content"));
		
	}

}
