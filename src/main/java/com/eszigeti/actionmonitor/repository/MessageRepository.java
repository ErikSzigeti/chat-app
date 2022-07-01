package com.eszigeti.actionmonitor.repository;

import com.eszigeti.actionmonitor.model.Message;
import com.eszigeti.actionmonitor.model.MessageStatus;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {
    @Modifying
    @Query("update Message m set m.status = ?1, m.timestamp = ?2 where m.id = ?3")
    int updateMessage(MessageStatus status, LocalDateTime timestamp, Long id);

    @Query("select m from Message m where (m.sender.id = ?1 and m.receiver.id = ?2) or (m.sender.id = ?2 and m.receiver.id = ?1) order by m.timestamp DESC")
    List<Message> findAllMessagesBetweenUsers(Long firstUserId, Long secondUserId);
}