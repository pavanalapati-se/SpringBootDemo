//package com.epam.controller;
//
//import static org.hamcrest.CoreMatchers.allOf;
//import static org.hamcrest.CoreMatchers.hasItem;
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.Matchers.hasProperty;
//import static org.hamcrest.Matchers.hasSize;
//import static org.junit.jupiter.api.Assertions.fail;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.verifyNoInteractions;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//
//import com.epam.dto.CourseDto;
//import com.epam.service.CourseService;
//
////@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
////@AutoConfigureMockMvc
//@ExtendWith(SpringExtension.class)
//@WebMvcTest(controllers = CourseController.class)
//class CourseControllerTest {
//
//	@Autowired
//	MockMvc mockMvc;
//
//	@MockBean
//	private CourseService courseService;
//
//	@BeforeEach
//	void setUp() throws Exception {
//	}
//
//	@AfterEach
//	void tearDown() throws Exception {
//	}
//
//	@Test
//	void testLoadCoursesPage() throws Exception {
//		List<CourseDto> courses = new ArrayList<>();
//
//		CourseDto c1 = new CourseDto();
//		c1.setCourseId(1000);
//		c1.setCourseName("Spring MVC");
//		c1.setCourseDuration("16 hours");
//
//		CourseDto c2 = new CourseDto();
//		c2.setCourseId(1001);
//		c2.setCourseName("Spring");
//		c2.setCourseDuration("8 hours");
//
//		courses.add(c1);
//		courses.add(c2);
//
//		when(courseService.getAllCourses()).thenReturn(courses);
//
//		mockMvc.perform(get("/loadcourses")).andExpect(status().isOk()).andExpect(view().name("viewCourses"))
//				.andExpect(model().attribute("courses", hasSize(2)))
//				.andExpect(model().attribute("courses", hasItem(allOf(hasProperty("courseId", is(1000)),
//						hasProperty("courseName", is("Spring MVC")), hasProperty("courseDuration", is("16 hours"))))));
//
//		verify(courseService, times(1)).getAllCourses();
//	}
//
//	@Test
//	@Disabled
//	void testLoadAddCoursePage() {
//		fail("Not yet implemented");
//	}
//
//	
//	@Test
//
//	void testAddCourseWithValidData() throws Exception {
//
//		CourseDto c1 = new CourseDto();
//		c1.setCourseId(1000);
//		c1.setCourseName("Spring MVC");
//		c1.setCourseDuration("16 hours");
//
//		when(courseService.createCourse(c1)).thenReturn(c1);
//
//		mockMvc.perform(post("/addcourse").param("courseId", "1000").param("courseName", "Spring MVC")
//				.param("courseDuration", "16 hours")).andExpect(status().isOk()).andExpect(view().name("success"));
//
//		verify(courseService, times(1)).createCourse(any());
//	}
//
//	@Test
//	void testAddCourseWithCourseDurationAsABlank() throws Exception {
//
//		CourseDto c1 = new CourseDto();
//		c1.setCourseId(1000);
//		c1.setCourseName("Spring MVC");
//		c1.setCourseDuration("");
//
//		mockMvc.perform(post("/addcourse").param("courseId", "1000").param("courseName", "Spring MVC")
//				.param("courseDuration", "")).andExpect(status().isOk()).andExpect(view().name("addCourse"))
//		.andExpect(model().attributeHasFieldErrors("courseDto", "courseDuration"));
//		
//		verifyNoInteractions(courseService);
//	}
//	
//	@Test
//	void testAddCourseWithCourseNameAsABlank() throws Exception {
//	
//		mockMvc.perform(post("/addcourse").param("courseId", "1000").param("courseName", "")
//				.param("courseDuration", "16 Hours")).andExpect(status().isOk()).andExpect(view().name("addCourse"))
//		.andExpect(model().attributeHasFieldErrors("courseDto", "courseName"));
//		
//		verifyNoInteractions(courseService);
//	}
//	
//	@Test
//	void testAddCourseWithCourseNameForSizeValidation() throws Exception {
//	
//		mockMvc.perform(post("/addcourse").param("courseId", "1000").param("courseName", "HT")
//				.param("courseDuration", "16 Hours")).andExpect(status().isOk()).andExpect(view().name("addCourse"))
//		.andExpect(model().attributeHasFieldErrors("courseDto", "courseName"));
//		
//		verifyNoInteractions(courseService);
//	}
//
//	@Test
//	@Disabled
//	void testLoadCourseBasedOnId() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	@Disabled
//	void testLoadDeleteCourse() {
//		fail("Not yet implemented");
//	}
//
//}
