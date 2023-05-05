import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DiaryTest {
    private Diary diary;

    @BeforeEach
    void setUp() {
        diary = new Diary();
    }
    @Test
    void testThatDB_SizeIncreasesByOneWhenANewContentIsAddedToDiary(){
        int sizeBeforeCreatingContent = diary.getDiarySize();
        assertEquals(0, sizeBeforeCreatingContent);
        String title = "First Content";
        String body = "My first diary content";
        diary.createContent(title, body);
        int sizeAfterCreatingContent = diary.getDiarySize();
        assertEquals(1, sizeAfterCreatingContent);
    }
    @Test
    void testThatIdCanBeUsedToRetrieveAContentFromDbUsingId(){
        String title = "First Content";
        String body = "My first diary content";
        diary.createContent(title, body);
        DiaryContent diaryContent = diary.findById(1);
        assertEquals("First Content", diaryContent.getTitle());
    }

    @Test
    void testThatIfTwoItemsAreSavedInDB_ViewAllReturnsTwoItem(){
        int viewAllBeforeAddingContents = diary.viewAll().size();
        assertEquals(0, viewAllBeforeAddingContents);
        String title = "First Content";
        String body = "My first diary content";
        diary.createContent(title, body);

        String secondTitle = "Second Content";
        String secondBody = "My second diary content";
        diary.createContent(secondTitle, secondBody);

        int viewAllAfterAddingContents = diary.viewAll().size();
        assertEquals(2, viewAllAfterAddingContents);
    }
    @Test
    void testThatContentsCanBeFoundUsingDate(){
        String secondTitle = "Second Content";
        String secondBody = "My second diary content";
        diary.createContent(secondTitle, secondBody);
        List<DiaryContent> contents = diary.findByDate("2023-03-14");
        String theSecondTitle = "Second Content";
        String theSecondBody = "My second diary content";
        assertEquals(1,contents.size());
    }

    @Test
    void testThatDiaryContentsCanBeUpdated(){
        String secondTitle = "Second Content";
        String secondBody = "My second diary content";
        diary.createContent(secondTitle, secondBody);
        DiaryContent foundContentBeforeUpdate = diary.findById(1);
        assertEquals("Second Content", foundContentBeforeUpdate.getTitle());
        assertEquals("My second diary content", foundContentBeforeUpdate.getBody());
        System.out.println(diary.findById(1));

        String updatedTitle = "Title updated";
        String updatedBody = "Body updated";
        diary.updateDiaryContent(1,updatedTitle, updatedBody);

        DiaryContent foundContentAfterUpdate = diary.findById(1);
        assertEquals("Title updated", foundContentAfterUpdate.getTitle());
        assertEquals("Body updated", foundContentAfterUpdate.getBody());

        int sizeAfterCreatingContent = diary.getDiarySize();
        assertEquals(1, sizeAfterCreatingContent);
        System.out.println(diary.findById(1));

    }
//    @Test
//    public void testThatContentCanBeDeleted(){
//        int sizeBeforeCreatingContent = diary.getDiarySize();
//        assertEquals(0, sizeBeforeCreatingContent);
//        String title = "First Content";
//        String body = "My first diary content";
//        diary.createContent(title, body);
//        int sizeAfterCreatingContent = diary.getDiarySize();
//        assertEquals(1, sizeAfterCreatingContent);
////        assertEquals(0, diary.getDiarySize());

//        String secondTitle = "Second Content";
//        String secondBody = "My second diary content";
//        diary.createContent(secondTitle, secondBody);
//        diary.deleteContent();
//        List<DiaryContent> contents = diary.deleteContent();
//        assertEquals(0, diary.getDiarySize());
//    }
    @Test
    public void testThatContentCanBeDeletedById(){
        String title = "First Content";
        String body = "My first diary content";
        diary.createContent(title, body);
        int sizeAfterCreatingContent = diary.getDiarySize();
        assertEquals(1, sizeAfterCreatingContent);
        diary.deleteContent(1);
        assertEquals(0, diary.getDiarySize());
    }
    @Test
    public void testThatContentCanBeDeletedByDate(){
        String firstTitle = "This is my first title";
        String secondBody = "This is my second body";
        diary.createContent(firstTitle, secondBody);
        int sizeAfterCreatingContent = diary.getDiarySize();
        assertEquals(1, sizeAfterCreatingContent);
        diary.deleteContentByDate("2023-03-14");
        assertEquals(0, diary.getDiarySize());
    }
}