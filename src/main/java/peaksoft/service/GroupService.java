package peaksoft.service;

import peaksoft.model.Group;

import java.util.List;

public interface GroupService {

//    void saveGroup(Group group, Long id);
    void saveGroup(Group group);

    List<Group> getAllGroups(Long courseId);


    void updateGroup(Group group,Long id);

    void deleteGroupById(Long id);

    Group getGroupById(Long id);
}
