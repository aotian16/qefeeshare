package com.qefee.qefeeshare.controller;

import com.qefee.qefeeshare.entity.PostPO;
import com.qefee.qefeeshare.entity.dobj.PostDO;
import com.qefee.qefeeshare.service.PostService;
import com.qefee.qefeeshare.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(path = "/posts")
    public String getAllPost(@PageableDefault(value = 8, sort = {"modifyAt"}, direction = Sort.Direction.DESC) Pageable pageable, Model model) {
        Page<PostDO> postDOPage = postService.getPostByStatus("0", pageable);

        int elementPerRow = 1;
        int totalElements = (int) postDOPage.getTotalElements();
        int numberOfElements = postDOPage.getNumberOfElements();
        int i = numberOfElements % elementPerRow;
        int rows = numberOfElements / elementPerRow;
        int rowCount = i == 0 ? rows : rows + 1;
        model.addAttribute("postPage", postDOPage);
        model.addAttribute("elementPerRow", elementPerRow);
        model.addAttribute("rowCount", rowCount);

        return "posts";
    }

    @GetMapping(path = "/posts1")
    public @ResponseBody
    Page<PostDO> getAllPost(@PageableDefault(value = 10, sort = {"modifyAt"}, direction = Sort.Direction.DESC) Pageable pageable) {
        Page<PostDO> postDOPage = postService.getPostByStatus("0", pageable);
        return postDOPage;
    }

    @RequestMapping(value = {"/", "/index.html"})
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String post(PostPO post, HttpServletRequest request) {
        post.setIp(WebUtils.getClientIp(request));
        post.setStatus("0");
        PostPO postSaved = postService.save(post);

        System.out.println("=======");
        System.out.println(post.getIp());
        System.out.println(post.getAuthorId());
        System.out.println(post.getContent());
        System.out.println(post.getFrom());
        System.out.println(post.getId());
        System.out.println(post.getStatus());
        System.out.println(post.getTitle());
        System.out.println(post.getCreateAt());
        System.out.println(post.getModifyAt());

        return "redirect:/posts";
    }

    @GetMapping(path = "/newPost")
    public String newPost() {
        return "newPost";
    }
}
