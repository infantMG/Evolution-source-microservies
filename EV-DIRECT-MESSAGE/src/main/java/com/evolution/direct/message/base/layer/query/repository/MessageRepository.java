package com.evolution.direct.message.base.layer.query.repository;

import com.evolution.direct.message.base.layer.query.model.MessageModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "message")
public interface MessageRepository extends MongoRepository<MessageModel, String> {
}