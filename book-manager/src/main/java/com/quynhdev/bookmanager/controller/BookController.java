package com.quynhdev.bookmanager.controller;

import com.quynhdev.bookmanager.dto.BookDTO;
import com.quynhdev.bookmanager.model.Book;
import com.quynhdev.bookmanager.service.BookService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping("/list")
    public String listBook(ModelMap model,
                           @RequestParam("page") Optional<Integer> page,
                           @RequestParam("size") Optional<Integer> size) {

        int currentPage = page.orElse(1);
        int pageSize = size.orElse(4);

        Page<Book> bookPage = bookService.findPaginated(PageRequest.of(currentPage - 1, pageSize));

        model.addAttribute("LIST_BOOK", bookPage);

        int totalPages = bookPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "view-books";
    }

    @GetMapping("/add")
    public String add(ModelMap model) {
        BookDTO book = new BookDTO();
        model.addAttribute("BOOKDTO", book);
        model.addAttribute("ACTION", "/books/save");
        return "add-book";
    }

    @PostMapping("/save")
    public String save(ModelMap model, @ModelAttribute("BOOKDTO") @Valid BookDTO dto) throws IOException {
        String image = "anh.png";
        Path path = Paths.get("uploads/");

        if (!dto.getPhoto().isEmpty()) {
            InputStream inputStream = dto.getPhoto().getInputStream();
            Files.copy(inputStream, path.resolve(dto.getPhoto().getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);
            image = dto.getPhoto().getOriginalFilename().toString();
        }

        Book book = new Book(dto.getName(), dto.getDetail(), dto.getCount(), image);

        try {
            bookService.save(book);
            model.addAttribute("LIST_BOOK", bookService.findAll());
            return "view-books";
        } catch (Exception ex) {
            model.addAttribute("SAVE_ERROR", "Giá trị nhập vào không hợp lệ!");
        }
        return "add-book";
    }

    @PostMapping("/update")
    public String update(ModelMap model, @ModelAttribute("BOOKDTO") @Valid BookDTO dto) throws IOException {
        Optional<Book> optionalBook = bookService.findById(dto.getId());
        Path path = Paths.get("uploads/");
        Book book = optionalBook.get();
        String image = book.getPhoto();

        if (!dto.getPhoto().isEmpty()) {
            InputStream inputStream = dto.getPhoto().getInputStream();
            Files.copy(inputStream, path.resolve(dto.getPhoto().getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);
            image = dto.getPhoto().getOriginalFilename().toString();
        }

        book.setName(dto.getName());
        book.setDetail(dto.getDetail());
        book.setCount(dto.getCount());
        book.setPhoto(image);

        try {
            bookService.save(book);
            model.addAttribute("LIST_BOOK", bookService.findAll());
            return "view-books";
        } catch (Exception ex) {
            model.addAttribute("EDIT_ERROR", "Giá trị sửa không hợp lệ!");
        }
        return "edit-book";
    }

    @RequestMapping("/edit/{id}")
    //Dữ liệu trả về sẽ được ghi đè vào cache book (luôn được thực thi kể cả đã có dữ liệu trong cache hay chưa)
    @CachePut(value = "book", key = "#id")
    public String edit(ModelMap model, @PathVariable(name = "id") Long id) throws IOException {
        Optional<Book> optionalBook = bookService.findById(id);

        Book book = optionalBook.get();
        File file = new File("uploads/" + book.getPhoto());
        FileInputStream input = new FileInputStream(file);
        MultipartFile multiPhoto = new MockMultipartFile("file", file.getName(), "text/plain",
                IOUtils.toByteArray(input));
        BookDTO dto = new BookDTO(book.getId(), book.getName(), book.getDetail(), book.getCount(), multiPhoto);
        model.addAttribute("BOOKDTO", dto);

        model.addAttribute("ACTION", "/books/update");
        return "edit-book";
    }

    @RequestMapping("/delete/{id}")
    ////Xóa dữ liệu với id tương ứng ở trong cache book
    @CacheEvict(value = "book", key = "#id")
    public String delete(ModelMap model, @PathVariable(name = "id") long id) {
        try {
            bookService.deleteById(id);
        } catch (Exception ex) {
            System.err.println("Bảng này không xóa được hihi");
        }
        model.addAttribute("LIST_BOOK", bookService.findAll());
        return "view-books";
    }


    @GetMapping("/search")
    //Kết quả của hàm này sẽ được lưu vào bộ nhớ cache với tên là book
    @Cacheable(value = "book", key = "#name")
    public String search(ModelMap model, @RequestParam(name = "name", required = false) String name) {
        if (StringUtils.hasText(name)) {
            model.addAttribute("LIST_BOOK", bookService.findByNameContaining(name));
        } else {
            model.addAttribute("LIST_BOOK", bookService.findAll());
        }
        return "view-books";
    }

}





















