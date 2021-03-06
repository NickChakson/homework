package ru

import ru.data.Attachment.*
import ru.data.Comment
import ru.data.Likes
import ru.data.Post
import ru.data.Repost
import ru.service.WallService

fun main() {

    val original = Post(
        id = 0,
        ownerId = 6,
        fromId = 75,
        createdBy = 1,
        date = 2342562,
        text = "Some text",
        replyOwnerId = 1,
        replyPostId = 1,
        friendsOnly = true,
        comment = Comment(1, canPost = true, groupsCanPost = true),
        likes = Likes(1, userLikes = true, canLike = true, canPublish = true),
        reposts = Repost(1, userReposted = true),
        postType = "Post",
        signerId = 1,
        canPin = true,
        canDelete = true,
        canEdit = true,
        isPinned = true,
        markedAsAds = true,
        isFavorite = true
    )
    val service = WallService()
//    val addedPost = service.add(original)//with generated id
//    val updatedPost = addedPost.copy(text = "New Text", friendsOnly = false, canPin = false,ownerId = 0,date = 0)
//    service.update(updatedPost)
//    service.printPosts()

    val photoAtt = Photo(type = "Photo", id = 1, albumId = 2, ownerId = 3, userId =  4, text = "Photo description")
    val videoAtt = Video(type = "Video", id =  1, ownerId =  2, title = "Video title", description = "Video description", duration = 60)
    val linkAtt = Link(type = "Link", url = "Link URL", title = "Link title", caption = null, description = "Link description", photo = photoAtt)
    val pollAtt = Poll(type = "Poll", id = 1, ownerId = 2, created = -386_380_800, question = "Poll question", votes = 4)
    val noteAtt = Note(type = "Note", id = 1, ownerId = 2, title = "Note title", text = "Note text", date = -386_380_800,comments = 5)

    service.addAttachment(photoAtt)
    service.addAttachment(videoAtt)
    service.addAttachment(linkAtt)
    service.addAttachment(pollAtt)
    service.addAttachment(noteAtt)

    service.allAttachmentsActions()
}

