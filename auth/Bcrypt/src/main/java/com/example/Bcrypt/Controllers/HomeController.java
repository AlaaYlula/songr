package com.example.Bcrypt.Controllers;


import com.example.Bcrypt.Model.Post;
import com.example.Bcrypt.Model.UserPost;
import com.example.Bcrypt.Repository.PostRepository;
import com.example.Bcrypt.Repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public HomeController(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    /////////////////////////////// Welcome Page ///////////////////
    @GetMapping("/hello")
    public String getHellopage(HttpServletRequest request, Model m)
    {
        return "hello.html";
    }
    /////////////////////////////////// Home Page /////////////////////
    @GetMapping("/")
    public String getHomepage(HttpServletRequest request, Model m)
    {
        HttpSession session = request.getSession();
        String username = session.getAttribute("username").toString();

        m.addAttribute("username", username);
        m.addAttribute("postsList",postRepository.findAll());

        return "home.html";
    }
    //////////////////////////////////////// LogIn ///////////////////////////////////////
    @GetMapping("/login")
    public String getLoginPage(Model model)
    {
        model.getAttribute("username");
        return "/login.html";
    }

    @PostMapping("/login")
    public RedirectView logInUser(HttpServletRequest request, String username, String password)
    {
        UserPost userFromDb = userRepository.findByusername(username);
        if ((userFromDb == null)
                || (!BCrypt.checkpw(password, userFromDb.getPassword())))
        {
            return new RedirectView("/login");
        }

        HttpSession session = request.getSession();
        session.setAttribute("username", username);

        return new RedirectView("/");
    }

    @PostMapping("/post")
    public RedirectView createNewPost(HttpServletRequest request,Post post,Model model){
        HttpSession session = request.getSession();
        String username = session.getAttribute("username").toString();

        UserPost user = userRepository.findByusername(username);

        post.setUser(user);
        postRepository.save(post);
        return new RedirectView("/");
    }
//////////////////////////////////////// Sign Up ///////////////////////////////////////
    @GetMapping("/signup")
    public String getSignupPage()
    {
        return "/signup.html";
    }

    @PostMapping("/signup")
    public RedirectView signUpUser(String username, String password)
    {
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(12));
        UserPost newChatUser = new UserPost(username, hashedPassword);

        userRepository.save(newChatUser);
        return new RedirectView("/login");
    }
    ////////////////////////////////// LogOut ///////////////////////////////////
    @PostMapping("/logout")
    public RedirectView logOutUserWithSecret(HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        session.invalidate();

        return new RedirectView("/hello");
    }
}
