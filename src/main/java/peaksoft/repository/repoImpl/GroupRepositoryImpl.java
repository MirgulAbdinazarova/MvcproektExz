package peaksoft.repository.repoImpl;

import org.springframework.stereotype.Repository;
import peaksoft.model.Course;
import peaksoft.model.Group;
import peaksoft.repository.GroupRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Repository
@Transactional
public class GroupRepositoryImpl implements GroupRepository {

    @PersistenceContext
    private EntityManager entityManager;

//    @Override
//    public void saveGroup(Group group, Long id) {    //courseId
//    Course course = entityManager.find(Course.class,id);
//       course.addGroup(group);
//       group.addCourse(course);
//       entityManager.merge(group);
//
//    }

    @Override
    public void saveGroup(Long id,Group group) {
        Course course = entityManager.find(Course.class,id);
        course.addGroup(group);
        group.addCourse(course);
        entityManager.merge(group);
    }

    @Override
    public List<Group> getAllGroups(Long courseId) {
        List<Group>groups= entityManager.createQuery("select g from Group g  ",Group.class).getResultList();
           for(Group group:groups) {
               for (int i = 0; i < group.getCourses().size(); i++) {
                   if(group.getCourses().get(i).getId().equals(courseId)) {

                   }
               }
           }

        return groups;
    }

    @Override
    public void updateGroup(Group group,Long id) {
        Group group1 = entityManager.find(Group.class,id);
        group1.setGroupName(group.getGroupName());
        group1.setDateOfStart(group.getDateOfStart());
      entityManager.merge(group1);
    }


    @Override
    public void deleteGroupById(Long id) {
   entityManager.remove(entityManager.find(Group.class,id));
    }

    @Override
    public Group getGroupById(Long id) {
        return entityManager.find(Group.class,id);
    }

    @Override
    public void assignGroupToCourse(Long groupId,Long courseId) {
        Group group = entityManager.find(Group.class,groupId);
        Course course = entityManager.find(Course.class,courseId);
        group.getCourses().add(course);
        course.getGroups().add(group);
        entityManager.merge(group);
        entityManager.merge(course);
    }
}
