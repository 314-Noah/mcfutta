package de.noah.mcfutta.collections.order;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderRepository extends PagingAndSortingRepository<Order, String>{

	List<Order> findByStatusNot(int status);
	
}
