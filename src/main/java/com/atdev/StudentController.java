package com.atdev;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.atdev.Bean.StudentModel;
import com.atdev.Dao.StudentDao;

@Controller
public class StudentController {
	
	@RequestMapping("/add")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {

		int sno = Integer.parseInt(request.getParameter("studNo"));
		String name = request.getParameter("studName");
		Date dob = null;
		Date doj = null;
		try {
			dob = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("studDOB"));
			doj = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("studDOJ"));
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		System.out.println(sno+"\n"+name+"\n"+dob+"\n"+doj);
		
		StudentModel sm = new StudentModel(sno, name, dob, doj);
		boolean status = new StudentDao().insertStudent(sm);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addStudent.jsp");
		mv.addObject("status", status);
		mv.addObject("sno", sm.getSno());
		mv.addObject("sname", sm.getName());
		mv.addObject("dob", sm.getDob());
		mv.addObject("doj", sm.getDoj());
		
		return mv;
	}
	
	@RequestMapping("/update")
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) {

		int sno = Integer.parseInt(request.getParameter("studNo"));
		String name = request.getParameter("studName");
		Date dob = null;
		Date doj = null;
		try {
			dob = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("studDOB"));
			doj = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("studDOJ"));
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		System.out.println(sno+"\n"+name+"\n"+dob+"\n"+doj);
		
		StudentModel sm = new StudentModel(sno, name, dob, doj);
		boolean status = new StudentDao().updateStudent(sm);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("viewAllStudent.jsp");
		mv.addObject("editstatus", status);
		
		return mv;
	}
	@RequestMapping("/delete")
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) {

		int sno = Integer.parseInt(request.getParameter("sno"));
		
		boolean status = new StudentDao().deleteStudent(sno);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("viewAllStudent.jsp");
		mv.addObject("deletestatus", status);
		
		return mv;
	}
	@RequestMapping("/search")
	public ModelAndView search(HttpServletRequest request, HttpServletResponse response) {

		int sno = Integer.parseInt(request.getParameter("studNo"));
		
		//boolean status = new StudentDao().deleteStudent(sno);
		StudentModel sm = StudentDao.searchStudent(sno);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("viewAllStudent.jsp");
		if(sm != null)
		{
			mv.addObject("searchstatus", true);
			mv.addObject("sno", sm.getSno());
			mv.addObject("sname", sm.getName());
			mv.addObject("dob", sm.getDob());
			mv.addObject("doj", sm.getDoj());
		}else {
			mv.addObject("searchstatus", false);
		}
		
		return mv;
	}
}
