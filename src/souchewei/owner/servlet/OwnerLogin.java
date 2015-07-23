package souchewei.owner.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import souchewei.owner.model.ParkingPlaceOwner;
import souchewei.owner.service.ParkingPlaceOwnerService;

@WebServlet("/owner/login.api")
@Controller
@Scope("prototype")
public class OwnerLogin extends HttpServlet {

	private static final String OPEN_ID = "openId";
	private static final String SUCCESS_URL = "/views/success.jsp";
	private static final String REGISTER_URL = "/views/register.jsp";
	private static final String USER = "user";

	private ParkingPlaceOwnerService parkingPlaceOwnerService;
	@Override
	public void init() throws ServletException {
		super.init();

		ServletContext servletContext = this.getServletContext();
		//获取context
		WebApplicationContext ctx = WebApplicationContextUtils
				.getWebApplicationContext(servletContext);
		//注入bean
		parkingPlaceOwnerService = (ParkingPlaceOwnerService) ctx
				.getBean("parkingPlaceOwnerService");
	}



	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String openId = req.getParameter(OPEN_ID);
		System.out.println(parkingPlaceOwnerService);
		ParkingPlaceOwner owner = parkingPlaceOwnerService.findByOpenId(openId);
		// 如果用户存在，登录成功，保存session
		if (owner != null) {
			// session中保存
			req.getSession().setAttribute(USER, owner);
			// 跳转到 业主登录成功页面
			resp.sendRedirect(SUCCESS_URL);
		} else {
			// 重定向到注册页面
			req.getRequestDispatcher(REGISTER_URL).forward(req, resp);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

}
