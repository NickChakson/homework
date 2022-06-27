package ru

import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import ru.data.Comment
import ru.data.Likes
import ru.data.Post
import ru.data.Repost
import ru.service.WallService

class WallServiceTest {
    private val service = WallService()
    private val original = Post(
        id = 0,
        ownerId = 6,
        fromId = 1,
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

    @Test
    fun addTest() {
        val addedPost = service.add(original)
        val unexpectedId = 0
        assertNotEquals(unexpectedId, addedPost.id)
    }

    @Test
    fun updateNotExistTest() {
        service.add(original)
        val update = original.copy(id = 0)
        val result = service.update(update)
        assertFalse(result)
    }

    @Test
    fun updateExistTest() {
        val update = service.add(original)
        val result = service.update(update)
        assertTrue(result)
    }
}
