package com.example.demo_app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// @Service annotation make the class sigletone.
// It gets ititalized once application starts.
// It can be injected into congtroller using @Autowired annotation.

@Service
public class TopicService {
	
	@Autowired
	HNSRepository repository;

/*	List<Topic> topicList = new ArrayList(Arrays.asList(new Topic(1,"bharti",23), 
										  new Topic(2,"bharti",23),
										  new Topic(3,"bharti",23)));*/
	
	public List<Topic> getAllTopies() {
		List<Topic> topicList = new ArrayList<>();
		repository.findAll().forEach(topicList::add);
		return topicList;
	}
	
	public Topic getTopicsById(String id) {
		Integer id1 = Integer.parseInt(id);
		return repository.findOne(id1);
		//return topicList.stream().filter(t -> t.getId().equals(id1)).findFirst().get();
	}
	
	public void postTopic(Topic topic) {
		repository.save(topic);
		 
	}
	
	/*public List<Topic> postTopicList(List<Topic> topic) {
		  topicList.addAll(topic);
		  return topicList;
	}*/
	

	public void updateTopic(String id, Topic updatedtopic) {
		repository.save(updatedtopic);
		  
	}

public void deleteTopic(String id) {
	Integer id1 = Integer.parseInt(id);
	repository.delete(id1);
}

}
