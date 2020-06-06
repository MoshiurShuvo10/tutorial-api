package com.moshiur457.tutorial.repository;

import com.moshiur457.tutorial.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorialRepository extends JpaRepository<Tutorial,Integer> {

}
