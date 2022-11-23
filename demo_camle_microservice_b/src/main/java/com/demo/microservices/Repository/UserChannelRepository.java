package com.demo.microservices.Repository;

import com.demo.microservices.dto.UserChannel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserChannelRepository extends MongoRepository<UserChannel, String> {
}
