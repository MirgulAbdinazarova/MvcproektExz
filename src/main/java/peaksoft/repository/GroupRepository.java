package peaksoft.repository;

import peaksoft.model.Course;
import peaksoft.model.Group;

import java.util.List;

public interface GroupRepository {

//    void saveGroup(Group group, Long id);
    void saveGroup(Group group);

    List<Group> getAllGroups(Long courseId);   //course id

  void updateGroup(Group group,Long id);


    void deleteGroupById(Long id);

    Group getGroupById(Long id);
}
