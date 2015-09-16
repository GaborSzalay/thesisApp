package com.university.thesisapp.teacher.controller;

import com.google.common.primitives.Longs;
import com.university.thesisapp.dao.persistence.dao.StudentRequestDao;
import com.university.thesisapp.dao.persistence.dao.ThesisDao;
import com.university.thesisapp.dao.persistence.dao.ThesisStudentDao;
import com.university.thesisapp.dao.persistence.dao.ThesisTeacherDao;
import com.university.thesisapp.dao.persistence.model.StudentRequest;
import com.university.thesisapp.dao.persistence.model.StudentRequestState;
import com.university.thesisapp.dao.persistence.model.Thesis;
import com.university.thesisapp.dao.persistence.provider.ThesisUserProvider;
import com.university.thesisapp.teacher.context.Positions;
import com.university.thesisapp.teacher.context.PositionsFactory;
import com.university.thesisapp.teacher.context.TeacherMenuContext;
import com.university.thesisapp.teacher.context.TeacherMenuContextFactory;
import com.university.thesisapp.web.provider.UrlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Gábor on 2015.09.16..
 */
@Controller
public class JoinInRequestController {
    @Autowired
    StudentRequestDao studentRequestDao;
    @Autowired
    ThesisTeacherDao thesisTeacherDao;
    @Autowired
    ThesisUserProvider thesisUserProvider;
    @Autowired
    TeacherMenuContextFactory teacherMenuContextFactory;
    @Autowired
    PositionsFactory positionsFactory;
    @Autowired
    ThesisDao thesisDao;
    @Autowired
    ThesisStudentDao thesisStudentDao;
    @Autowired
    JoinInRequestControllerViewResolver joinInRequestControllerViewResolver;
    @Autowired
    JoinInRequestControllerActiveMenuDecider joinInRequestControllerActiveMenuDecider;

    @RequestMapping(value = UrlProvider.TEACHER_REQUESTS_URL, method = RequestMethod.GET)
    public ModelAndView showRequests(Model model, HttpServletRequest request) {
        long teacherId = thesisTeacherDao.getThesisTeacherByThesisUser(thesisUserProvider.getSignedInUser()).getThesisTeacherId();
        List<StudentRequest> studentRequestsByTeacherId = studentRequestDao.getSentStudentRequestsByTeacherId(teacherId);
        Map<Long, Positions> studentPositions = new HashMap<Long, Positions>();
        for (StudentRequest studentRequest : studentRequestsByTeacherId) {
            Thesis thesis = studentRequest.getThesis();
            studentPositions.put(thesis.getThesisId(), positionsFactory.createPositions(thesis));
        }

        TeacherMenuContext teacherMenuContext = teacherMenuContextFactory.create();
        joinInRequestControllerActiveMenuDecider.provideActiveMenu(request);
        model.addAttribute("menu", teacherMenuContext);
        model.addAttribute("studentRequests", studentRequestsByTeacherId);
        model.addAttribute("studentPositions", studentPositions);
        return new ModelAndView("teacher/requests", model.asMap());
    }

    @RequestMapping(value = UrlProvider.TEACHER_DECLINED_REQUESTS_URL, method = RequestMethod.GET)
    public ModelAndView showDeclinedRequests(Model model, HttpServletRequest request) {
        long teacherId = thesisTeacherDao.getThesisTeacherByThesisUser(thesisUserProvider.getSignedInUser()).getThesisTeacherId();
        List<StudentRequest> studentRequestsByTeacherId = studentRequestDao.getDeclinedStudentRequestsByTeacherId(teacherId);
        Map<Long, Positions> studentPositions = new HashMap<Long, Positions>();
        for (StudentRequest studentRequest : studentRequestsByTeacherId) {
            Thesis thesis = studentRequest.getThesis();
            studentPositions.put(thesis.getThesisId(), positionsFactory.createPositions(thesis));
        }

        TeacherMenuContext teacherMenuContext = teacherMenuContextFactory.create();
        joinInRequestControllerActiveMenuDecider.provideActiveMenu(request);
        model.addAttribute("menu", teacherMenuContext);
        model.addAttribute("studentRequests", studentRequestsByTeacherId);
        model.addAttribute("studentPositions", studentPositions);
        return new ModelAndView("teacher/requests", model.asMap());
    }

    @RequestMapping(value = UrlProvider.TEACHER_ACCEPT_REQUEST_URL, method = RequestMethod.GET)
    public ModelAndView acceptRequest(Model model, HttpServletRequest request) {
        long teacherId = thesisTeacherDao.getThesisTeacherByThesisUser(thesisUserProvider.getSignedInUser()).getThesisTeacherId();
        String studentRequestParameter = request.getParameter("student-request");
        StudentRequest studentRequest = studentRequestDao.findById(Longs.tryParse(studentRequestParameter));
        if (studentRequest.getThesis().getThesisTeacher().getThesisTeacherId().equals(teacherId)) {
            thesisStudentDao.registerThesis(studentRequest.getThesisStudent().getThesisStudentId(), studentRequest.getThesis().getThesisId());
            studentRequestDao.setState(studentRequest.getStudentRequestId(), StudentRequestState.ACCEPTED);
        }
        return joinInRequestControllerViewResolver.resolveView(request, model);
    }

    @RequestMapping(value = UrlProvider.TEACHER_DECLINE_REQUEST_URL, method = RequestMethod.GET)
    public ModelAndView declineRequest(Model model, HttpServletRequest request) {
        long teacherId = thesisTeacherDao.getThesisTeacherByThesisUser(thesisUserProvider.getSignedInUser()).getThesisTeacherId();
        String studentRequestParameter = request.getParameter("student-request");
        StudentRequest studentRequest = studentRequestDao.findById(Longs.tryParse(studentRequestParameter));
        if (studentRequest.getThesis().getThesisTeacher().getThesisTeacherId().equals(teacherId)) {
            studentRequestDao.setState(studentRequest.getStudentRequestId(), StudentRequestState.DECLINED);
        }
        return joinInRequestControllerViewResolver.resolveView(request, model);
    }

    @RequestMapping(value = UrlProvider.TEACHER_ENABLE_REQUEST_URL, method = RequestMethod.GET)
    public ModelAndView enableRequest(Model model, HttpServletRequest request) {
        long teacherId = thesisTeacherDao.getThesisTeacherByThesisUser(thesisUserProvider.getSignedInUser()).getThesisTeacherId();
        String studentRequestParameter = request.getParameter("student-request");
        StudentRequest studentRequest = studentRequestDao.findById(Longs.tryParse(studentRequestParameter));
        if (studentRequest.getThesis().getThesisTeacher().getThesisTeacherId().equals(teacherId)) {
            studentRequestDao.setState(studentRequest.getStudentRequestId(), StudentRequestState.NEW);
        }
        return joinInRequestControllerViewResolver.resolveView(request, model);
    }
}
