package peaksoft.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.model.Group;
import peaksoft.repository.GroupRepository;
import peaksoft.service.GroupService;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    @Autowired
    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

//    @Override
//    public void saveGroup(Group group, Long id) {
//        groupRepository.saveGroup(group,id);
//    }
    @Override
    public void saveGroup(Long id,Group group) {
        groupRepository.saveGroup(id,group);
    }

    @Override
    public List<Group> getAllGroups(Long courseId) {
        return groupRepository.getAllGroups(courseId);
    }

    @Override
    public void updateGroup(Group group,Long id) {
        groupRepository.updateGroup(group,id);
    }

    @Override
    public void deleteGroupById(Long id) {
     groupRepository.deleteGroupById(id);
    }

    @Override
    public Group getGroupById(Long id) {
        return groupRepository.getGroupById(id);
    }

    @Override
    public void assignGroupToCourse(Long groupId, Long courseId) {
        groupRepository.assignGroupToCourse(groupId,courseId);
    }
}
