package com.example.demo_app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToipcsController {
	
	public ToipcsController() {
		System.out.println("inside class");
	}
	//This annotation returns already created instance of service by spring boot application
	@Autowired
	TopicService service;
	
    @RequestMapping("/topics")
	public List<Topic> getTopics(){
    	System.out.println("inside get request");
		return service.getAllTopies();
	}
    
    @RequestMapping("/topics/{foo}")
    //If Path variable is not used id will be passed as null
  	public Topic getTopicsById(@PathVariable("foo") String id){
  		return service.getTopicsById(id);
  	}
    //Add array list
    @RequestMapping(method=RequestMethod.POST , value = "/topics")
    public void postToipcs(@RequestBody Topic topic) {
    	 System.out.println("inside post request");
    	  service.postTopic(topic);
    }
    
   /* @RequestMapping(method=RequestMethod.POST , value = "/topicList")
    public List<Topic> postmultipleToipcs(@RequestBody List<Topic> topic) {
    	 System.out.println("inside post request");
    	  service.postTopicList(topic);
    }*/
    
    //Update function
    @RequestMapping(method=RequestMethod.PUT , value = "/topic/{id}")
    public void updateTopic(@PathVariable String id , @RequestBody Topic topic) {
    	 System.out.println("inside put request"+id +"topic" +topic.getId());
    	  service.updateTopic(id, topic);
    }
    
    @RequestMapping(method=RequestMethod.DELETE , value = "/topic/{id}")
    public void deleteTopic(@PathVariable String id) {
    	 System.out.println("inside delete request");
    	  service.deleteTopic(id);
    }
}
