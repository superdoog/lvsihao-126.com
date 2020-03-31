package com.lv.service;

import com.lv.mapper.BookMapper;
import com.lv.pojo.Book;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author lv
 */
@Service
public class BookServiceImpl implements BookService {

    @Resource
    private BookMapper bookMapper;

    @Override
    public List<Book> findAllBook(int currentPage, int pageSize) {
        List<Book> books = null;
        //换算索引
        int currentPageNo = (currentPage - 1) * pageSize;
        try {
            books = bookMapper.findAllBook(currentPageNo, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public int getCount() {
        int count = 0;
        try {
            count = bookMapper.getCount();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int deleteBybid(int bid) {
        int flag = 0;
        try {
            flag = bookMapper.deleteBybid(bid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public Book getBookBybid(int bid) {
        Book book = null;
        try {
            book = bookMapper.getBookBybid(bid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public int updateBook(Book book) {
        int flag = 0;
        try {
            flag = bookMapper.updateBook(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public Set<String> getBookType() {
        Set<String> type = new HashSet<>();
        try {
            type = bookMapper.getBookType();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return type;
    }

    @Override
    public int addBook(Book book) {
        int flag = 0;
        try {
            flag = bookMapper.addBook(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
