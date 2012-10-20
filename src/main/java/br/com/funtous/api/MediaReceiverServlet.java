package br.com.funtous.api;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import br.com.funtous.entities.Media;
import br.com.funtous.entities.MediaType;
import br.com.funtous.entities.User;
import br.com.funtous.services.MediaService;
import br.com.funtous.services.UserService;

/**
 * Servlet implementation class MediaReceiverServlet
 */
public class MediaReceiverServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8293322951756752082L;
	
	@Autowired
	private MediaService mediaService;
	@Autowired
	private UserService userService;
    
    public MediaReceiverServlet() {
        super();
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    	super.init(config);
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	@SuppressWarnings("unchecked")
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean isMultiPart = ServletFileUpload.isMultipartContent(request);
		if (isMultiPart) {
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			try {
				List<FileItem> items = upload.parseRequest(request);
				User user = userService.searchById(1L);
				Media media = new Media();
				media.setCreatedDate(Calendar.getInstance().getTime());
				media.setType(MediaType.POTHO);
				media.setUser(user);
				media.setData(items.get(0).get());
				mediaService.save(media);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
