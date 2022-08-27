package com.cydeo.proxy;

import com.cydeo.model.Comment;

public interface CommentNotificationProxyInterface {

    void sendComment(Comment comment);
}
