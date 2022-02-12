package com.mypractice.user.service;

import com.mypractice.user.VO.Department;
import com.mypractice.user.VO.RestTemplateVO;
import com.mypractice.user.entity.User;
import com.mypractice.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public RestTemplateVO findUserByUserId(Long id) {
        RestTemplateVO restTemplateVO = new RestTemplateVO();
        User user = userRepository.findUserByUserId(id);
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE:9001/departments/"+user.getDepartmentId(),Department.class);
        restTemplateVO.setUser(user);
        restTemplateVO.setDepartment(department);
        return restTemplateVO;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
