package com.evolution.user.cloud.stream;

import com.evolution.user.core.state.UserState;
import com.evolution.user.layer.query.model.UserModel;
import com.evolution.user.layer.query.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import java.util.Optional;

@EnableBinding(Sink.class)
public class UserStateSink {

    private static final Logger logger = LoggerFactory.getLogger(UserStateSink.class);

    @Autowired
    private UserRepository userRepository;

    @StreamListener(Sink.INPUT)
    public void setState(UserState state) {
        logger.info("Catch user state:" + state);

        UserModel model = new UserModel();
        Optional<UserModel> or = userRepository.findById(state.getKey());
        if (or.isPresent()) {
            model = or.get();
        }

        model.setKey(state.getKey());
        model.setEventNumber(state.getEventNumber());
        model.setUsername(state.getUsername());
        model.setPassword(state.getPassword());
        model.setLastName(state.getLastName());
        model.setFirstName(state.getFirstName());

        userRepository.save(model);
    }
}
