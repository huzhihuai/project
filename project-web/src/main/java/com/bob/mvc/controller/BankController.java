package com.bob.mvc.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.bob.mvc.model.BankUser;
import com.bob.mvc.service.BankUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 银行控制器
 *
 * @author wb-jjb318191
 * @create 2017-12-05 14:01
 */
@RestController()
@RequestMapping("/bank")
public class BankController {

    @Autowired
    private BankUserService bankUserService;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public boolean createUser(@RequestBody BankUser bankUser) {
        return bankUserService.create(bankUser) > 0;
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public BankUser getById(@PathVariable Integer id) {
        return bankUserService.retrieveById(id);
    }

    @RequestMapping(value = "/user/ids", method = RequestMethod.GET)
    public Map<Integer, BankUser> getByIds(Integer[] ids) {
        return bankUserService.retrieveByIds(Arrays.asList(ids));
    }

    @RequestMapping(value = "/user/age/{age}", method = RequestMethod.GET)
    public List<BankUser> getByAge(@PathVariable Integer age, int currentPage, int size) {
        return bankUserService.retrieveByAgeForPages(age, currentPage, size);
    }

}
