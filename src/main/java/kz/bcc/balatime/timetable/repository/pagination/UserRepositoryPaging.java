package kz.bcc.balatime.timetable.repository.pagination;

import kz.bcc.balatime.timetable.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepositoryPaging extends PagingAndSortingRepository<User, Integer> {
    Page<User> findAll(Pageable pageable);
}
