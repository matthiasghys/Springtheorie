package be.vdab.luigi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

@Controller
@RequestMapping("os")
public class OsController {
    private static final String[] OSS = {"Windows", "Macintosh", "Android", "Linux"};
        @GetMapping
                public ModelAndView os(@RequestHeader("User-agent")String userAgent){
            ModelAndView modelAndView = new ModelAndView("os");
            Arrays.stream(OSS).filter(userAgent::contains).findFirst().ifPresent(os->modelAndView.addObject("os",os));
            return modelAndView;
        }

}
