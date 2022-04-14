package com.dreamteam.TestingSystemNew.payload;

import com.dreamteam.TestingSystemNew.model.Group;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupResponse {
    String titleSubject;
    List<Group> groupList;
}
