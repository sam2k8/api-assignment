package com.pluang.assignment.repository;


import com.pluang.assignment.entity.Search;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchResultRepository extends JpaRepository<Search, Long> {
    List<Search> findAllBySearchItem(long item);
    Search findBySearchItem(long item);

}
