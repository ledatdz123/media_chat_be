package com.example.chatapp.repository;

import com.example.chatapp.model.Chat;
import com.example.chatapp.model.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat, Integer> {
    @Query("select c from Chat c join c.users u where u.userId=:userId")
    public List<Chat> findChatByUserId(@Param("userId") Integer userId);
    @Query("select c from Chat c where c.isGroup=false And :user Member of c.users And :redUser Member of c.users")
    public Chat findSingleChatByUserIds(@Param("user") UserApp user, @Param("redUser")UserApp redUser);
}
