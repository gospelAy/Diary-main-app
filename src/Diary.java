import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Diary {
    private List<DiaryContent> diaryContentList = new ArrayList<>();

    public int getDiarySize() {
        return diaryContentList.size();
    }

    public void createContent(String tile, String body) {
        int id = getDiarySize() + 1;
        DiaryContent content = new DiaryContent(id, tile, body);
        diaryContentList.add(content);
    }

    public DiaryContent findById(int id) {
//        for (DiaryContent content:diaryContentList) {
//            if (content.getId() == id)return content;
//        }
        return diaryContentList.get(id - 1);
//        return null;
    }

    public List<DiaryContent> viewAll() {
        return diaryContentList;
    }

    public List<DiaryContent> findByDate(String date) {
        List<DiaryContent> contentsByDate = new ArrayList<>();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate convertedDate = LocalDate.parse(date, format);
        for (DiaryContent content : diaryContentList) {
            if (content.getEntryDate().equals(convertedDate)) contentsByDate.add(content);
        }
        return contentsByDate;
    }

    public void updateDiaryContent(int id, String updatedTitle, String updatedBody) {
        DiaryContent foundDiaryContent = findById(id);
        foundDiaryContent.setTitle(updatedTitle);
        foundDiaryContent.setBody(updatedBody);
        foundDiaryContent.setUpdatedTime(LocalDate.now());
//        diaryContentList.add(id - 1, foundDiaryContent);
//        diaryContentList.add(foundDiaryContent);
    }
    public void deleteContent(int id){
        DiaryContent deleteContent = findById(id);
        if (deleteContent == findById(id))
            diaryContentList.remove(deleteContent);
    }
    public void deleteContentByDate(String date) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate convertedDate = LocalDate.parse(date, format);

        for (int i = 0; i < diaryContentList.size(); i++) {
            DiaryContent content = diaryContentList.get(i);
            if (content.getEntryDate().equals(convertedDate)) {
                diaryContentList.remove(i);
                i--;
            }
        }
//    public void deleteContentByDate(String date) {
//        List<DiaryContent> contentsToRemoveByDate = new ArrayList<>();
//        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate convertedDate = LocalDate.parse(date, format);
//        for (DiaryContent content : diaryContentList) {
//            if (content.getEntryDate().equals(convertedDate)) {
////                contentsToRemove.add(content);
////                diaryContentList.remove(contentsToRemove);
//        }
//        public List<DiaryContent> findByDate(String date) {
//            List<DiaryContent> contentsByDate = new ArrayList<>();
//            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//            LocalDate convertedDate = LocalDate.parse(date, format);
//            for (DiaryContent content : diaryContentList) {
//                if (content.getEntryDate().equals(convertedDate)) contentsByDate.add(content);
//            }
//            return contentsByDate;
//        }


    }

//    public void deleteContentByDate(String date) {
//        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate convertedDate = LocalDate.parse(date, format);
//
//        for(DiaryContent content : diaryContentList) {
//            if (content.getEntryDate().equals(convertedDate))
//                diaryContentList.remove(content);
//
//        }
//    }

//    public void deleteContentByDate(String date) {
//        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate convertedDate = LocalDate.parse(date, format);
//        diaryContentList.removeIf(content -> content.getEntryDate().equals(convertedDate));
//    }
//public void deleteContentByDate(String date) {
//    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//    LocalDate convertedDate = LocalDate.parse(date, format);
//
//    for (int i = 0; i < diaryContentList.size(); i++) {
//        DiaryContent content = diaryContentList.get(i);
//        if (content.getEntryDate().equals(convertedDate)) {
//            diaryContentList.remove(i);
//            i--;
//        }
//    }
//}



//    public void deleteContent(int id) {
//        List<DiaryContent> contentFirst = new ArrayList<>();
//        for (DiaryContent content : diaryContentList) {
//            if (content.getId() == id)
//                diaryContentList.remove(id - 1);
//                return String.format("""
//                         Your Title is deleted successfully: %s
//                         """ diaryContentList.remove(content));


}



