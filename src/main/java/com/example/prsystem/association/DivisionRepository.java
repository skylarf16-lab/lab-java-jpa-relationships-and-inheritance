package com.example.prsystem.association;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DivisionRepository extends JpaRepository<Division, Long>  {
    List<Division> findByDistrict(String district);
}
