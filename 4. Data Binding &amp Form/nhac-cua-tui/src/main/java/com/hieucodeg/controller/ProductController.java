package com.hieucodeg.controller;

import com.hieucodeg.model.Song;
import com.hieucodeg.model.SongForm;
import com.hieucodeg.service.ISongService;
import com.hieucodeg.service.SongService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("")
public class ProductController {
    @Value("${file-upload}")
    private String fileUpload;
    private final ISongService songService = new SongService();
    private final List<String> listType = Arrays.asList("Pop", "Dance", "Viet", "Other");

    @GetMapping("")
    public String index(Model model) {
        List<Song> songList = songService.findAll();
        model.addAttribute("songList", songList);
        return "/index";
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("songForm", new SongForm());
        modelAndView.addObject("listType",listType);
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveProduct(@ModelAttribute SongForm songForm) {
        MultipartFile multipartFile = songForm.getSong();
        String fileName = multipartFile.getOriginalFilename();
        if (!fileName.endsWith(".mp3") && !fileName.endsWith(".wav") && !fileName.endsWith(".ogg") && !fileName.endsWith(".m4p")) {
            ModelAndView modelAndView = new ModelAndView("/create");
            modelAndView.addObject("message","Chi chap nhan duoi .mp3/.wav/.ogg/.m4p");
            modelAndView.addObject("songForm", new SongForm());
            modelAndView.addObject("listType",listType);
            return modelAndView;
        }
        try {
            songForm.getSong().transferTo(new File(fileUpload + fileName));
//            FileCopyUtils.copy(songForm.getSong().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        Song song = new Song(songForm.getName(),
                songForm.getSinger(),songForm.getType(),fileName);
        songService.save(song);
        ModelAndView modelAndView = new ModelAndView("/index");
        List<Song> songList = songService.findAll();
        modelAndView.addObject("songList", songList);
        modelAndView.addObject("message", "Created new song successfully !");
        return modelAndView;
    }
}
