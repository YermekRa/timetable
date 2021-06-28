package kz.bcc.balatime.timetable.service.impl.admin;

import kz.bcc.balatime.timetable.model.Timetable;
import kz.bcc.balatime.timetable.repository.TimetableRepository;
import kz.bcc.balatime.timetable.service.admin.TimetableService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimetableServiceImpl implements TimetableService {
    @Autowired
    TimetableRepository timetableRepository;
//    @Autowired
//    private TimetableRepositoryPaging timetableRepositoryPaging;

    @Override
    public Timetable create(Timetable timetable) {
        return timetableRepository.save(timetable);
    }

    @Override
    public Timetable getById(Integer id) {
        Optional<Timetable> optionalTeacher = timetableRepository.findById(id);
        if (optionalTeacher.isPresent()) {
            return timetableRepository.findById(id).get();
        } else {
            return null;
        }
    }

    @Override
    public List<Timetable> getAll() {
        return timetableRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        timetableRepository.deleteById(id);
    }

//    @Override
//    public Page<Timetable> getAllByPageAndSize(Integer page, Integer size) {
//        Pageable pageable = PageRequest.of(page, size);
//        return timetableRepositoryPaging.findAll(pageable);
//    }
}
