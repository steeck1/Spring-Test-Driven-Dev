package io.javabrains.springbootstarter.topic;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;

	private List<Topic> topics = new ArrayList<> (Arrays.asList(
		
				
				new Topic("spring", "Spring Framework", "Spring Framework Description"),
				new Topic("java", "Java Core", "Core Java Description"),
				new Topic("javascript", "Javascript", "Javascript Description")
				));
	
	public List<Topic> getAllTopics(){
		//return topics;
		List<Topic> topics	= new ArrayList<>();
		topicRepository.findAll()
		.forEach(topics :: add);
		return topics;
	}
	
	public Topic getTopic(String id) {
		  Topic t = topicRepository.findById(id).get();
		  return t;
		 }
	public void  updateTopic(String id, Topic topic) {
		topicRepository.save(topic);
	}

	public void addTopic(Topic topic) {
		// TODO Auto-generated method stub
		//topics.add(topic);
		topicRepository.save(topic);
	}

	public void addTopic(String id, Topic topic) {
		// TODO Auto-generated method stub
		for (int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			if (t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
			
		
			
		}
		
		
	}

	public void deleteTopic(String id) {
		// TODO Auto-generated method stub
		//topics.removeIf(t -> t.getId().equals(id));
		topicRepository.deleteById(id);
	}
	
	
}
