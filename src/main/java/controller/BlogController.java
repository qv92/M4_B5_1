package controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.IBlogService;

import java.io.File;
import java.io.IOException;

@Controller
public class BlogController {
    @Value("${save-img}")
    private String fileUpload;
    @Autowired
    IBlogService blogService;

    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("show", "blogList", blogService.findAll());
    }
    @GetMapping("/create")
    public ModelAndView showCreate() {
        return new ModelAndView("create", "blog", new Blog());
    }
    @GetMapping("/remove")
    public ModelAndView remove(@RequestParam long id) {
        blogService.remove(id);
        return new ModelAndView("redirect:/");
    }
    @GetMapping("/edit")
    public ModelAndView showEdit(@RequestParam long id) {
        return new ModelAndView("edit", "blog", blogService.findByID(id));
    }
    @GetMapping("/detail")
    public ModelAndView showDetail(@RequestParam long id) {
        return new ModelAndView("detail", "blog", blogService.findByID(id));
    }
    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute Blog blog, @RequestParam MultipartFile blogImg) throws IOException {
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        String imgName = blogImg.getOriginalFilename();
        FileCopyUtils.copy(blogImg.getBytes(), new File(fileUpload + "img/" + imgName));
        blog.setImg("/resource/img/" + imgName);
        String intro = blog.getContent().substring(0, 220);
        blog.setIntro(intro);
        blogService.save(blog);
        return modelAndView;
    }
    @PostMapping("/edit")
    public ModelAndView edit(@ModelAttribute Blog blog, @RequestParam MultipartFile blogImg) throws IOException {
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        String imgName = blogImg.getOriginalFilename();
        FileCopyUtils.copy(blogImg.getBytes(), new File(fileUpload + "img/" + imgName));
        blog.setImg("/resource/img/" + imgName);
        String intro = blog.getContent().substring(0, 220);
        blog.setIntro(intro);
        blogService.save(blog);
        return modelAndView;
    }
}
