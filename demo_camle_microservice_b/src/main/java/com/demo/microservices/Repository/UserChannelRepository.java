package com.demo.microservices.Repository;

import com.demo.microservices.dto.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserChannelRepository extends MongoRepository<Notification, String> {
}
