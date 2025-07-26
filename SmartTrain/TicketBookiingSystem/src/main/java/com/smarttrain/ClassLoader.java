package com.smarttrain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.smarttrain.repository.BookingRepository;
import com.smarttrain.repository.TrainRepository;
import com.smarttrain.repository.UserRepository;
import com.smarttrain.entity.*;

@Component
public class ClassLoader implements CommandLineRunner{

	 @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public void run(String... args) throws Exception {
        if (repo.findByEmail("admin").isEmpty()) {
            User admin = new User();
            admin.setName("admin");
            admin.setEmail("admin77@gmail.com");
            admin.setPassword(encoder.encode("admin123"));
            admin.setRole(Role.ADMIN);
            repo.save(admin);
        }

        if (repo.findByEmail("user").isEmpty()) {
            User user = new User();
            user.setName("user");
            user.setEmail("Sandu00@gmal.com");
            user.setPassword(encoder.encode("user123"));
            user.setRole(Role.USER);
            repo.save(user);
        }
    }

}
