package com.evolution.direct.message.stream.processor.event;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.Wither;

import java.util.Date;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Wither
public class MessageStateEvent {

    String id;

    String text;

    String sender;

    String recipient;

    boolean isRead;

    Date datePost;

    Date datePut;
}