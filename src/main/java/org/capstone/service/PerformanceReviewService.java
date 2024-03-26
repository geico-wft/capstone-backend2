package org.capstone.service;

import org.capstone.Main;
import org.capstone.entity.Employee;
import org.capstone.entity.PerformanceReview;
import org.capstone.repository.PerformanceReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerformanceReviewService {
    PerformanceReviewRepository performanceReviewRepository;

    @Autowired
    public PerformanceReviewService(PerformanceReviewRepository performanceReviewRepository) {
        this.performanceReviewRepository = performanceReviewRepository;
        PerformanceReview p = new PerformanceReview();
        p.setGoalType("temp");
        p.setWeight(10);
        p.setEmployeeComments("temp1");
        this.performanceReviewRepository.save(p);

    }

    public List<PerformanceReview> getAllPerformanceReview() {
        Main.logger.info("Performance Review Get: Attempting to get all performance reviews.");
        return performanceReviewRepository.findAll();
    }

    public List<Employee> getAllEmployeeByManagerID(int managerID){
        return performanceReviewRepository.findEmployeeByManagerID(managerID);
    }
}
