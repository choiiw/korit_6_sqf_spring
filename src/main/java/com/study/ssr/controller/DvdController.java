package com.study.ssr.controller;

import com.study.ssr.model.Dvd;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DvdController {

    @GetMapping("/dvds")
    public String dvdListPage(Model model) {
        Dvd dvd = Dvd.builder()
                .title("테스트")
                .producer("테스트 제작사")
                .publisher("테스트 발행사")
                .build();
        Dvd dvd2 = Dvd.builder()
                .title("테스트2")
                .producer("테스트2 제작사")
                .publisher("테스트2 발행사")
                .build();
        Dvd dvd3 = Dvd.builder()
                .title("테스트3")
                .producer("테스트3 제작사")
                .publisher("테스트3 발행사")
                .build();

        model.addAttribute(dvd);  // 객체

        model.addAttribute("names", List.of("김준일","김준이","김준삼")); // 리스트

        model.addAttribute("dvdList", List.of(dvd, dvd2, dvd3));

        model.addAttribute("title", "테스트 제목"); // 리터널

        return "views/dvd_list";
    }

//    @GetMapping("/dvds")
//    public ModelAndView dvdListPage() {
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("views/dvd_list");
//        return mav;
//    }

    @ResponseBody  // 응답 데이터가 바로 클라이언트에 리턴됨
    @GetMapping("/dvds/body")
    public String getViewName() {
        return "views/dvd_list";
    }

    @ResponseBody
    @GetMapping("/dvd")
    public Object getDvd() {
        //  아래처럼 객체를 리턴할 때는 Dvd를 객체로 잡아줘야함
        Dvd dvd = Dvd.builder().title("테스트").producer("테스트 제작사").publisher("테스트 발행사").build();
        Dvd dvd2 = Dvd.builder().title("테스트2").producer("테스트 제작사2").publisher("테스트 발행사2").build();
        Dvd dvd3 = Dvd.builder().title("테스트3").producer("테스트 제작사3").publisher("테스트 발행사3").build();

        return List.of(dvd, dvd2,dvd3);
    }
}
