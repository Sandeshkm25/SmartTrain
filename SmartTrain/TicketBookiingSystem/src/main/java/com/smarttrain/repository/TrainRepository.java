package com.smarttrain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.smarttrain.entity.Train;

public interface TrainRepository extends JpaRepository<Train, Long>{

	@Query("SELECT t FROM Train t WHERE LOWER(t.source) = LOWER(:source) AND LOWER(t.destination) = LOWER(:destination)")
	List<Train> searchTrain(@Param("source") String source, @Param("destination") String destination);

}
