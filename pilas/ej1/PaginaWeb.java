public class PaginaWeb {
    private String url;
    private String title;
    private String accessDate;
    
    public PaginaWeb() {
    }

    public PaginaWeb(String url, String title, String accessDate) {
        this.url = url;
        this.title = title;
        this.accessDate = accessDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAccessDate() {
        return accessDate;
    }

    public void setAccessDate(String accessDate) {
        this.accessDate = accessDate;
    }

    @Override
    public String toString() {
        return "PaginaWeb [url=" + url + ", title=" + title + ", accessDate=" + accessDate + "]";
    }
}
