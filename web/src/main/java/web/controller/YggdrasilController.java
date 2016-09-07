package web.controller;

import DTO.BookDTO;
import access.CacheReader;
import entities.Book;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class YggdrasilController {

    @Autowired
    private CacheReader cacheReader;

    @Autowired
    ModelMapper modelMapper;

    private List<BookDTO> convertToDTO(List<Book> books) {
        return books.stream().map(book -> modelMapper.map(book, BookDTO.class)).collect(Collectors.toList());
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView model = new ModelAndView();
        List<BookDTO> empik = convertToDTO(cacheReader.getBooksFromCache("EMPIK"));
        List<BookDTO> publio = convertToDTO(cacheReader.getBooksFromCache("PUBLIO"));
        model.addObject("empik", empik);
        model.addObject("publio", publio);
        return model;
    }


    @RequestMapping(value = "/register")
    public ModelAndView register() {
        return new ModelAndView();
    }

    @RequestMapping(value = "/account")
    public ModelAndView account() {
        return new ModelAndView();
    }


}
