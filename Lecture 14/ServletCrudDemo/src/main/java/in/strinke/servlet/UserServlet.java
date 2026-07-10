package in.strinke.servlet;


import in.strinke.model.User;
import in.strinke.service.UserService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

    UserService userService = new UserService();

    @Override
    public void doPost(HttpServletRequest request,
                        HttpServletResponse response) throws IOException {
        Integer id  = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");

        if(id==null || name==null || email==null || mobile==null){
            response.setStatus(400);
            response.setContentType("application/json");
            response.getWriter().write(
                    "{\n" +
                            "    \"message\" : \"Some fields are missing\"\n" +
                            "}"
            );

        }
        User user = new User(id, name, email, mobile);
        User createdUser = userService.createUser(user);

        response.setStatus(201);
        response.setContentType("application/json");
        response.getWriter().write(
                "{\n" +
                        "    \"message\" : \"User added successfully\"\n" +
                        "}"
        );
    }

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {

        String idParam = request.getParameter("id");
        if(idParam==null){
            List<User> users = userService.getAll();
            response.setStatus(200);
            response.setContentType("application/json");
            response.getWriter().write(usersToJson(users));
            return;
        }
        Integer id = Integer.parseInt(idParam);
        User userResp = userService.getUserById(id);

        if(userResp==null) {

            response.setStatus(404);
            response.setContentType("application/json");
        }

        response.setStatus(200);
        response.setContentType("application/json");
        response.getWriter().write(userToJson(userResp));

    }




    @Override
    public void doPut(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        User userRes = userService.updateUser(id, (User) request);
        if(userRes==null){
            response.setStatus(404);
            response.setContentType("application/json");
        }

        response.setStatus(200);
        response.setContentType("application/json");
        response.getWriter().write(userToJson(userRes));

    }

    @Override
    public void doDelete(HttpServletRequest request,
                         HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String resp = userService.deleteUser(id);
        if(resp==null){
            response.setStatus(404);
            response.setContentType("application/json");
        }

        response.setStatus(200);
        response.setContentType("application/json");
        response.getWriter().write(
                "{\n" +
                        "    \"message\" : \"User Delete successfully\"\n" +
                        "}"
        );


    }





    private String userToJson(User user){
        return "{\n" +
                "    \"id\" : "+user.getId()+",\n" +
                "    \"name\" : "+user.getName()+",\n" +
                "    \"email\" : "+user.getEmail()+",\n" +
                "    \"mobile\" : "+user.getMobile()+"\n" +
                "}";
    }

    private String usersToJson(List<User> users){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i<users.size(); i++){
            sb.append(userToJson(users.get(i)));
            if(i!=users.size()-1) sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }
}
