import java.time.LocalDate;

public class DiaryContent {
    private final int id;
    private String title;
    private LocalDate entryDate = LocalDate.now();
    private String body;
    private LocalDate updatedTime = LocalDate.now();

    public LocalDate getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDate updatedTime) {
        this.updatedTime = updatedTime;
    }

    public DiaryContent(int id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public int getId() {
        return id;
    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DiaryContent{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", entryDate=").append(entryDate);
        sb.append(", body='").append(body).append('\'');
        sb.append(", updatedTime=").append(updatedTime);
        sb.append('}');
        return sb.toString();
    }
}
