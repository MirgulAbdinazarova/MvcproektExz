package peaksoft.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.model.Instructor;
import peaksoft.repository.InstructorRepository;
import peaksoft.service.InstructorService;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class InstructorServiceImpl implements InstructorService {

   private final InstructorRepository instructorRepository;
   @Autowired
    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public void assignInstructorToCourse(Long instructorId, Long courseId) {
        instructorRepository.assignInstructorToCourse(instructorId,courseId);
    }

    @Override
    public List<Instructor> getAllInstructors(Long id) {
        return instructorRepository.getAllInstructors(id);
    }

    @Override
    public void saveInstructor(Instructor instructor,Long id) {
    instructorRepository.saveInstructor(instructor,id);
    }

    @Override
    public void updateInstructor(Instructor instructor, Long id) {
     instructorRepository.updateInstructor(instructor,id);
    }

    @Override
    public void deleteInstructorById(Long id) {
     instructorRepository.deleteInstructorById(id);
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return instructorRepository.getInstructorById(id);
    }
}
